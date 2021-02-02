package com.bank.system.dao.implementation;

import com.bank.system.dao.daoInterface.BranchDao;
import com.bank.system.dao.rowMapper.BranchRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchDbDao implements BranchDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    BranchRowMapper rowMapper = new BranchRowMapper();

    @Override
    public List<String> selectAllBranches() {
        final String query = "select * from branch";
        return jdbcTemplate.query(query, rowMapper);
    }
}
