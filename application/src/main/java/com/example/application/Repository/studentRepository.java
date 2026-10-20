package com.example.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.Entitiy.student;

public interface studentRepository extends JpaRepository< student, Integer> {

   
}
