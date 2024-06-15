package com.meta.facebook;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class schoolController {

    private final schoolRepository schoolRepository;

    public schoolController(com.meta.facebook.schoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public schoolDto create(
            @RequestBody schoolDto dto
    ) {
        var school = toSchool(dto);
        var savedSchool = schoolRepository.save(school);
        return dto;
    }

    private school toSchool(schoolDto dto) {
        return new school(dto.name());
    }
    private schoolDto schoolDto(school school)  {
        return new schoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<schoolDto> findAll() {

        return schoolRepository.findAll()
                .stream()
                .map(this::schoolDto)
                .collect(Collectors.toList());
    }
}
