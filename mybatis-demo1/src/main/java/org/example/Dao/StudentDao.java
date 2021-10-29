package org.example.Dao;

import org.example.domain.Student;

public interface StudentDao {
    Student selectStudentById(Integer id);

    int insertStudent(Student student);
}
