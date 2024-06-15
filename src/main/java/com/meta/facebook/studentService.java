package com.meta.facebook;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class studentService {

    private final studentRepository repository;

    private final studentMapper mapper;

    public studentService(studentRepository repository, studentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public studentResponseDto saveStudent (
            studentDto dto
    ){
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.tostudentResponseDto(savedStudent);
    }

    public List<student> findAllStudent() {

        return repository.findAll();

    }

    public student findStudentById(Integer id) {
        return repository.findById(id)
                .orElse(new student());
    }
    public List<student> findStudentByName(String name) {
        return repository.findAllByFirstNameContaining(name);
    }
    public void delete(Integer id){
        repository.deleteById(id);
    }

}
