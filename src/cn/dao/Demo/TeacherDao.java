package cn.dao.Demo;

import cn.bean.Teacher;
import cn.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author xiaochen
 * @create 2021-06-16 23:34
 */
public class TeacherDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
    /**
     * 老师登录验证
     * @param t_id
     * @param t_password
     * @return
     * @throws SQLException
     */
    //判断教师是否登录
    public Teacher login(String t_id, String t_password) throws SQLException{
        String sql = "select * from teacher where t_id = ? and t_password = ?";
        Teacher teacher = queryRunner.query(sql,new BeanHandler<>(Teacher.class),t_id,t_password);
        return teacher;
    }
}
