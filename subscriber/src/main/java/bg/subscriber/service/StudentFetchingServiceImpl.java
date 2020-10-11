package bg.subscriber.service;

import bg.subscriber.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class StudentFetchingServiceImpl implements StudentFetchingService {

    private static final Logger logger = LoggerFactory.getLogger(StudentFetchingServiceImpl.class);

    private final RestTemplate restTemplate;

    @Value("${publisher.app.url}")
    private String publisherAppUrl;

    public StudentFetchingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void fixUrlIfIncorrect() {
        if (!publisherAppUrl.endsWith("/"))
            publisherAppUrl += '/';
    }

    @Override
    public Student fetchStudentById(String id) {
        String requestUrl = publisherAppUrl + id;

        logger.info("Sending GET request to: {}", requestUrl);

        return restTemplate.getForEntity(requestUrl, Student.class).getBody();
    }
}
