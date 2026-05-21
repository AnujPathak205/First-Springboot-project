package com.anuj.FirstSpringBootProject.controller;

import com.anuj.FirstSpringBootProject.entity.JournalEntry;
import com.anuj.FirstSpringBootProject.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/journal")
public class JournalEntryController2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry newEntry){
        newEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntity(newEntry);
        return true;
    }

    @GetMapping("/{myId}")
    public Optional<JournalEntry> getJournalEntry(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId);
    }

    @DeleteMapping("/{myId}")
    public void deleteJournalEntry(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
    }

    @PutMapping("/{myId}")
    public JournalEntry updateJournalEntry(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(myId).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ?
                    newEntry.getTitle() : old.getTitle()
            );
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ?
                    newEntry.getContent() : old.getContent()
            );
            journalEntryService.saveEntity(old);
        }
        return old;
    }
}
