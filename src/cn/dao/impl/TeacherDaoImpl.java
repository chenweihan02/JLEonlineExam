package cn.dao.impl;

import cn.bean.Teacher;
import cn.dao.TeacherDao;

/**
 * @author xiaochen
 * @create 2021-06-22 11:23
 */
public class TeacherDaoImpl extends BaseDao implements TeacherDao {

    @Override
    public Teacher queryTeacherByIdAndPassword(String id, String password) {
        String sql = "select * from teacher where id = ? and password = ?";
        return queryForOne(Teacher.class, sql, id, password);
    }

    @Override
    public Teacher queryTeacherExistId(String id) {
        String sql = "select * from teacher where id = ?";
        return queryForOne(Teacher.class, sql, id);
    }

    @Override
    public int registerTeacher(Teacher teacher) {
        String sql = "insert into teacher (teacherId, name, password) value (?, ?, ?)";
        return update(sql,teacher.getTeacherId(), teacher.getName(), teacher.getPassword());
    }

    @Override
    public int saveTeacher(Teacher teacher) {
        String sql = "update teacher set name = ?, password = ?, isAdmin = ? where teacherId = ?";
        return update(sql, teacher.getName(), teacher.getPassword(), teacher.getIsAdmin(), teacher.getTeacherId());
    }
}
