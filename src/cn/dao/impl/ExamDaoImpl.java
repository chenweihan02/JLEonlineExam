package cn.dao.impl;

import cn.bean.Exam;
import cn.dao.ExamDao;
import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-22 11:54
 */
public class ExamDaoImpl extends BaseDao implements ExamDao {
    @Override
    public Exam queryExamByExamId(int id, int isDel) {
        String sql = "select * from exam where id = ? and isDel = ?";
        return queryForOne(Exam.class, sql, id, isDel);
    }

    @Override
    public List<Exam> queryAllExams() {
        String sql = "select * from exam";
        return queryForList(Exam.class, sql, null);
    }

    @Override
    public List<Exam> queryExamByIsDel(int isDel) {
        String sql = "select * from exam where isDel = ?";
        return queryForList(Exam.class, sql, isDel);
    }

    @Override
    public List<Exam> queryExamByExamName(String examName) {
        String sql = "select * from exam where examName like concat('%',?,'%')";
        return queryForList(Exam.class,sql,examName);
    }

    @Override
    public int addExam(Exam exam) {
        String sql = "insert into exam (examName, startTime, endTime) value (?, ?, ?)";
        return update(sql,exam.getExamName(), exam.getStartTime(), exam.getEndTime());
    }

    @Override
    public int updateExam(Exam exam) {
        String sql = "update exam set examName = ?, startTime = ?, endTime = ?, questionNum = ?, totalScore = ?, isDel = ? where id = ?";
        return update(sql, exam.getExamName(), exam.getStartTime(), exam.getEndTime(), exam.getQuestionNum(), exam.getTotalScore(), exam.getIsDel(), exam.getId());
    }
    @Override
    public int deleteExam(int examId) {
        String sql = "delete from exam where id = ?";
        return update(sql, examId);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from exam";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Exam> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from exam limit ?, ?";
        return queryForList(Exam.class, sql, begin, pageSize);
    }
}
