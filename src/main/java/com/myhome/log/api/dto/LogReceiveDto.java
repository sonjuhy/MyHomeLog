package com.myhome.log.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogReceiveDto {
    private long id;
    private boolean type; // error(false), success(true)
    private String sender; // spring, django
    private String service; // light(iot), reserve(iot), cloud, fileCheck(cloud)
    private String content; // log content
}
