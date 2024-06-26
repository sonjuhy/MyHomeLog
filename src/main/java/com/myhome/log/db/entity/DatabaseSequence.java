package com.myhome.log.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "database_sequence")
public class DatabaseSequence {
    @Id
    private String id;
    private Long seq;
}
