package com.project.journalApplication.repository;

import com.project.journalApplication.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepo
        extends MongoRepository<JournalEntry , ObjectId> {

}
