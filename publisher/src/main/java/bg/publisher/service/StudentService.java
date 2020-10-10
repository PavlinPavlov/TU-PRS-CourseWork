package bg.publisher.service;

import bg.publisher.model.Student;

import java.util.Optional;

public interface StudentService {

    Optional<Student> getStudentById(String id);

    Student saveStudentDTO(Student student);

}
