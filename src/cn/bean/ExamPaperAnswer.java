package cn.bean;

/**
 *  试卷答题信息实体
 *  小明在高数第一题的做题情况
 * @author xiaochen
 * @create 2021-06-16 20:28
 */
public class ExamPaperAnswer {
    private Long id; //
    private Long examId; // 所属考试id
    private Long studentId; // 所属学生id
    private Long examPaperId; //所属试卷id
    private Long questionId; // 所属试题id
    private String answer; // 提交答案
    private int isCorrent; // 是否正确

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(Long examPaperId) {
        this.examPaperId = examPaperId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
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
