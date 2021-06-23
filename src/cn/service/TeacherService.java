package cn.service;

import cn.bean.Teacher;

/**
 * @author xiaochen
 * @create 2021-06-22 11:28
 */
public interface TeacherService {

    /**
     * 保存注册老师
     * @param teacher
     * @return
     */
    public int registerTeacher(Teacher teacher);

    /**
     * 更新老师信息
     * @param teacher
     * @return
     */
    public int saveTeacher(Teacher teacher);


    /**
     * 教师登录
     * @param id
     * @param password
     * @return
     */
    public Teacher login(String id, String password);
}
