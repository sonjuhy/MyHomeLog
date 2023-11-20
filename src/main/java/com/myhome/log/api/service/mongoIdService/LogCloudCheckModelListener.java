package com.myhome.log.api.service.mongoIdService;

import com.myhome.log.db.entity.LogCloudCheckEntity;
import com.myhome.log.db.entity.LogCloudEntity;
import com.myhome.log.db.entity.LogIotEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LogCloudCheckModelListener extends AbstractMongoEventListener<LogCloudCheckEntity> {
    private final SequenceGeneratorService service;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<LogCloudCheckEntity> event) {
        event.getSource().setId(service.generateSequence(LogCloudCheckEntity.CLOUD_CHECK_SEQUENCE_NAME));
    }
}
