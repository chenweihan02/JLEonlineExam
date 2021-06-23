package cn.test;

import cn.dao.impl.TeacherDaoImpl;
import org.junit.Test;

/**
 * @author xiaochen
 * @create 2021-06-22 12:06
 */
public class TeacherDaoTest {
    private TeacherDaoImpl teacherDao = new TeacherDaoImpl();
    @Test
    public void queryTeacherByIdAndPassword() {
        System.out.println(teacherDao.queryTeacherByIdAndPassword("1", "123456"));
    }

    @Test
    public void queryTeacherExistId() {
        System.out.println(teacherDao.queryTeacherExistId("2"));
    }
}