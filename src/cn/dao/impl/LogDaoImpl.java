package cn.dao.impl;

import cn.bean.Log;
import cn.dao.LogDao;

import java.util.Date;
import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-23 23:35
 */
public class LogDaoImpl extends BaseDao implements LogDao {
    @Override
    public int record(String content, Date createTime) {
        String sql = "insert into log (content, createTime) value (?, ?)";
        return update(sql, content, createTime);
    }

    @Override
    public List<Log> read() {
        String sql = "select * from log order by id desc limit 0, 10 ";
        return queryForList(Log.class, sql);
    }
}
