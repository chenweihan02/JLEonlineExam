package cn.dao.Demo;

import cn.bean.ExamPaperAnswer;
import cn.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**试卷中的每一题进行操作，
 * @author xiaochen
 * @create 2021-06-17 7:18
 */
public class ExamPaperAnswerDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

    /**
     * 添加某个考试场次的某个学生的试卷里面的一道题目作答情况
     * @param examId 考试场次
     * @param studentId 学生学号
     * @param examPaperId 试卷id
     * @throws SQLException
     */
    public void add(Long examId, String studentId, Long examPaperId, Long questionId) throws SQLException {
        String sql = "insert into exampaperanswer (examId, studentId, examPaperId, questionId) values(?, ?, ?, ?)";
        Object[] params = {examId, studentId, examPaperId, questionId};
        queryRunner.update(sql, params);
    }

    public void update(Long examId, String studentId, Long examPaperId, Long questionId, String answer, int isCorrent) throws SQLException {
        String sql = "update exampaperanswer set answer = ?, isCorrent = ? where examId = ? and studentId = ? and examPaperId = ? and questionId = ?";
        Object[] params = {answer, isCorrent, examId, studentId, examPaperId, questionId};
        queryRunner.update(sql, params);
    }

    /**
     * 根据考试场次，以及学号，试卷编号得到所有的题目
     * @param examId
     * @param studentId
     * @param examPaperId
     * @return
     * @throws SQLException
     */
    public List<ExamPaperAnswer> query(Long examId, String studentId, Long examPaperId) throws SQLException {
        String sql = "select * from exampaperanswer where examId = ? and studentId = ? and examPaperId = ?";
        return queryRunner.query(sql, new BeanListHandler<>(ExamPaperAnswer.class), examId, studentId, examPaperId);
    }

}
