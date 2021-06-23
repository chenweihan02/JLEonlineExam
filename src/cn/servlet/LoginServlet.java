package cn.servlet;

import cn.bean.Student;
import cn.bean.Teacher;
import cn.service.impl.StudentServiceImpl;
import cn.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xiaochen
 * @create 2021-06-16 22:01
 */
@WebServlet(name="login",urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {

    private StudentServiceImpl studentService = new StudentServiceImpl();
    private TeacherServiceImpl teacherService = new TeacherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        HttpSession session = req.getSession();
        session.setAttribute("type", type);
        if ("0".equals(type)) { // 学生
            Student student = studentService.login(username, password);
            if (student != null) {
                session.setAttribute("user", student);
                resp.sendRedirect("page/Student/index.jsp");
                System.out.println("学生登录成功");
            }else {
                System.out.println("学生登录失败");
                req.setAttribute("loginError0", "用户名或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);//转发请求
            }
        } else if ("2".equals(type)){ // 管理员
            Teacher teacher = teacherService.login(username, password);
            if (teacher != null && teacher.getIsAdmin() == 1) {
                session.setAttribute("user", teacher);
                System.out.println("管理员登录成功");
            }else {
                System.out.println("管理员登录失败");
                req.setAttribute("loginError2", "用户名或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            Teacher teacher = teacherService.login(username, password);
            if (teacher != null) {
                session.setAttribute("user", teacher);
                resp.sendRedirect("page/Teacher/index.jsp");
                System.out.println("老师登录成功");
            }else {
                System.out.println("老师登录失败");
                req.setAttribute("loginError1", "用户名或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
    }

}
