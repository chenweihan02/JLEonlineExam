package cn.servlet;

import cn.bean.Exam;
import cn.bean.ExamPaper;
import cn.bean.Level;
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
 * @create 2021-06-17 10:41
 *
 * 1. list: （所有考试列表）
 * 增加删除考考试
 * 2. 考试成绩统计
 * 3.
 */
@WebServlet(name = "TeacherServlet", urlPatterns = {"/teacher"})
public class TeacherServlet extends BaseServlet {
    private ExamServiceImpl examService = new ExamServiceImpl();
    private ExamPaperServiceImpl examPaperService = new ExamPaperServiceImpl();

    /**
     * 查询所有没背删除的考试的exam。和学生的一样显示出来，新增回收站，可以撤回删除内容，可以选择恢复考试
     * @param req
     * @param resp
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Exam> examList = examService.queryExams(0);
            req.setAttribute("examList", examList);
            req.getRequestDispatcher("page/Teacher/listExam.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 1. exam成绩获取分析，获取自己创建的考试，对每门科目的level 进行统计
     * 2. 先遍历获取所有的exam，再通过exampaper 对每个examId 统计每个学生的成绩 level统计
     * @param req
     * @param resp
     */
    protected void analysis(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Exam> examList = examService.queryExams(0);
            Map<String, Level> analysisMap = new HashMap<String, Level>(); // 考试名称和考试成绩。
            for (Exam exam : examList) {
                //exam.getId下的所有考生的成绩
                List<ExamPaper> examPapers = examPaperService.query(exam.getId());
//                List<ExamPaper> examPapers = DaoFactory.getInstance().getExamPaperDao().query(exam.getId());
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
                analysisMap.put(exam.getExamName(),level);
            }
            req.setAttribute("analysisMap", analysisMap);
            req.getRequestDispatcher("page/Teacher/analysis.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
