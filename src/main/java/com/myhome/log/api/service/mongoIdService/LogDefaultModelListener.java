package com.myhome.log.api.service.mongoIdService;

import com.myhome.log.db.entity.LogDefaultEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LogDefaultModelListener extends AbstractMongoEventListener<LogDefaultEntity> {
    private final SequenceGeneratorService service;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<LogDefaultEntity> event) {
        event.getSource().setId(service.generateSequence(LogDefaultEntity.SEQUENCE_NAME));
    }
}
