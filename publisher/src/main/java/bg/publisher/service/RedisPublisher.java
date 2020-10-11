package bg.publisher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class RedisPublisher {

    private static final Logger logger = LoggerFactory.getLogger(RedisPublisher.class);

    private final RedisTemplate<String, String> redisTemplate;
    private final ChannelTopic topic;

    public RedisPublisher(RedisTemplate<String, String> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public void broadcast(String studentId) {
        redisTemplate.convertAndSend(topic.getTopic(), studentId);
        logger.info("Send notification for student with ID: {}", studentId);
    }
}
