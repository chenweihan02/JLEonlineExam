package cn.dao;

import cn.bean.Student;

/**
 * @author xiaochen
 * @create 2021-06-20 23:37
 */
public interface StudentDao {

    /**
     * 根据学生学号查询过学生信息
     * @param studentId 学生学号
     * @return 如果返回 null，说明没有这个学生
     */
    public Student queryStudentByUsername(String studentId);

    /**
     * 根据用户名和密码查询用户信息
     * @param studentId 学生学号
     * @param password 密码
     * @return 如果返回 null，说明没有这个学生
     */
    public Student queryStudentByUsernameAndPassword(String studentId, String password);

    /**
     * 保存注册学生信息
     * @param student
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int registerStudent(Student student);

    /**
     * 修改学生信息
     * @param student
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveStudent(Student student);

}
