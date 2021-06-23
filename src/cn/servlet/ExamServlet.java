package cn.servlet;

import cn.bean.Exam;
import cn.bean.Page;
import cn.service.impl.ExamPaperServiceImpl;
import cn.service.impl.ExamServiceImpl;
import cn.utils.WebUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-23 13:27
 */
@WebServlet(name="exan",urlPatterns={"/exam"})
public class ExamServlet extends BaseServlet {
    private ExamServiceImpl examService = new ExamServiceImpl();
    private ExamPaperServiceImpl examPaperService = new ExamPaperServiceImpl();

    /**
     * 1. 获取请求参数 pageNo 和 pageSize
     * 2. 调用 Service.page(pageNo, pageSize): Page对象
     * 3. 保存 Page对象到Request域中
     * 4. 请求转发到页面中
     * @param req
     * @param resp
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Exam> page = examService.page(pageNo, pageSize);


    }



    /**
     * 删除考试 isDel = 1
     * @param req
     * @param resp
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) {
        int examId = Integer.parseInt(req.getParameter("examId"));
        Exam exam = examService.queryExam(examId, 0);
        exam.setIsdDel(1);
        examService.updateExamInfo(exam);
        List<Exam> examList = examService.queryExams(0);
        try {
            req.setAttribute("examList", examList);
            req.getRequestDispatcher("page/Teacher/listExam.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void detail(HttpServletRequest req, HttpServletResponse resp) {
        //TODO: 考试的详细信息。进行编辑
    }

    /**
     * 查询 isDel = 1 进入回收站
     * @param req
     * @param resp
     */
    protected void recyclebin(HttpServletRequest req, HttpServletResponse resp) {
        List<Exam> examList = examService.queryExams(1);
        try {
            req.setAttribute("examList", examList);
            req.getRequestDispatcher("page/Exam/recyclebin.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回考试列表
     * @param req
     * @param resp
     */
    protected void goback(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Exam> examList = examService.queryExams(0);
            req.setAttribute("examList", examList);
            req.getRequestDispatcher("page/Teacher/listExam.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复删除的考试
     * @param req
     * @param resp
     */
    protected void recovery(HttpServletRequest req, HttpServletResponse resp) {
        int examId = Integer.parseInt(req.getParameter("examId"));
        Exam exam = examService.queryExam(examId, 1);
        exam.setIsdDel(0);
        examService.updateExamInfo(exam);
        recyclebin(req, resp); // 再跳转回回收站页面
    }

    /**
     * 彻底删除
     * 彻底删除首先需要删除exampaperanswer，然后再删除exampaper 最后再删除exam
     * @param req
     * @param resp
     */
    protected void delPlus(HttpServletRequest req, HttpServletResponse resp) {
        int examId = Integer.parseInt(req.getParameter("examId"));
        examPaperService.deleteExamPaper(examId);
        examService.deleteExam(examId);
        recyclebin(req, resp); // 再跳转回回收站页面
    }
}
