package bg.subscriber.listener;

import bg.subscriber.model.Student;
import bg.subscriber.service.StudentFetchingService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber implements MessageListener {

    private final StudentFetchingService studentFetchingService;

    public RedisSubscriber(StudentFetchingService studentFetchingService) {
        this.studentFetchingService = studentFetchingService;
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String receivedStudentId = new String(message.getBody());
        Student student = studentFetchingService.fetchStudentById(receivedStudentId);
    }
}
