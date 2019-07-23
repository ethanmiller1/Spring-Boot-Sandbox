// Controller to upload requests for StudentService.
package com.ethan.Controller;

import com.ethan.Entity.Student;
import com.ethan.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // Return the document who's _id matches the url id requested; @PathVariable("id") = req.params.uid in node.js.
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void deleteStudentById(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }

}