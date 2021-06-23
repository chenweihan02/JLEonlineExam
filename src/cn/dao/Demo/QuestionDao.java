package cn.dao.Demo;

import cn.bean.Question;
import cn.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-17 17:12
 */
public class QuestionDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

    /**
     * 获取所有的题目
     * @return
     * @throws SQLException
     */

    public List<Question> query() throws SQLException {
        String sql = "select * from question";
        return queryRunner.query(sql, new BeanListHandler<>(Question.class));
    }

    /**
     * 根据题目id 获取题目信息
     * @param questionId
     * @return
     * @throws SQLException
     */
    public Question query(Long questionId) throws SQLException {
        String sql = "select * from question where id = ?";
        return queryRunner.query(sql, new BeanHandler<>(Question.class), questionId);
    }

    /**
     * 根据题号和提交的选项,判断是否作答正确
     * @param id
     * @param answer
     * @return
     * @throws SQLException
     */
    public Question query(Long id, String answer) throws SQLException {
        String sql = "select * from question where id = ? and answer = ?";
        return queryRunner.query(sql, new BeanHandler<>(Question.class), id, answer);
    }

    /**
     *
     * @param q_id
     * @param score
     * @param title
     * @param attrA
     * @param attrB
     * @param attrC
     * @param attrD
     * @param answer
     * @throws SQLException
     */
    public void update(Long q_id, int score, String title, String attrA, String attrB, String attrC, String attrD, String answer) throws SQLException {
        String sql = "update question set score = ?, title = ?, attrA = ?, attrB = ?, attrC = ?, attrD = ?, answer = ? where id = ?";
        Object[] params = {score, title, attrA, attrB, attrC, attrD, answer, q_id};
        queryRunner.update(sql, params);
    }
}
