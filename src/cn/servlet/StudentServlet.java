package cn.servlet;

import cn.bean.Exam;
import cn.bean.ExamPaper;
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
 * @create 2021-06-17 7:29
 */
@WebServlet(name="student",urlPatterns={"/student"})
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("listMyExam".equals(method)) {
            //学生查看自己的考试
            this.listMyExam(req, resp);
        }
        //System.out.println("请求 StudentServlet");

    }

    //查看自己的考试试卷
    private void listMyExam(HttpServletRequest req, HttpServletResponse resp) {
        Student student = (Student) req.getSession().getAttribute("user");
        String s_id = student.getS_id();
        try {
            //根据学号，查询所有exampaper，得到exampaper集合，通过该集合，找到exam的考试信息，输出到myexam页面
            //输出考试名称，开始时间，距离结束，答卷按钮，试卷总分/试卷得分
            List<ExamPaper> examPaperList = DaoFactory.getInstance().getExamPaperDao().query(s_id);
            List<Exam> examList = new ArrayList<>();
            for (ExamPaper examPaper : examPaperList) {
                // 学生查询成绩，根据考试id以及 该考试存在 不被删除
                Exam exam = DaoFactory.getInstance().getExamDao().query(examPaper.getExamId(), 0);
                examList.add(exam);
            }
            req.setAttribute("examList", examList);
            req.getRequestDispatcher("page/Student/myexam.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
