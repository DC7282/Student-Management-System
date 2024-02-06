package com.dhiraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.entity.Student;

//we not need to add @Repository because we implemented JpaRepository and this is implemented SimpleJpaRepository and in this already implemented @Repository annotation
//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
