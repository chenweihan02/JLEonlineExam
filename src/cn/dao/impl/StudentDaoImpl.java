package cn.dao.impl;

import cn.bean.Student;
import cn.dao.StudentDao;

/**
 * @author xiaochen
 * @create 2021-06-20 23:43
 */
public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public Student queryStudentByUsername(String studentId) {
        String sql = "select * from student where studentId = ?";
        return queryForOne(Student.class, sql, studentId);
    }

    @Override
    public Student queryStudentByUsernameAndPassword(String studentId, String password) {
        String sql = "select * from student where studentId = ? and password = ?";
        return queryForOne(Student.class, sql, studentId, password);
    }

    @Override
    public int registerStudent(Student student) {
        String sql = "insert into student (studentId, name, password) value (?, ?, ?)";
        return update(sql,student.getStudentId(), student.getName(), student.getPassword());
    }
//    UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing'
//    WHERE LastName = 'Wilson'
    @Override
    public int saveStudent(Student student) {
        String sql = "update student set name = ?, password = ? where studentId = ?";
        return update(sql,student.getName(), student.getPassword(), student.getStudentId());
    }
}
