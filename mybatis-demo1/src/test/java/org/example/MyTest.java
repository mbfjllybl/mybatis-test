package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.example.utils.MybatisUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class MyTest {
    @Test
    public void testSelectStudentBYId() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        String sqlId = "org.example.Dao.StudentDao.selectStudentById";

        Student student = session.selectOne(sqlId, 1);

        session.close();

        System.out.println(student);
    }

    @Test
    public void testInsertStudent() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        String sqlId = "org.example.Dao.StudentDao.insertStudent";

        int rows = session.insert(sqlId, new Student(3, "lihua", "123@123.com", 18));

        session.commit();

        session.close();

        System.out.println(rows);
    }

    @Test
    public void testSelectStudentBYIdByMyUtil() throws IOException {
        SqlSession session = MybatisUtil.getSqlSession();

        String sqlId = "org.example.Dao.StudentDao.selectStudentById";

        Student student = session.selectOne(sqlId, 1);

        session.close();

        System.out.println(student);
    }
}
