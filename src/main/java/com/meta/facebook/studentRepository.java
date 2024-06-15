package com.meta.facebook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface studentRepository extends JpaRepository<student, Integer> {

    List<student> findAllByFirstNameContaining(String firstName);

}
