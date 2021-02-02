package com.bank.system.dao.rowMapper;

import com.bank.system.model.DepositTransaction;
import com.bank.system.model.TransactionReport;
import com.bank.system.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<TransactionReport> {
    @Override
    public TransactionReport mapRow(ResultSet resultSet, int i) throws SQLException {
        TransactionReport report = new TransactionReport();
        report.setTransactionId(resultSet.getInt("transaction_id"));
        report.setUserId(resultSet.getInt("user_id"));
        report.setUserFirstName(resultSet.getString("f_name"));
        report.setUserLastName(resultSet.getString("l_name"));
        report.setDate(resultSet.getDate("transaction_date"));
        report.setCurrencyType(resultSet.getInt("type"));
        report.setCurrencyNo(resultSet.getInt("serial_number"));
        return report;
    }
}
