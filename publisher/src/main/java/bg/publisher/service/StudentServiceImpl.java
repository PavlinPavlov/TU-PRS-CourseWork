package bg.publisher.service;

import bg.publisher.model.Student;
import bg.publisher.persistence.DataStore;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private DataStore dataStore;

    @Override
    public Optional<Student> getStudentById(String id) {
        return dataStore.getStudentById(id);
    }

    @Override
    public Student saveStudentDTO(Student student) {
        return dataStore.saveStudentDTO(student);
    }
}
