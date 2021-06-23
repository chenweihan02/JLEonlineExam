package cn.bean;

import java.util.Date;

/**
 *  考试信息实体
 *  exam 缺少t_id, 老师设置各自的试卷。
 * @author xiaochen
 * @create 2021-06-16 20:21
 */
public class Exam {
    private int id;
    private String examName; // 考试名称
    private Date startTime; // 开始时间
    private Date endTime; // 结束时间
    private int questionNum; // 试题总数
    private int totalScore; //总分
    private int isDel; //是否被删除， 1 是被删除，0 是没被删除

    public Exam() {
    }

    public Exam(int id, String examName, Date startTime, Date endTime, int questionNum, int totalScore, int isDel) {
        this.id = id;
        this.examName = examName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.questionNum = questionNum;
        this.totalScore = totalScore;
        this.isDel = isDel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
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

    public int getIsDel() { return isDel; }

    public void setIsdDel(int isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", questionNum=" + questionNum +
                ", totalScore=" + totalScore +
                ", idDel=" + isDel +
                '}';
    }
}
