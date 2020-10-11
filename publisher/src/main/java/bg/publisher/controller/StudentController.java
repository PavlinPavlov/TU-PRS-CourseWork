package bg.publisher.controller;

import bg.publisher.model.Student;
import bg.publisher.service.RedisPublisher;
import bg.publisher.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;
    private final RedisPublisher redisPublisher;

    public StudentController(StudentService studentService, RedisPublisher redisPublisher) {
        this.studentService = studentService;
        this.redisPublisher = redisPublisher;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") String id) {

        logger.info("Received GET request with student with ID: {}", id);

        Optional<Student> foundStudentOpt = studentService.getStudentById(id);

        return foundStudentOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        logger.info("Received POST request for student: {}", student);

        Student savedStudent = studentService.saveStudentDTO(student);

        redisPublisher.broadcast(savedStudent.getId());

        return ResponseEntity.ok(savedStudent);
    }

}
