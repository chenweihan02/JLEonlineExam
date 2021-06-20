package cn.servlet;

import cn.bean.ExamPaper;
import cn.bean.ExamPaperAnswer;
import cn.bean.Question;
import cn.bean.Student;
import cn.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-18 1:00
 */
@WebServlet(name="doExam",urlPatterns={"/doExam"})
public class DoExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doExamTest(req, resp);
    }
    /**
     * 做题，根据examId, studentId和 examPaperId 得到所有的questionId   <= examPaperExamDao
     * examPaperId 通过 exampaper表获取 传=>examId
     * 从exampaperanswer中获取题目
     * @param req
     * @param resp
     */
    private void doExamTest(HttpServletRequest req, HttpServletResponse resp) {
        String examIdStr = req.getParameter("examId");
        Student student = (Student) req.getSession().getAttribute("user");
        try {
            Long examId = Long.valueOf(examIdStr);
            ExamPaper examPaper = DaoFactory.getInstance().getExamPaperDao().query(examId, student.getS_id());
            Long examPaperId = examPaper.getId();
            List<ExamPaperAnswer> examPaperAnswerList = DaoFactory.getInstance().getExamPaperAnswerDao().query(examId, student.getS_id(), examPaperId);
            List<Question> questionList = new ArrayList<>();
            for (ExamPaperAnswer examPaperAnswer : examPaperAnswerList) {
                Question question = DaoFactory.getInstance().getQuestionDao().query(examPaperAnswer.getQuestionId());
                questionList.add(question);
            }
            req.setAttribute("questionList", questionList);
            req.setAttribute("examId", examId);
            req.setAttribute("examPaperId", examPaperId);
            req.getRequestDispatcher("page/Exam/examPaper.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
