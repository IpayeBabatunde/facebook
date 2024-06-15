package com.meta.facebook;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface schoolRepository extends JpaRepository<school, Integer> {

}
