package com.bank.system.dao.implementation;

import com.bank.system.dao.daoInterface.AdminOperationsDao;
import com.bank.system.dao.rowMapper.TransactionRowMapper;
import com.bank.system.dao.rowMapper.UserRowMapper;
import com.bank.system.model.DepositTransaction;
import com.bank.system.model.TransactionReport;
import com.bank.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class AdminOperationsDbDao implements AdminOperationsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    UserRowMapper userRowMapper = new UserRowMapper();
    TransactionRowMapper transactionRowMapper = new TransactionRowMapper();

    @Override
    public List<User> selectAllUser() {
        final String query = "select * from users";
        return jdbcTemplate.query(query, userRowMapper);
    }

    @Override
    public List<TransactionReport> selectAllTransactions() {
        final String query = "select transaction_id, t.user_id, f_name, l_name, transaction_date, type, serial_number " +
                "from transactions t " +
                "inner join users u on t.user_id = u.user_id " +
                "inner join currency c on t.currency_id = c.currency_id;";
        return jdbcTemplate.query(query, transactionRowMapper);
    }

    @Override
    public int selectDailyDeposit(Date date) {
        final String  query = "select sum(type) " +
                "from transactions t " +
                "inner join currency c " +
                "on t.currency_id = c.currency_id "+
                "";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public int selectWeeklyDeposit() {
        LocalDate curDate = LocalDate.now();
        LocalDate fromDate = curDate.minusDays(7);

        final String query = "select sum(type) " +
                "from transactions t " +
                "inner join currency c " +
                " on t.currency_id = c.currency_id " +
                "where transaction_date <= ? and transaction_date > ?";

        return jdbcTemplate.queryForObject(query, Integer.class, curDate, fromDate);
    }

    @Override
    public List<User> selectTrackedUsers() {
        final String query = "select t.user_id, f_name, l_name from tracking t inner join users u on t.user_id = u.user_id";
        return jdbcTemplate.query(query, userRowMapper);
    }

    @Override
    public List<TransactionReport> getDepositsForUser(int userId) {
        final String query = "select transaction_id, t.user_id, f_name, l_name, transaction_date, type, serial_number " +
                "from transactions t " +
                "inner join users u on t.user_id = u.user_id " +
                "inner join currency c on t.currency_id = c.currency_id " +
                "where t.user_id = ?";
        return jdbcTemplate.query(query, transactionRowMapper, userId);
    }
}
