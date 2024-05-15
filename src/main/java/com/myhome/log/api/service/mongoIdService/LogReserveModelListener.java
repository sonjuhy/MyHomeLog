package com.myhome.log.api.service.mongoIdService;

import com.myhome.log.db.entity.LogIotEntity;
import com.myhome.log.db.entity.LogReserveEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LogReserveModelListener extends AbstractMongoEventListener<LogReserveEntity> {
    private final SequenceGeneratorService service;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<LogReserveEntity> event) {
        event.getSource().setId(service.generateSequence(LogReserveEntity.RESERVE_SEQUENCE_NAME));
    }
}
