package com.bank.system.controller;

import com.bank.system.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping
    public List<String> getBranches() {
        return branchService.getAllBranches();
    }

}
