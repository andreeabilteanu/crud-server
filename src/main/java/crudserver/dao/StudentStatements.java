package crudserver.dao;

public enum StudentStatements {
    GET_STUDENT_BY_ID("Select * from student where Id = %d"),
    CREATE_STUDENT("INSERT INTO `student`(`Nume`, `Prenume`, `CNP`, `Oras`, `Sex`) VALUES ('%s','%s','%d','%s','%s')"),
    GET_STUDENT_BY_CNP("Select * from student where CNP = %d"),

    UPDATE_STUDENT_NAME("UPDATE student SET Nume = '%s' where Id = %d"),
    UPDATE_STUDENT_PRENUME("UPDATE student SET Prenume = '%s' where Id = %d"),
    UPDATE_STUDENT_CNP("UPDATE student SET CNP = %d where Id = %d"),
    UPDATE_STUDENT_ORAS("UPDATE student SET Oras = '%s' where Id = %d"),
    UPDATE_STUDENT_SEX("UPDATE student SET Sex = '%s' where Id = %d"),

    DELETE_STUDENT("DELETE from student where Id = %d");

    public String getValue() {
        return value;
    }

    String value;

    StudentStatements(String value) {
        this.value = value;
    }


}
