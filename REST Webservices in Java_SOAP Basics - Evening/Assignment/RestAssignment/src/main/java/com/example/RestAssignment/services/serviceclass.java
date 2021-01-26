package com.example.RestAssignment.services;

import com.example.RestAssignment.UserDetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.RestAssignment.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class serviceclass implements serviceinterface {

//      List<UserDetails> list;
    @Autowired
    private repository repo;

    public serviceclass() {
//        list = new ArrayList<>();
//        list.add(new UserDetails(1,"Niket","7734966827","niketjain1007@gmail.com"));
//        list.add(new UserDetails(2,"Guddu","7014952790","niketbanetha@gmail.com"));
   }


    @Override
    public List<UserDetails> showdetails() {
        return repo.findAll();
//        return this.list;
    }

    @Override
    public Optional<UserDetails> showdetailsbyid(long id) {
//        UserDetails n = null;
//        for(UserDetails item : list){
//            if(item.getId()==id){
//                n=item;
//                break;
//            }
//        }
//        return n;
        return repo.findById(id);
    }

    @Override
    public List<UserDetails> insert(UserDetails details) {
//        this.list.add(details);
//        return this.list;
        repo.save(details);
        return repo.findAll();
    }

    @Override
    public List<UserDetails> update(UserDetails details) {
//        list.forEach(e->{
//            if(e.getId()==details.getId()){
//                e.setEmail(details.getEmail());
//                e.setName(details.getName());
//                e.setPhone(details.getPhone());
//
//            }
//        });
//    return list;
        repo.save(details);
        return repo.findAll();
    }

    @Override
    public List<UserDetails> delete(long id) {
//        this.list=this.list.stream().filter(e-> e.getId()!=id).collect(Collectors.toList());
//        return this.list;
        UserDetails d=repo.getOne(id);
        repo.delete(d);
        return repo.findAll();
    }
}
