package com.example.demo.services;

import com.example.demo.bean.Details;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    public UserRepository userrepo;
    
    public List<Details> getUsers(){
        List<Details> details = new ArrayList<>();
        return (List<Details>) userrepo.findAll();
    }
    public Details getUser(Long id) {
        return userrepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User ID with "+id+" not found"));
    }

    public void addUser(Details details) {
        userrepo.save(details);
    }

    public Details updateUser(Long id,Details details) {
    	Details existingUser = userrepo.findById(id)
    			.orElseThrow(()-> new ResourceNotFoundException("User ID with "+id+" not found"));
    	
    	existingUser.setId(details.getId());
    	existingUser.setName(details.getName());
    	existingUser.setEmpId(details.getEmpId());
    	existingUser.setTech(details.getTech());
    	
        userrepo.save(existingUser);
        return existingUser;
    }

    public void deleteUser(Long id) {
    	
    	userrepo.findById(id)
    			.orElseThrow(()-> new ResourceNotFoundException("User ID with "+id+" not found"));
        userrepo.deleteById(id);
    }


}
