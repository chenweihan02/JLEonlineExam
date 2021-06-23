package cn.service;

import cn.bean.Student;

/**
 * @author xiaochen
 * @create 2021-06-21 11:13
 */
public interface StudentService {
    /**
     * 保存注册用户
     * @param student
     */
    public int registerStudent(Student student);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public int saveStudent(Student student);


    /**
     * 登录
     * @param studentId
     * @param password
     * @return 如果返回null 说明登录失败，返回有值是登录成功
     */
    public Student login(String studentId, String password);

}
