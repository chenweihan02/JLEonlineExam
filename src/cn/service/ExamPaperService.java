package cn.service;

import cn.bean.ExamPaper;

import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-22 14:54
 */
public interface ExamPaperService {

    /**
     * 通过学生学号查询所有考试信息
     * @param studentId
     * @return 某个学生的Exampaper集合
     */
    public List<ExamPaper> query(String studentId);

    /**
     * 通过考场考试id，查询所有学生的考试信息（分数）集合
     * @param examId
     * @return
     */
    public List<ExamPaper> query(int examId);

    /**
     * 通过考场考试id，以及学生考号，查询学生考试试卷
     * @param examId
     * @param studentId
     * @return
     */
    public ExamPaper query(int examId, String studentId);

    /**
     * 删除exampaper
     * @param examId
     * @return
     */
    public int deleteExamPaper(int examId);
}
