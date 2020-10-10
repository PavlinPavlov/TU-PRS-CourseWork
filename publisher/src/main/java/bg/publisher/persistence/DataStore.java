package bg.publisher.persistence;

import bg.publisher.model.Student;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DataStore {

    private static final Map<String, Student> data = new ConcurrentHashMap<>();

    public Optional<Student> getStudentById(String id) {
        return data.containsKey(id)
                ? Optional.of(data.get(id))
                : Optional.empty();
    }

    public Student saveStudentDTO(Student student) {
        String id = UUID.randomUUID().toString();
        student.setId(id);
        data.put(id, student);
        return student;
    }
}
