package cn.dao;

import cn.bean.Log;

import java.util.Date;
import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-23 23:28
 */
public interface LogDao {
    /**
     * 从数据库中读取Log记录
     */
    List<Log> read();

    /**
     * 从数据库中写入记录
     * @param content
     */
    int record(String content, Date createTime);

}
