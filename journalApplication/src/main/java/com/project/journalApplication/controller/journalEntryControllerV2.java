package com.project.journalApplication.controller;

import com.project.journalApplication.entity.JournalEntry;
import com.project.journalApplication.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {

   @Autowired
   private JournalEntryService  journalEntryService;

    @GetMapping   //it is read as journal/all
    public  List<JournalEntry> getAll(){
        return  journalEntryService.getAll();
    }

    @PostMapping
    public  ResponseEntity<JournalEntry> create(@RequestBody JournalEntry myEntry){
//        myEntry.setDate(LocalDateTime.now());
//        journalEntryService.saveEntry(myEntry);
//        return  myEntry;
        try{
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry);
            return  new ResponseEntity<>(myEntry , HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myId}")
    public  ResponseEntity<JournalEntry> getById(@PathVariable ObjectId myId){
        Optional<JournalEntry> entry =  journalEntryService.findById(myId);
        if(entry.isPresent()){
            return  new ResponseEntity<>(entry.get() , HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{myId}")
    public  ResponseEntity<?> deleteId(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{myId}")
    public  ResponseEntity<JournalEntry> updateId(@PathVariable ObjectId myId , @RequestBody JournalEntry myEntry){
        try{
            JournalEntry old = journalEntryService.findById(myId).orElse(null);
            if(old != null){
                old.setTitle(myEntry.getTitle() != null && !myEntry.equals("") ? myEntry.getTitle():old.getTitle());
                old.setContent(myEntry.getContent() != null && !myEntry.equals("")?myEntry.getContent():old.getContent());

            }
            journalEntryService.saveEntry(old);
            return  new ResponseEntity<>(old , HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
