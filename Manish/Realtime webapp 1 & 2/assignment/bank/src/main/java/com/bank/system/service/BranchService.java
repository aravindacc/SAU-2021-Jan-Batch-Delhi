package com.bank.system.service;

import com.bank.system.dao.daoInterface.BranchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchDao branchDao;

    public List<String> getAllBranches() {
        return branchDao.selectAllBranches();
    }

}
