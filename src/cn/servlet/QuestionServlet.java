package cn.servlet;

import cn.bean.Question;
import cn.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/** 对题库进行操作
 * @author xiaochen
 * @create 2021-06-17 14:48
 */
@WebServlet(name = "question", urlPatterns = {"/question"})
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("list".equals(method)){
            this.list(req, resp);
        } else if ("add".equals(method)) {
            this.add(req, resp);
        } else if ("delete".equals(method)) {
            this.delete(req, resp);
        } else if ("update".equals(method)) {
            this.update(req, resp);
        }
    }

    /**
     * 查询所有题目
     * @param req
     * @param resp
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Question> questionList = DaoFactory.getInstance().getQuestionDao().query();
            for(Question q: questionList){
                System.out.println(q.getScore());
            }
            System.out.println("=====");
            req.setAttribute("questionList", questionList);
            req.getRequestDispatcher("page/Question/editQuestion.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 题库添加题目
     * @param req
     * @param resp
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) {

    }

    /**
     * 删除题目
     * @param req
     * @param resp
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) {

    }

    /**
     * 更新题目
     * 更新题目的问题，editQuestion.jsp 里面应该默认单选框勾选，
     * 如果radio 为空，则限制不能提交，
     * 可以新增删除题目选项。
     * @param req
     * @param resp
     */
    private void update(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("update");
        Long q_id = Long.parseLong(req.getParameter("q_id"));
        int score = Integer.parseInt(req.getParameter("score"));
        String answer = req.getParameter("answer1");
        String q_title = req.getParameter("q_title");
        String q_a = req.getParameter("q_a");
        String q_b = req.getParameter("q_b");
        String q_c = req.getParameter("q_c");
        String q_d = req.getParameter("q_d");
        System.out.println(q_id + score + q_title + q_a + q_b + q_c + q_d + answer);
        try {
            DaoFactory.getInstance().getQuestionDao().update(q_id, score, q_title, q_a, q_b, q_c, q_d, answer);
            System.out.println("update");
            this.list(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}