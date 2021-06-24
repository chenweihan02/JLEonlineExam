package cn.service.impl;

import cn.bean.Log;
import cn.dao.impl.LogDaoImpl;
import cn.service.LogService;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-23 23:45
 */
public class LogServiceImpl implements LogService {
    private LogDaoImpl logDao = new LogDaoImpl();
    @Override
    public List<Log> read() {
        return logDao.read();
    }

    @Override
    public int record(String content) {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        return logDao.record(content, createTime);
    }
}
