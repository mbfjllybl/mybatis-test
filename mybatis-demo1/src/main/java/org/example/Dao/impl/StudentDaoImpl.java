package org.example.Dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.Dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtil;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student selectStudentById(Integer id) {
        SqlSession session = MybatisUtil.getSqlSession();
        String sqlId = "org.example.Dao.StudentDao.selectStudentById";
        Student student = session.selectOne(sqlId, id);
        session.close();
        return student;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MybatisUtil.getSqlSession();
        String sqlId = "org.example.Dao.StudentDao.insertStudent";
        int nums = session.insert(sqlId, student);
        session.close();
        return nums;
    }
}
