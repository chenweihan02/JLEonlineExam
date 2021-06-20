package cn.dao;

import cn.bean.Exam;
import cn.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/** 考场信息 对 Exam表进行操作
 * @author xiaochen
 * @create 2021-06-16 21:57
 */
public class ExamDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    /**
     * 给老师或者管理员查询所有的考试
     * @return
     * @throws SQLException
     */
    public List<Exam> query() throws SQLException {
        String sql = "select * from exam";
        return queryRunner.query(sql, new BeanListHandler<>(Exam.class));
    }

    /**
     * 根据是否被删除获取考试信息
     * @param isDel 是否被删除
     * @return
     * @throws SQLException
     */
    public List<Exam> query(int isDel) throws SQLException {
        String sql = "select * from exam where isDel = ?";
        return queryRunner.query(sql, new BeanListHandler<>(Exam.class), isDel);
    }

    /**
     * 根据 考试exam id 得到该实例
     * @param examId 考试编号
     * @return
     * @throws SQLException
     */
    public Exam query(Long examId) throws SQLException {
        String sql = "select * from exam where id = ?";
        return queryRunner.query(sql, new BeanHandler<>(Exam.class), examId);
    }

    /**
     * 根据 examId, isDel 得到考试信息对象。
     * @param examId 考试编号
     * @param isDel 是否删除
     * @return
     * @throws SQLException
     */
    public Exam query(Long examId, int isDel) throws SQLException {
        String sql = "select * from exam where id = ? and isDel = ?";
        return queryRunner.query(sql, new BeanHandler<>(Exam.class), examId, isDel);
    }

    public void update(Long examId, int questionNum, int totalScore) throws SQLException {
        String sql = "update exam set questionNum = ?, totalScore = ? where id = ?";
        Object[] params = {questionNum, totalScore, examId};
        queryRunner.update(sql, params);
    }

}
