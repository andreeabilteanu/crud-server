package crudserver.service;

import crudserver.dao.DatabaseMethods;
import crudserver.utils.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CrudService {


    public ResponseEntity getStudentById(int id) {

        try {
            return new ResponseEntity(DatabaseMethods.getStudentById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity createStudent(Student student) {
        try {
            return new ResponseEntity(DatabaseMethods.createStudent(student), HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity updateStudent(Student student) {
        try {
            return new ResponseEntity(DatabaseMethods.updateStudent(student), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity deleteStudent(int id) {
        try {
            return new ResponseEntity(DatabaseMethods.deleteStudent(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
