package com.li.back.repository;

import com.li.back.dto.StudentGetDto;
import com.li.back.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}

