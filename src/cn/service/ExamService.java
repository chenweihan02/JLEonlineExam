package cn.service;

import cn.bean.Exam;
import cn.bean.Page;

import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-22 12:12
 */
public interface ExamService {
    /**
     * 根据id 和 isDel 查询考试考场
     * @param id Exam id
     * @param isDel 是否被删除
     * @return
     */
    public Exam queryExam(int id, int isDel);

    /**
     * 查询所有考试考场信息
     * @return
     */
    public List<Exam> queryExams();

    /**
     *  根据isDel 查询所有考试
     * @param isDel 是否被删除
     * @return
     */
    public List<Exam> queryExams(int isDel);

    /**
     * 模糊查询 考试名称
     * @param examName
     * @return
     */
    public List<Exam> queryExams(String examName);


    /**
     * 更新Exam考场信息
     * @param exam
     */
    public int updateExamInfo(Exam exam);

    /**
     * 删除考试考场信息
     * @param examId
     * @return
     */
    public int deleteExam(int examId);


    /**
     *  分页信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<Exam> page(int pageNo, int pageSize);
}
