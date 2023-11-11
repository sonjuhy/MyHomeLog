package com.myhome.log.api.service;

import com.google.gson.Gson;
import com.myhome.log.api.dto.LogDefaultDto;
import com.myhome.log.api.dto.LogReceiveDto;
import com.myhome.log.db.entity.LogDefaultEntity;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@RequiredArgsConstructor
@Service
public class KafkaConsumerImpl implements KafkaConsumer{

    private final String FILE_CHECK= "cloud-check";
    private final String CLOUD= "cloud-topic";
    private final String LIGHT= "iot-topic";
    private final String RESERVE = "reserve-topic";
    private final String TEST = "exam-topic";

    private final String SPRING_GROUP = "spring-group";
    private final String DJANGO_GROUP = "django-kafka";
    private final String TEST_GROUP = "test-consumer-group";

    private final MongoOperations mongoOperations;

    @Autowired
    LogDefaultService service;

//    @KafkaListener(topics = LIGHT, groupId = SPRING_GROUP)
    @Override
    public void consumeLight(ConsumerRecord<String, String> consumerRecord) throws Exception {
        LogDefaultDto dto = msgToDto(consumerRecord.value(), consumerRecord.timestamp());
    }

//    @KafkaListener(topics = RESERVE, groupId = SPRING_GROUP)
    @Override
    public void consumeReserve(ConsumerRecord<String, String> consumerRecord) throws Exception {
        LogDefaultDto dto = msgToDto(consumerRecord.value(), consumerRecord.timestamp());
    }

//    @KafkaListener(topics = CLOUD, groupId = SPRING_GROUP)
    @Override
    public void consumeCloud(ConsumerRecord<String, String> consumerRecord) throws Exception {
        LogDefaultDto dto = msgToDto(consumerRecord.value(), consumerRecord.timestamp());
    }

//    @KafkaListener(topics = FILE_CHECK, groupId = SPRING_GROUP)
    @Override
    public void consumeFileCheck(ConsumerRecord<String, String> consumerRecord) throws Exception {
        LogDefaultDto dto = msgToDto(consumerRecord.value(), consumerRecord.timestamp());
    }

    @KafkaListener(topicPartitions = {
            @TopicPartition(topic = TEST,
            partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))}, groupId = SPRING_GROUP)
//    @KafkaListener(topicPartitions = {@TopicPartition(topic = TEST, partitions = {"0,1"})}, groupId = SPRING_GROUP)
//    @KafkaListener(topics = TEST, groupId = SPRING_GROUP)
    public void consumeTest(ConsumerRecord<String, String> consumerRecord) throws Exception {
        System.out.println("consumeTest : "+ consumerRecord.toString()+", timestamp : " + consumerRecord.timestamp());
        System.out.println("value : " + consumerRecord.value());
        LogDefaultDto dto = msgToDto(consumerRecord.value(), consumerRecord.timestamp());
        service.insert(dto);
    }

    private LogDefaultDto msgToDto(String msg, long unixTime){
//        Gson gson = new Gson();
//        LogReceiveDto tmpDto = gson.fromJson(msg, LogReceiveDto.class);

        LogDefaultDto dto = new LogDefaultDto();
        dto.setContent(msg);
//        dto.receiveToDefault(tmpDto);

        Date date = new Date(unixTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        String dateStr = year+"-"+month+"-"+day;
        String time = hour+"-"+min+"-"+sec;

        dto.setDay(dateStr);
        dto.setTime(time);

        return dto;
    }
    private String[] timestampToString(String timestamp){
        String[] str = new String[2];

        return str;
    }
    private long autoIncreaseId(long seqName){
        LogDefaultDto dto = mongoOperations.findAndModify(Query.query(where("_id").is(seqName)),
                new Update().inc("id",1), FindAndModifyOptions.options().returnNew(true).upsert(true),
                LogDefaultDto.class);
        return dto != null ? dto.getId() : 1;
    }
}
