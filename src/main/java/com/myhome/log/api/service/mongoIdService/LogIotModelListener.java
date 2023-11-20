package com.myhome.log.api.service.mongoIdService;

import com.myhome.log.db.entity.LogIotEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LogIotModelListener extends AbstractMongoEventListener<LogIotEntity> {
    private final SequenceGeneratorService service;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<LogIotEntity> event) {
        event.getSource().setId(service.generateSequence(LogIotEntity.IOT_SEQUENCE_NAME));
    }
}
