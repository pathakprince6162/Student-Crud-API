package com.example.application.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.application.Entitiy.student;
import com.example.application.Repository.studentRepository;

@Service 
public class studentService {
    
    @Autowired 
    studentRepository studentRepository;

    public student createStudent(student studentreq){
        student studentresp=studentRepository.save(studentreq);
        return studentresp;

    }

    public Optional<student> getStudent(int Roll){
        return studentRepository.findById(Roll);
    }

    public List<student> getAll(){
        List<student> allstudent = studentRepository.findAll();
        return allstudent;
    }

    public Optional<student> update(int Roll , student studentreq){
        Optional<student> toChange = studentRepository.findById(Roll);
        if (toChange == null) {
            return Optional.empty();
        } else {
            student toSave = toChange.get();

            toSave.setName(studentreq.getName());
            toSave.setAge(studentreq.getAge());
            toSave.setRoll(studentreq.getRoll());
            toSave.setEmail(studentreq.getEmail());
            toSave.setSubject(studentreq.getSubject());

            studentRepository.save(toSave);

            return Optional.of(toSave);

        }
    }


    public Optional<student> delete(int Roll){
       studentRepository.deleteById(Roll);
       return null;

    }
}
