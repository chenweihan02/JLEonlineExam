package cn.test;

import cn.dao.impl.StudentDaoImpl;
import org.junit.Test;

/**
 * @author xiaochen
 * @create 2021-06-21 10:59
 */
public class StudentDaoTest {
    private StudentDaoImpl studentDao = new StudentDaoImpl();
    @Test
    public void queryStudentByUsername() {
        System.out.println(studentDao.queryStudentByUsername("2019111"));
    }

    @Test
    public void queryStudentByUsernameAndPassword() {
        System.out.println(studentDao.queryStudentByUsernameAndPassword("2019111", "123456"));
    }

    @Test
    public void registerStudent(){

    }
}