package cn.dao.impl;

import cn.bean.ExamPaper;
import cn.dao.ExamPaperDao;

import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-22 14:07
 */
public class ExamPaperDaoImpl extends BaseDao implements ExamPaperDao {
    @Override
    public List<ExamPaper> queryExamPaperByStudentId(String studentId) {
        String sql = "select * from exampaper where studentId = ?";
        return queryForList(ExamPaper.class, sql, studentId);
    }

    @Override
    public List<ExamPaper> queryExamPaperByExamId(int examId) {
        String sql = "select * from exampaper where examId = ?";
        return queryForList(ExamPaper.class, sql, examId);
    }

    @Override
    public ExamPaper queryExamPaperByStudentIdAndExamId(int examId, String studentId) {
        String sql = "select * from exampaper where examId = ? and studentId = ?";
        return queryForOne(ExamPaper.class, sql, examId, studentId);
    }

    @Override
    public int saveExamPaper(ExamPaper examPaper) {
        String sql = "update exampaper set examId = ?, studentId = ?, totalScore = ?, score = ?";
        return update(sql, examPaper.getExamId());
    }

    @Override
    public int addExamPaper(ExamPaper examPaper) {
        String sql = "insert into exampaper (examId, studentId, totcalScore) value (?, ?, ?)";
        return update(sql, examPaper.getExamId(), examPaper.getStudentId(), examPaper.getTotalScore());
    }

    @Override
    public int deleteExamPaper(int examId) {
        String sql = "delete from exampaper where examId = ?";
        return update(sql, examId);
    }
}
