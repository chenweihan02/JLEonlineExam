package cn.bean;

/**
 *  试卷答题信息实体
 *  小明在高数第一题的做题情况
 * @author xiaochen
 * @create 2021-06-16 20:28
 */
public class ExamPaperAnswer {
    private int id; //
    private int examId; // 所属考试id
    private String studentId; // 所属学生id
    private int examPaperId; //所属试卷id
    private int questionId; // 所属试题id
    private String answer; // 提交答案
    private int isCorrent; // 是否正确

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

    public int getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(int examPaperId) {
        this.examPaperId = examPaperId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getIsCorrent() {
        return isCorrent;
    }

    public void setIsCorrent(int isCorrent) {
        this.isCorrent = isCorrent;
    }
}
