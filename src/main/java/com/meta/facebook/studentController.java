package com.meta.facebook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentController {

    private final studentService studentService;

    public studentController(studentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public studentResponseDto saveStudent(
          @RequestBody studentDto dto
    ) {
       return this.studentService.saveStudent(dto);

    }



    @GetMapping("/student")
    public List<student> findAllStudent() {

        return studentService.findAllStudent();

    }

    @GetMapping("/student/{student-id}")
    public student findStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return studentService.findStudentById(id);

    }
    @GetMapping("/student/search/{student-name}")
    public List<student> findStudentByName(
            @PathVariable ("student-name") String name
    ) {

        return studentService.findStudentByName(name);

    }

    @DeleteMapping ("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
        studentService.delete(id);
    }


}
