package cn.dao;

import cn.bean.Student;
import cn.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author xiaochen
 * @create 2021-06-16 21:59
 */
public class StudentDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
    /**
     * 学生登录判断
     * @param s_id
     * @param s_password
     * @return
     * @throws SQLException
     */
    public Student login(String s_id, String s_password) throws SQLException {
        String sql = "select * from student where s_id = ? and s_password = ?";
        Student student = queryRunner.query(sql, new BeanHandler<>(Student.class),s_id,s_password);
        return student;
    }
}
