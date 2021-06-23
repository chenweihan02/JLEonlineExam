package cn.dao.Demo;

import cn.bean.Student;
import cn.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author xiaochen
 * @create 2021-06-16 21:59
 */
public class StudentDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
    /**
     * 学生登录判断
     * @param s_id 学号
     * @param s_password 密码
     * @return
     * @throws SQLException
     */
    public Student login(String s_id, String s_password) throws SQLException {
        String sql = "select * from student where s_id = ? and s_password = ?";
        Student student = queryRunner.query(sql, new BeanHandler<>(Student.class),s_id,s_password);
        return student;
    }
}
