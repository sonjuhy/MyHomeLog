package com.myhome.log.api.service;

import com.google.gson.Gson;
import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.api.dto.LogReceiveDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

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

    @Autowired
    LogDefaultService service;

    @KafkaListener(topics = LIGHT, groupId = SPRING_GROUP)
    @Override
    public void consumeLight(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        service.insert(dto);
    }

    @KafkaListener(topics = RESERVE, groupId = SPRING_GROUP)
    @Override
    public void consumeReserve(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        service.insert(dto);
    }

    @KafkaListener(topics = CLOUD, groupId = SPRING_GROUP)
    @Override
    public void consumeCloud(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        service.insert(dto);
    }

    @KafkaListener(topics = WEATHER, groupId = SPRING_GROUP)
    @Override
    public void consumeWeather(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        service.insert(dto);
    }

    @KafkaListener(topics = FILE_CHECK, groupId = SPRING_GROUP)
    @Override
    public void consumeFileCheck(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        LogDefaultDto dto = toLogDefaultDto(consumerRecord.value(), consumerRecord.timestamp());
        service.insert(dto);
    }

//    @KafkaListener(topicPartitions = {
//            @TopicPartition(topic = TEST,
//            partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))}, groupId = SPRING_GROUP)
//    @KafkaListener(topicPartitions = {@TopicPartition(topic = TEST, partitions = {"0,1"})}, groupId = SPRING_GROUP)
    @KafkaListener(topics = TEST, groupId = SPRING_GROUP)
    public void consumeTest(ConsumerRecord<String, LogReceiveDto> consumerRecord) throws Exception {
        System.out.println("consumeTest : "+ consumerRecord.toString()+", timestamp : " + consumerRecord.timestamp());
        LogReceiveDto dto = consumerRecord.value();
        System.out.println("value : " + dto);
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

        dto.setDay(unixTimeToUTCDate(unixTime));
        dto.setTime(unixTimeToUTCTime(unixTime));

        return dto;
    }
    private String unixTimeToUTCDate(long unixTime){
        Date date = new Date(unixTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);

        return year+"-"+month+"-"+day;
    }
    private String unixTimeToUTCTime(long unixTime){
        Date date = new Date(unixTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);

        return hour+"-"+min+"-"+sec;
    }
}
