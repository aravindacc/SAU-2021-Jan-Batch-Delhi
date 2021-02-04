package com.example.RestAssignment.services;

import com.example.RestAssignment.UserDetails.UserDetails;


import java.util.List;
import java.util.Optional;

public interface serviceinterface {
    public List<UserDetails> showdetails();
    public Optional<UserDetails> showdetailsbyid(long id);
    public List<UserDetails> insert(UserDetails details);
    public List<UserDetails> update(UserDetails details);
    public List<UserDetails> delete(long id);

}
