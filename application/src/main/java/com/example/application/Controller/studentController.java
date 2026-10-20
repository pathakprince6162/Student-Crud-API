package com.example.application.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.Entitiy.student;
import com.example.application.Service.studentService;

@RestController 
@RequestMapping("/api/students")

public class studentController {

    @Autowired 
    public studentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody student student){
        student studentresp = studentService.createStudent(student);
        return "ok";
    }

    @GetMapping("/get/{Roll}")
    public Optional<student> getStudent(@PathVariable int Roll){
        return studentService.getStudent(Roll);
    }

    @GetMapping("/getall")
    public List<student> getAll(){
        List<student> allstudent = studentService.getAll();
        return allstudent;
    }

    @PutMapping("/update/{Roll}")
    public Optional<student> update(@PathVariable int Roll , @RequestBody student studentbody){
       Optional<student> toSave = studentService.update(Roll , studentbody);
        return toSave;
    }

    @DeleteMapping("/delete/{Roll}")
    public Optional<student> delete(@PathVariable int Roll){

        Optional<student> todelete = studentService.getStudent(Roll);
        if (todelete == null) {
            return Optional.empty();
        }
        studentService.delete(Roll);
        return todelete;
    }
    
}
