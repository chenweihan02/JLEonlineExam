package cn.dao;

import cn.bean.ExamPaper;
import cn.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/** 整个试卷的操作 => 总分, 得分
 * @author xiaochen
 * @create 2021-06-17 7:18
 */
public class ExamPaperDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    /**
     *  通过学生学号查询所有考试信息 集合
     * @param studentId
     * @return
     * @throws SQLException
     */
    public List<ExamPaper> query(String studentId) throws SQLException {
        String sql = "select * from exampaper where studentId = ?";
        return queryRunner.query(sql, new BeanListHandler<>(ExamPaper.class), studentId);
    }

    /**
     *  根据考试id 查询所有学生的考试信息（分数） 集合
     * @param examId
     * @return
     * @throws SQLException
     */
    public List<ExamPaper> query(Long examId) throws SQLException {
        String sql = "select * from exampaper where examId = ?";
        return queryRunner.query(sql, new BeanListHandler<>(ExamPaper.class),examId);
    }

    /**
     * 根据考场场次和学号,获取试卷.
     * @param examId
     * @param studentId
     * @return
     * @throws SQLException
     */
    public ExamPaper query(Long examId, String studentId) throws SQLException {
        String sql = "select * from exampaper where examId = ? and studentId = ?";
        return queryRunner.query(sql, new BeanHandler<>(ExamPaper.class), examId, studentId);
    }

    /**
     * 据考场场次和学号,更新试卷成绩
     * @param examId
     * @param studentId
     * @param score
     * @throws SQLException
     */
    public void update(Long examId, String studentId, int score) throws SQLException {
        String sql = "update exampaper set score = ? where examId = ? and studentId = ?";
        Object[] params = {score, examId, studentId};
        queryRunner.update(sql, params);
    }

    /**
     *  添加卷子
     * @param examId 考试场次
     * @param studentId 学生学号
     * @param totalScore 试卷总分（分值）
     * @return 试卷对象
     * @throws SQLException
     */
    public ExamPaper add(Long examId, String studentId, int totalScore) throws SQLException {
        String sql = "insert into exampaper (examId, studentId, totalScore) values(?,?,?)";
        Object[] params = {examId, studentId, totalScore};
        queryRunner.update(sql, params);
        return query(examId, studentId);
    }




//    public static void main(String[] args) {
//        ExamPaperDao examPaperDao = new ExamPaperDao();
//        try {
////            examPaperDao.add(Long.valueOf(1), "2019112", 20);
//            System.out.println(examPaperDao.query(Long.valueOf(1), "2019112"));
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

}
