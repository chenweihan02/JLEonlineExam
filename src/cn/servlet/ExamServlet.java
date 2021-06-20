package cn.servlet;

import cn.bean.ExamPaper;
import cn.bean.Question;
import cn.bean.Student;
import cn.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author xiaochen
 * @create 2021-06-17 20:34
 */
@WebServlet(name = "ExamServlet", urlPatterns = {"/exam"})
public class ExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        System.out.println(method);
        if ("mathTest".equals(method)) {
            this.mathTest(req, resp);
        } else if ("judge".equals(method)) {
            this.judge(req, resp);
        }
    }

    /**
     * 组卷
     * 1. 从数据库选择，在搜索框中可以搜索，
     * 2. 手动添加试卷，题目添加后，可以选择试题加入题库，方便下次组卷使用。
     * 3. 添加好试卷后， 通过选择考生， examPaperExam中添加数据，
     *
     *
     * @param req
     * @param resp
     */
    /** 简单的demo写法，获取题库中的所有题目，默认所有的考生，
     * 所属examPaper是一整张卷子，Answer是卷子中的一题
     *
     * 创建一张卷子
     *
     * 重复点击问题。
     * */
    private void mathTest(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("mathTest 启动");
        try {
            int examTotal = 0; // 所有题目的总分
            Long examId = 1L;
            //所有题目

            List<Question> questionList = DaoFactory.getInstance().getQuestionDao().query();
            for (Question question: questionList){
                examTotal += question.getScore();
            }
            //更新exam信息
            DaoFactory.getInstance().getExamDao().update(Long.valueOf(1), questionList.size(), examTotal);
            /***
             * 所有考生
             * examPaper
             * 添加,默认高数 examid = 1
             * 两个考生
             */

            ExamPaper examPaper1 = DaoFactory.getInstance().getExamPaperDao().add(examId, "2019111", examTotal);
            ExamPaper examPaper2 = DaoFactory.getInstance().getExamPaperDao().add(examId, "2019112", examTotal);

            /**
             * examPaperAnswer 添加题目。学生数量，通过exampaper where examId 比对来获取添加examPaperId
             */
            for (Question question: questionList){
                DaoFactory.getInstance().getExamPaperAnswerDao().add(examId, "2019111", examPaper1.getId(), question.getId());
                DaoFactory.getInstance().getExamPaperAnswerDao().add(examId, "2019112", examPaper2.getId(), question.getId());
            }
            /**
             * 再对 Exam questionNum totalScore 进行修改
             */
            req.setAttribute("questionList", questionList);
            req.getRequestDispatcher("page/Exam/editExamPaper.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列出所有考试项，
     * 可以进行编辑修改。
     * @param req
     * @param resp
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) {

    }

    /**
     * 新增考试
     * 1. 填写考试名称，开始时间，结束时间
     * 2. 选择考生。
     * 3. （组卷）exampaperanswer 需要考试（考场）id， 学生学号，所属试卷id，试题id，（提交答案，是否正确默认为空）
     *
     * 新增考试和试卷系统的差别。
     * @param req
     * @param resp
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) {

    }

    /**
     * 重复交卷。
     * 改卷。
     * exampaperanswer 里面的answer 和 question对比，修改isCorrent属性
     * 统计得分，回到 exampaper的 score
     * exam的 questionNum，totalScore
     * @param req
     * @param resp
     */
    private void judge(HttpServletRequest req, HttpServletResponse resp) {
        String examId = req.getParameter("examId");
        String examPaperId = req.getParameter("examPaperId");

        Student student = (Student) req.getSession().getAttribute("user");
        Map<String, String[]> parameterMap = req.getParameterMap(); // answer123 A
        int i = 0;
        int getScore = 0;
        for(Iterator iter = parameterMap.entrySet().iterator(); iter.hasNext(); i ++){
            Map.Entry element=(Map.Entry)iter.next();
            String strKey = (String) element.getKey();
            String[] value= (String[])element.getValue();
            if (i < 4) {continue;}
            String questionId = strKey.split("answer", 2)[1];

            if (value.length > 0) {
                String op = value[0]; //获得的就是选项
                //判断该题是否正确
                int isCorrent = 0;
                boolean isFlag = false;
                try {
                    Question query = DaoFactory.getInstance().getQuestionDao().query(Long.valueOf(questionId), op);
                    if (query != null) { //该选项正确
                        isFlag =true;
                        getScore += query.getScore();
                    }
                    if (isFlag) {//作答正确
                        isCorrent = 1;
                    }
                    //更新exampaperanswer
                    DaoFactory.getInstance().getExamPaperAnswerDao().update(Long.valueOf(examId), student.getS_id(), Long.valueOf(examPaperId), Long.valueOf(questionId),op, isCorrent);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //更新exampaper
        try {
            DaoFactory.getInstance().getExamPaperDao().update(Long.valueOf(examId), student.getS_id(), getScore);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("getScore", getScore);
        try {
            req.getRequestDispatcher("page/Exam/result.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
