package cn.dao;

import cn.bean.Exam;

import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-22 11:42
 */
public interface ExamDao {
    /**
     * 根据Exam的id 以及 isDel查找该试卷信息
     * @param id
     * @param isDel
     * @return 返回Exam对象
     */
    Exam queryExamByExamId(int id, int isDel);

    /**
     * 查询所有的考试信息
     * @return 所有的Exam对象
     */
    List<Exam> queryAllExams();

    /**
     * 查询考试状态为isDel的考试信息
     * @param isDel 被删除为1，否则为0
     * @return
     */
    List<Exam> queryExamByIsDel(int isDel);


    /**
     * 根据考试名称进行考试模糊搜索
     * @param examName
     * @return
     */
    List<Exam> queryExamByExamName(String examName);

    /**
     * 添加考试信息
     * @param exam
     * @return
     */
    int addExam(Exam exam);

    /**
     * 更新考试信息
     * @param exam
     * @return
     */
    int updateExam(Exam exam);

    /**
     * 删除考试考场信息
     * @param examId
     * @return
     */
    public int deleteExam(int examId);

    /**
     * 查询页码总数，（查询表中总记录数）
     * @return
     */
    Integer queryForPageTotalCount();

    /**
     * 查询 begin开始的 pageSize条记录
     * @param begin
     * @param pageSize
     * @return
     */
    List<Exam> queryForPageItems(int begin, int pageSize);
}
