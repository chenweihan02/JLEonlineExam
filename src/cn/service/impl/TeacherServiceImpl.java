package cn.service.impl;

import cn.bean.Teacher;
import cn.dao.impl.TeacherDaoImpl;
import cn.service.TeacherService;

/**
 * @author xiaochen
 * @create 2021-06-22 11:28
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDaoImpl teacherDao = new TeacherDaoImpl();

    @Override
    public int registerTeacher(Teacher teacher) {
        return teacherDao.registerTeacher(teacher);
    }

    @Override
    public int saveTeacher(Teacher teacher) {
        return teacherDao.saveTeacher(teacher);
    }

    @Override
    public Teacher login(String id, String password) {
        return teacherDao.queryTeacherByIdAndPassword(id, password);
    }
}
