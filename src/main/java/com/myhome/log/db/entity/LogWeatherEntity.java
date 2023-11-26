package com.myhome.log.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "weather_log")
public class LogWeatherEntity {

    @Transient
    public static final String WEATHER_SEQUENCE_NAME = "weather_log_sequence";

    @Id
    private long id;
    @Field("unix_time")
    private long unixTime;
    private boolean type; // error(false), success(true)
    private String sender; // spring, django
    private String service; // light(iot), reserve(iot), cloud, fileCheck(cloud)
    private String day; // send log day yyyy-mm-dd
    private String time; // send log time hh-mm-ss
    private String content; // log content
}
