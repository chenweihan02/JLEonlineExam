package cn.dao;

import cn.bean.Teacher;

/**
 * @author xiaochen
 * @create 2021-06-22 11:21
 */
public interface TeacherDao {

    /**
     * 教师登录根据 id 和 密码进行登录
     * @param id 工号编号
     * @param password 密码
     * @return
     */
    public Teacher queryTeacherByIdAndPassword(String id, String password);

    /**
     * 查询是否有该工号的老师
     * @param id
     * @return
     */
    public Teacher queryTeacherExistId(String id);

    /**
     * 保存注册老师信息
     * @param teacher
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int registerTeacher(Teacher teacher);

    /**
     * 修改老师信息
     * @param teacher
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveTeacher(Teacher teacher);
}
