package com.myhome.log.api.dto;

import com.myhome.log.db.entity.LogDefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogDefaultDto {
    private long id;
    private long unixTime;
    private boolean type; // error(false), success(true)
    private String sender; // spring, django
    private String service; // light(iot), reserve(iot), cloud, fileCheck(cloud)
    private String day; // send log day yyyy-mm-dd
    private String time; // send log time hh-mm-ss
    private String content; // log content

    public LogDefaultEntity dtoToEntity(){
        return new LogDefaultEntity(id, unixTime, type, sender, service, day, time, content);
    }
    public void receiveToDefault(LogReceiveDto dto){
        this.id = dto.getId();
        this.content = dto.getContent();
        this.service = dto.getService();
        this.sender = dto.getSender();
    }
}
