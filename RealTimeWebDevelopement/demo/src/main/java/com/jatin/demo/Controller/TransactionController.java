package com.jatin.demo.Controller;


import com.jatin.demo.Model.Transaction;
import com.jatin.demo.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


class TransactionPostRequest{
    Transaction transaction;
    int amount;
    TransactionPostRequest(Transaction transaction,int amount)
    {
        this.transaction=transaction;
        this.amount=amount;
    }
}



@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/getTransactionByType/{type}")
    @CrossOrigin("*")
    public ResponseEntity<List<Transaction>> getTransactionsByType(@PathVariable("type") int type)
    {
        return  new ResponseEntity<>(transactionService.getTransactionByType(type), HttpStatus.OK);
    }

    @GetMapping("/getTransactionByNo/{accountNo}")
    @CrossOrigin("*")
    public ResponseEntity<List<Transaction>> getTransactionByAccount(@PathVariable("accountNo") int accountNumber){
        return new ResponseEntity<>(transactionService.getTransactionByAccount(accountNumber),HttpStatus.OK);
    }


    @PostMapping("/addTransaction")
    @CrossOrigin("*")
    public ResponseEntity<Integer> addTransaction(@RequestBody TransactionPostRequest transactionPostRequest)
    {
        return new ResponseEntity<>(this.transactionService.addNewTransaction(transactionPostRequest.transaction, transactionPostRequest.amount),HttpStatus.OK);
    }
}