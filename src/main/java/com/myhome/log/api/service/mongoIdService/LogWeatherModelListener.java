package com.myhome.log.api.service.mongoIdService;

import com.myhome.log.db.entity.LogIotEntity;
import com.myhome.log.db.entity.LogWeatherEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LogWeatherModelListener extends AbstractMongoEventListener<LogWeatherEntity> {
    private final SequenceGeneratorService service;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<LogWeatherEntity> event) {
        event.getSource().setId(service.generateSequence(LogWeatherEntity.WEATHER_SEQUENCE_NAME));
    }
}
