package com.anuj.FirstSpringBootProject.service;

import com.anuj.FirstSpringBootProject.entity.User;
import com.anuj.FirstSpringBootProject.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import com.anuj.FirstSpringBootProject.entity.JournalEntry;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntity(JournalEntry journalEntry, String userName){
        try{
            User user = userService.findByUserName(userName);
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            user.setUserName(null);
            userService.saveEntity(user);
        }catch (Exception e){
            throw new RuntimeException("An error occured while saving the entry"+e);
        }
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public void deleteById(ObjectId id, String userName){
        try{
            User user = userService.findByUserName(userName);
            user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            userService.saveEntity(user);
            journalEntryRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("An error occured while saving the entry"+e);
        }
    }
}