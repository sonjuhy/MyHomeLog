package com.myhome.log.api.service;

import com.google.gson.Gson;
import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.api.dto.LogReceiveDto;
import com.myhome.log.db.entity.LogCloudCheckEntity;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RequiredArgsConstructor
@Service
public class KafkaConsumerImpl implements KafkaConsumer{

    private final String FILE_CHECK= "cloud-check-log";
    private final String CLOUD= "cloud-log-topic";
    private final String LIGHT= "iot-log-topic";
    private final String RESERVE = "reserve-log-topic";
    private final String WEATHER = "weather-log-topic";
    private final String TEST = "exam-topic";

    private final String SPRING_GROUP = "spring-group";
    private final String SPRING_LOG_GROUP = "spring-log-group";

    @Autowired
    LogDefaultService service;

    @Autowired
    LogCloudCheckService cloudCheckService;

    @Autowired
    LogCloudService cloudService;

    @Autowired
    LogIotService iotService;

    @Autowired
    LogReserveService reserveService;

    @Autowired
    LogWeatherService weatherService;


    @KafkaListener(topics = LIGHT, groupId = SPRING_LOG_GROUP, containerFactory = "kafkaListenerContainerDtoFactory")
    @Override
    public void consumeLight(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        iotService.insert(dto);
    }

    @KafkaListener(topics = RESERVE, groupId = SPRING_LOG_GROUP, containerFactory = "kafkaListenerContainerDtoFactory")
    @Override
    public void consumeReserve(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        reserveService.insert(dto);
    }

    @KafkaListener(topics = CLOUD, groupId = SPRING_LOG_GROUP, containerFactory = "kafkaListenerContainerDtoFactory")
    @Override
    public void consumeCloud(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        cloudService.insert(dto);
    }

    @KafkaListener(topics = WEATHER, groupId = SPRING_LOG_GROUP, containerFactory = "kafkaListenerContainerDtoFactory")
    @Override
    public void consumeWeather(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        weatherService.insert(dto);
    }

    @KafkaListener(topics = FILE_CHECK, groupId = SPRING_LOG_GROUP, containerFactory = "kafkaListenerContainerDtoFactory")
    @Override
    public void consumeFileCheck(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        cloudCheckService.insert(dto);
    }

//    @KafkaListener(topicPartitions = {
//            @TopicPartition(topic = TEST,
//            partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "15"))}, groupId = SPRING_LOG_GROUP)
//    @KafkaListener(topicPartitions = {@TopicPartition(topic = TEST, partitions = {"0,1"})}, groupId = SPRING_GROUP)
//    @KafkaListener(topics = TEST, groupId = SPRING_GROUP, containerFactory = "kafkaListenerContainerDtoFactory")
    public void consumeTest(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        System.out.println("consumeTest : "+ consumerRecord.toString()+", timestamp : " + consumerRecord.timestamp()+", tmpStamp type : "+consumerRecord.timestampType());
//        System.out.println("UTC date : " + unixTimeToUTCDate(consumerRecord.timestamp() / 1000L));
//        System.out.println("UTC time : " + unixTimeToUTCTime(consumerRecord.timestamp() / 1000L));
//        LogReceiveDto dto = consumerRecord.value();
//        System.out.println("value : " + dto);
//        LogDefaultDto dto = msgToDto(consumerRecord.value(), consumerRecord.timestamp());
//        service.insert(dto);
    }


    private LogDefaultDto msgToDto(String msg, long unixTime){
        Gson gson = new Gson();
        LogReceiveDto tmpDto = gson.fromJson(msg, LogReceiveDto.class);

        LogDefaultDto dto = new LogDefaultDto();
        dto.receiveToDefault(tmpDto);

        dto.setDay(unixTimeToUTCDate(unixTime));
        dto.setTime(unixTimeToUTCTime(unixTime));

        return dto;
    }
    private LogDefaultDto toLogDefaultDto(LogReceiveDto receiveDto, long unixTime){
        LogDefaultDto dto = new LogDefaultDto();
        dto.receiveToDefault(receiveDto);

        dto.setUnixTime(unixTime);
        dto.setDay(unixTimeToUTCDate(unixTime));
        dto.setTime(unixTimeToUTCTime(unixTime));

        return dto;
    }
    private String unixTimeToUTCDate(long unixTime){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date(unixTime);
        return simpleDateFormat.format(date);
    }
    private String unixTimeToUTCTime(long unixTime){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
        Date date = new Date(unixTime);

        return simpleDateFormat.format(date);
    }
}
