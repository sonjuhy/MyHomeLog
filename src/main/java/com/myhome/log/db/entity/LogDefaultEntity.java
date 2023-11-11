package com.myhome.log.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "default_log")
public class LogDefaultEntity {

    @Transient
    public static final  String SEQUENCE_NAME="log_sequence";

    @Id
    private long id;
    private boolean type; // error(false), success(true)
    private String sender; // spring, django
    private String service; // light(iot), reserve(iot), cloud, fileCheck(cloud)
    private String day; // send log day yyyy-mm-dd
    private String time; // send log time hh-mm-ss
    private String content; // log content
}
