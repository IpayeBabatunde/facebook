package com.meta.facebook;

import org.springframework.stereotype.Service;

@Service
public class studentMapper {

    public static student toStudent(studentDto dto) {
        var student = new student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new school();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;

    }
    public static studentResponseDto tostudentResponseDto(student student) {
        return new studentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
