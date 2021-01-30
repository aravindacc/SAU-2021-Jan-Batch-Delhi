package com.bank.system.dao.implementation;

import com.bank.system.dao.daoInterface.UserOperationsDao;
import com.bank.system.dao.rowMapper.CurrencyRowMapper;
import com.bank.system.dao.rowMapper.UserRowMapper;
import com.bank.system.model.DepositTransaction;
import com.bank.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Objects;

@Repository
public class UserOperationsDbDao implements UserOperationsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final UserRowMapper rowMapper = new UserRowMapper();

    @Override
    public User addUser(User user) {
        final String query = "insert into users (f_name, l_name) values ( ? , ? )";
        //var x = jdbcTemplate.update(query, user.getFirstName(), user.getLastName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, new String[]{"user_id"});
            ps.setString(1, user.getFirstName().toLowerCase());
            ps.setString(2, user.getLastName().toLowerCase());
            return ps;
        }, keyHolder);

        user.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return user;
    }

    @Override
    public DepositTransaction makeTransaction(DepositTransaction transaction) {

        // check user exists
        final String get_users_query = "select user_id, f_name, l_name from users where user_id = ?";
        User user = jdbcTemplate.queryForObject(get_users_query, rowMapper, transaction.getUserId());
        if (user == null) {
            return null;
        }

        // if currency with same code exists track the user
        if (checkForDuplicateCurrency(transaction.getCurrencyNo())) {
            final String track_user_query = "insert into tracking (user_id)  values (?)";
            jdbcTemplate.update(track_user_query, user.getId());
            return null;
        }

        // add currency
        final String add_currency_query = "insert into currency (type, serial_number) values ( ? , ? )";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(add_currency_query, new String[]{"currency_id"});
            ps.setInt(1, transaction.getCurrency());
            ps.setInt(2, transaction.getCurrencyNo());
            return ps;
        }, keyHolder);

        int currencyId = Objects.requireNonNull(keyHolder.getKey()).intValue();

        // add transaction
        final String add_transaction_query = "insert into transactions (user_id, currency_id, transaction_date) values ( ? , ? , ? )";

        keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(add_transaction_query, new String[]{"transaction_id"});
            ps.setInt(1, transaction.getUserId());
            ps.setInt(2, currencyId);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            return ps;
        }, keyHolder);

        int transactionId = Objects.requireNonNull(keyHolder.getKey()).intValue();
        transaction.setTransactionId(transactionId);
        return transaction;

    }

    private boolean checkForDuplicateCurrency(int currencyNo) {
        final String check_query = "select count(*) as count from currency where serial_number = ?";
        int count = jdbcTemplate.queryForObject(check_query, new CurrencyRowMapper(), currencyNo);
        return count > 0;
    }
}


