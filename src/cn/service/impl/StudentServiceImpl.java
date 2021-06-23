package cn.service.impl;

import cn.bean.Student;
import cn.dao.StudentDao;
import cn.dao.impl.StudentDaoImpl;
import cn.service.StudentService;

/**
 * @author xiaochen
 * @create 2021-06-21 11:18
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public int registerStudent(Student student) {
        return studentDao.registerStudent(student);
    }

    @Override
    public int saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public Student login(String studentId, String password) {
        return studentDao.queryStudentByUsernameAndPassword(studentId, password);
    }
}
