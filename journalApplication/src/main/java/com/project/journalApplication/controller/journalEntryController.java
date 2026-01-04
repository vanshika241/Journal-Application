//package com.project.journalApplication.controller;
//
//import com.project.journalApplication.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//import java.util.HashMap;
//@RestController
//@RequestMapping("/_journal")
//public class journalEntryController {
//
//    public HashMap<String , JournalEntry> journalEnteries = new HashMap<>();
//
//    @GetMapping   //it is read as journal/all
//    public  List<JournalEntry> getAll(){
//        return  new ArrayList<>(journalEnteries.values());
//    }
//
//    @PostMapping
//    public  boolean create(@RequestBody JournalEntry myEntry){
//        journalEnteries.put(myEntry.getId() , myEntry);
//        return  true;
//    }
//
//    @GetMapping("/id/{myId}")
//    public  JournalEntry getById(@PathVariable String myId){
//        return  journalEnteries.get(myId);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public  boolean deleteId(@PathVariable Long myId){
//        journalEnteries.remove(myId);
//        return  true;
//    }
//
//    @PutMapping("/id/{myId}")
//    public  JournalEntry updateId(@PathVariable String myId , @RequestBody JournalEntry myEntry){
//        journalEnteries.put(myId , myEntry);
//        return  journalEnteries.get(myId);
//    }
//}
