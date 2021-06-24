package cn.servlet;

import cn.bean.Log;
import cn.service.impl.LogServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-24 15:56
 */
@WebServlet(name="admin",urlPatterns={"/admin"})
public class AdminServlet extends BaseServlet {
    private LogServiceImpl logService = new LogServiceImpl();
    protected void log(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Log> logList = logService.read();
            req.setAttribute("logList", logList);
            req.getRequestDispatcher("page/Admin/log.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
