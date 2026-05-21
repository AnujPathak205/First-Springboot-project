//package com.anuj.FirstSpringBootProject.controller;
//
//import com.anuj.FirstSpringBootProject.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryController {
//    private Map<String,JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public void createEntry(@RequestBody JournalEntry newEntry){
//        journalEntries.put(newEntry.getId(),newEntry);
//    }
//
//    @GetMapping("{myId}")
//    public JournalEntry getJournalEntry(@PathVariable String myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("{myId}")
//    public JournalEntry updateJournalEntry(@PathVariable String myId){
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("{myId}")
//    public JournalEntry updateJournalEntry(@PathVariable String myId,@RequestBody JournanlEntry newEntry){
//        return journalEntries.put(myId,newEntry);
//    }
//}