package crudserver.dao;

import crudserver.utils.Student;
import crudserver.utils.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMethods {


    public static Student getStudentById(int id) throws Exception {
        Connection conn = Utils.getDbConnection();

        String query = String.format(StudentStatements.GET_STUDENT_BY_ID.getValue(),id);
        ResultSet rs = conn.prepareStatement(query).executeQuery();

        if (!rs.next())
        {
            throw new Exception("Invalid ID");
        }

        Student student = new Student();
        student.setId(rs.getInt("Id"));
        student.setNume(rs.getString("Nume"));
        student.setPrenume(rs.getString("Prenume"));
        student.setCNP(rs.getLong("CNP"));
        student.setOras(rs.getString("Oras"));
        student.setSex(rs.getString("Sex"));

        conn.close();
        return student;

    }

    public static Student createStudent(Student student) throws Exception {
        Connection conn = Utils.getDbConnection();

        String query = String.format(StudentStatements.GET_STUDENT_BY_CNP.getValue(),student.getCNP());
        ResultSet rs = conn.prepareStatement(query).executeQuery();

        if(rs.next()){
            throw new Exception("Student with the same CNP already exists");
        }
        query = String.format(StudentStatements.CREATE_STUDENT.getValue(),student.getNume(),student.getPrenume(),student.getCNP(),student.getOras(),student.getSex());
        conn.prepareStatement(query).execute();

        query = String.format(StudentStatements.GET_STUDENT_BY_CNP.getValue(),student.getCNP());
        rs = conn.prepareStatement(query).executeQuery();

        rs.next();
        Student createdStudent = new Student();
        createdStudent.setId(rs.getInt("Id"));
        createdStudent.setNume(rs.getString("Nume"));
        createdStudent.setPrenume(rs.getString("Prenume"));
        createdStudent.setCNP(rs.getLong("CNP"));
        createdStudent.setOras(rs.getString("Oras"));
        createdStudent.setSex(rs.getString("Sex"));

        conn.close();
        return createdStudent;

    }

    public static Student updateStudent(Student student) throws Exception {
        Connection conn = Utils.getDbConnection();

        String query = String.format(StudentStatements.GET_STUDENT_BY_ID.getValue(), student.getId());
        ResultSet rs = conn.prepareStatement(query).executeQuery();

        if(!rs.next()){
            throw new Exception("No records found for the student's Id");
        }

        if(student.getNume() != null)
        {
            query = String.format(StudentStatements.UPDATE_STUDENT_NAME.getValue(), student.getNume(), student.getId());
            conn.prepareStatement(query).execute();
        }

        if(student.getPrenume() != null)
        {
            query = String.format(StudentStatements.UPDATE_STUDENT_PRENUME.getValue(), student.getPrenume(), student.getId());
            conn.prepareStatement(query).execute();
        }

        if(student.getOras() != null)
        {
            query = String.format(StudentStatements.UPDATE_STUDENT_ORAS.getValue(), student.getOras(), student.getId());
            conn.prepareStatement(query).execute();
        }

        if(student.getSex() != null)
        {
            query = String.format(StudentStatements.UPDATE_STUDENT_SEX.getValue(), student.getSex(), student.getId());
            conn.prepareStatement(query).execute();
        }

        if(student.getCNP() != null)
        {
            query = String.format(StudentStatements.UPDATE_STUDENT_CNP.getValue(), student.getCNP(), student.getId());
            conn.prepareStatement(query).execute();
        }

        query = String.format(StudentStatements.GET_STUDENT_BY_CNP.getValue(),student.getCNP());
        rs = conn.prepareStatement(query).executeQuery();

        rs.next();
        Student updatedStudent = new Student();
        updatedStudent.setId(rs.getInt("Id"));
        updatedStudent.setNume(rs.getString("Nume"));
        updatedStudent.setPrenume(rs.getString("Prenume"));
        updatedStudent.setCNP(rs.getLong("CNP"));
        updatedStudent.setOras(rs.getString("Oras"));
        updatedStudent.setSex(rs.getString("Sex"));

        conn.close();
        return updatedStudent;
    }

    public static boolean deleteStudent(int id) throws Exception {
        Connection conn = Utils.getDbConnection();

        String query = String.format(StudentStatements.GET_STUDENT_BY_ID.getValue(),id);
        ResultSet rs = conn.prepareStatement(query).executeQuery();

        if (!rs.next())
        {
            throw new Exception("Invalid ID");
        }

        query = String.format(StudentStatements.DELETE_STUDENT.getValue(), id);
        conn.prepareStatement(query).execute();

        query = String.format(StudentStatements.GET_STUDENT_BY_ID.getValue(),id);
        rs = conn.prepareStatement(query).executeQuery();

        boolean flag = !rs.next();
        conn.close();
        return flag;
    }
}
