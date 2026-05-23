package com.anuj.FirstSpringBootProject.service;

import com.anuj.FirstSpringBootProject.entity.JournalEntry;
import com.anuj.FirstSpringBootProject.entity.User;
import com.anuj.FirstSpringBootProject.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntity(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }}
