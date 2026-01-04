package com.project.journalApplication.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Builder
//@Slf4j
//@EqualsAndHashCode
@Data
public class JournalEntry {
    @Id
    private ObjectId id;

    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;


}
