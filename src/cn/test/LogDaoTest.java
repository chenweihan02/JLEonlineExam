package cn.test;

import cn.dao.impl.LogDaoImpl;
import org.junit.Test;

import java.sql.Timestamp;


/**
 * @author xiaochen
 * @create 2021-06-23 23:47
 */
public class LogDaoTest {
    private LogDaoImpl logDao = new LogDaoImpl();

    @Test
    public void read() {
        System.out.println(logDao.read());
    }

    @Test
    public void record() {
        Timestamp d = new Timestamp(System.currentTimeMillis());
        logDao.record("你好", d);
        System.out.println(d);
    }
}