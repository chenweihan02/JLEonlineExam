package cn.servlet;

import cn.bean.Exam;
import cn.bean.ExamPaper;
import cn.bean.Level;
import cn.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaochen
 * @create 2021-06-17 10:41
 *
 * 1. 增加删除考考试
 * 2. 考试成绩统计
 * 3.
 */
@WebServlet(name = "TeacherServlet", urlPatterns = {"/teacher"})
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        System.out.println(method);
        if ("list".equals(method)) {
            this.list(req, resp);
        } else if ("analysis".equals(method)) {
            this.analysis(req, resp);
        }
    }

    /**
     * 查询所有的exam。和学生的一样显示出来，新增回收站，可以撤回删除内容，可以选择恢复考试
     *
     * @param req
     * @param resp
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("list servlet启动");
        try {
            List<Exam> examList = DaoFactory.getInstance().getExamDao().query(0);
            req.setAttribute("examList", examList);
            req.getRequestDispatcher("page/Teacher/listExam.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * exam成绩获取分析，获取自己创建的考试，对每门科目的level 进行统计
     * 先遍历获取所有的exam，再通过exampaper 对每个examId 统计每个学生的成绩 level统计
     *
     */
    private void analysis(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Exam> examList = DaoFactory.getInstance().getExamDao().query();
            ArrayList<Long> examIds = new ArrayList<>(); // 存的考试的id
            Map<String, Level> analysisMap = new HashMap<String, Level>(); // 考试名称和考试成绩。
            for (Exam exam : examList) {
                examIds.add(exam.getId());
                //exam.getId下的所有考生的成绩
                List<ExamPaper> examPapers = DaoFactory.getInstance().getExamPaperDao().query(exam.getId());
                Level level = new Level();
                for (ExamPaper examPaper : examPapers) {
                    int score = examPaper.getScore();
                    int totalScore = exam.getTotalScore();
                    if (score < totalScore * 0.6) {
                        level.setBad(level.getBad() +  1);
                    } else if (score < totalScore * 0.7) {
                        level.setCommon(level.getCommon() + 1);
                    } else if (score <totalScore * 0.85) {
                        level.setGood(level.getGood() + 1);
                    } else {
                        level.setBest(level.getBest() + 1);
                    }
                }
                //对没被删除的考试的考试名称加入map
                analysisMap.put(DaoFactory.getInstance().getExamDao().query(exam.getId(), 0).getE_name(),level);
            }
            req.setAttribute("analysisMap", analysisMap);
            req.getRequestDispatcher("page/Teacher/analysis.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
