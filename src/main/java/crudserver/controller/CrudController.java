package crudserver.controller;

import crudserver.service.CrudService;
import crudserver.utils.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    CrudService crudService;

    @GetMapping("/get/{id}")
    public ResponseEntity getEntityById (@PathVariable int id)
    {
        return crudService.getStudentById(id);
    }

    @PostMapping("/post/create")
    public ResponseEntity createStudent(@RequestBody Student student)
    {
        return crudService.createStudent(student);
    }

    @PutMapping("/put/update")
    public ResponseEntity updateStudent(@RequestBody Student student)
    {
        return crudService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id)
    {
        return crudService.deleteStudent(id);
    }
}
