package com.example.RestAssignment.Controller;

import com.example.RestAssignment.UserDetails.UserDetails;
import com.example.RestAssignment.services.serviceinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class controller {
    @Autowired
    public serviceinterface service;

    @GetMapping("/details")
    public List<UserDetails> show(){
        return this.service.showdetails();
    }

    @GetMapping("/details/{id}")
    public Optional<UserDetails> showbyid(@PathVariable long id){
        return  this.service.showdetailsbyid(id);
    }

    @PostMapping(path = "/details",consumes = "application/json")
    public List<UserDetails> insert(@RequestBody UserDetails details){
        return this.service.insert(details);
    }

    @PutMapping(path="/details",consumes = "application/json")
    public List<UserDetails> update(@RequestBody UserDetails details){
        return this.service.update(details);
    }

    @DeleteMapping("/details/{id}")
    public List<UserDetails> deletebyid(@PathVariable long id){
        return this.service.delete(id);
    }

}
