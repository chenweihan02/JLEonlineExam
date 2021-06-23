package cn.dao;

import cn.bean.ExamPaper;

import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-22 14:02
 */
public interface ExamPaperDao {
    /**
     * 通过学生学号查询所有考试信息
     * @param studentId
     * @return 某个学生的Exampaper集合
     */
    public List<ExamPaper> queryExamPaperByStudentId(String studentId);

    /**
     * 通过考场考试id 查询所有学生的考试信息（分数）集合
     * @param examId
     * @return 某个考试的Exampaper集合
     */
    public List<ExamPaper> queryExamPaperByExamId(int examId);

    /**
     * 通过考场id和学生学号查询 试卷信息
     * @param examId
     * @param studentId
     * @return
     */
    public ExamPaper queryExamPaperByStudentIdAndExamId(int examId, String studentId);


    /**
     * 更新Exampaper信息
     * @param examPaper
     * @return
     */
    public int saveExamPaper(ExamPaper examPaper);

    /**
     * 新增 Exampaper
     * @param examPaper
     * @return
     */
    public int addExamPaper(ExamPaper examPaper);

    /**
     * 删除Exampaper
     * @param examId 考场id
     * @return
     */
    public int deleteExamPaper(int examId);
}
