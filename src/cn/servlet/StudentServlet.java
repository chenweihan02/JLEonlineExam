package cn.servlet;

import cn.bean.Exam;
import cn.bean.ExamPaper;
import cn.bean.Student;
import cn.service.impl.ExamPaperServiceImpl;
import cn.service.impl.ExamServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaochen
 * @create 2021-06-17 7:29
 */
@WebServlet(name="student",urlPatterns={"/student"})
public class StudentServlet extends BaseServlet {
    private ExamPaperServiceImpl examPaperService = new ExamPaperServiceImpl();
    private ExamServiceImpl examService = new ExamServiceImpl();

    /**
     * listExam 模糊搜索
     * @param req
     * @param resp
     */
    protected void search(HttpServletRequest req, HttpServletResponse resp) {
        String examName = req.getParameter("examName");
//        try {
//            List<Exam> examList = examService.queryExams(examName);
//            req.setAttribute("examList", examList);
//            req.getRequestDispatcher("page/Teacher/log.jsp").forward(req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 获取参加考试的所有考试列表
     * 1. 根据学号，查询所有的exampaper，得到exampaper集合
     * 2. 通过该学生exampaper集合找到所有的exam的考试信息 输出到myexam页面
     * @param req
     * @param resp
     */
    protected void listMyExam(HttpServletRequest req, HttpServletResponse resp) {
        Student student = (Student) req.getSession().getAttribute("user");
        String studentId = student.getStudentId();
        try {
            //输出考试名称，开始时间，距离结束，答卷按钮，试卷总分/试卷得分
            List<ExamPaper> examPaperList = examPaperService.query(studentId);
            Map<Exam, Integer> examInfo = new HashMap<>(); //<考试对象, 分数>
            for (ExamPaper examPaper : examPaperList) {
                // 学生查询成绩，根据考试id以及该考试存在不被删除(isDel:0)
                Exam exam = examService.queryExam(examPaper.getExamId(), 0);
                int score = examPaperService.query(exam.getId(), studentId).getScore();
                examInfo.put(exam, score);
            }
            req.setAttribute("examInfo", examInfo);
            req.getRequestDispatcher("page/Student/myexam.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
