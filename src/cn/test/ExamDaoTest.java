package cn.test;

import cn.dao.impl.ExamDaoImpl;
import org.junit.Test;

/**
 * @author xiaochen
 * @create 2021-06-24 8:04
 */
public class ExamDaoTest {
    private ExamDaoImpl examDao = new ExamDaoImpl();
    @Test
    public void queryExamByExamName() {
        System.out.println(examDao.queryExamByExamName("大学"));
    }
}