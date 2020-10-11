package bg.publisher.controller;

import bg.publisher.model.Student;
import bg.publisher.service.RedisPublisher;
import bg.publisher.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final RedisPublisher redisPublisher;

    public StudentController(StudentService studentService, RedisPublisher redisPublisher) {
        this.studentService = studentService;
        this.redisPublisher = redisPublisher;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") String id) {
        Optional<Student> foundStudentOpt = studentService.getStudentById(id);

        return foundStudentOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        Student savedStudent = studentService.saveStudentDTO(student);

        redisPublisher.broadcast(savedStudent.getId());

        return ResponseEntity.ok(savedStudent);
    }

}
