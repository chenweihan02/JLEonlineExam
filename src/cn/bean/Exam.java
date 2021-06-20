package cn.bean;

import java.util.Date;

/**
 *  考试信息实体
 *  exam 缺少t_id, 老师设置各自的试卷。
 * @author xiaochen
 * @create 2021-06-16 20:21
 */
public class Exam {
    private Long id;
    private String e_name; // 考试名称
    private Date startTime; // 开始时间
    private Date endTime; // 结束时间
    private int questionNum; // 试题总数
    private int totalScore; //总分
    private int idDel; //是否被删除， 1 是被删除，0 是没被删除

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getIdDel() {
        return idDel;
    }

    public void setIdDel(int idDel) {
        this.idDel = idDel;
    }
}
