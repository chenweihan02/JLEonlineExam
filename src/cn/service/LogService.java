package cn.service;

import cn.bean.Log;

import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-23 23:44
 */
public interface LogService {
    /**
     * 从数据库中读取Log记录
     * @return
     */
    List<Log> read();

    /**
     * 从数据库中写入数据
     * @param content
     * @return
     */
    int record(String content);
}
