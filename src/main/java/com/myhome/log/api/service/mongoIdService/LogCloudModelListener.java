package com.myhome.log.api.service.mongoIdService;

import com.myhome.log.db.entity.LogCloudEntity;
import com.myhome.log.db.entity.LogIotEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LogCloudModelListener extends AbstractMongoEventListener<LogCloudEntity> {
    private final SequenceGeneratorService service;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<LogCloudEntity> event) {
        event.getSource().setId(service.generateSequence(LogCloudEntity.CLOUD_SEQUENCE_NAME));
    }
}
