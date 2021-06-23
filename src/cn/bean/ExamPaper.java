package cn.bean;

/**
 * 试卷信息
 * @author xiaochen
 * @create 2021-06-16 20:40
 */
public class ExamPaper {
    private int id;
    private int examId; // 所属考试id
    private String studentId; // 学号
    private int totalScore; // 总分
    private int score; //该试卷得分

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
