package cn.service.impl;

import cn.bean.Exam;
import cn.bean.Page;
import cn.dao.impl.ExamDaoImpl;
import cn.service.ExamService;

import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-22 12:18
 */
public class ExamServiceImpl implements ExamService {
    private ExamDaoImpl examDao = new ExamDaoImpl();

    @Override
    public Exam queryExam(int id, int isDel) {
        return examDao.queryExamByExamId(id, isDel);
    }

    @Override
    public List<Exam> queryExams() {
        return examDao.queryAllExams();
    }

    @Override
    public List<Exam> queryExams(int isDel) { return examDao.queryExamByIsDel(isDel); }

    @Override
    public List<Exam> queryExams(String examName) { return examDao.queryExamByExamName(examName); }

    @Override
    public int updateExamInfo(Exam exam) { return examDao.updateExam(exam); }

    @Override
    public int deleteExam(int examId) { return examDao.deleteExam(examId); }

    @Override
    public Page<Exam> page(int pageNo, int pageSize) {
        Page<Exam> page = new Page<Exam>();

        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = examDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) { pageTotal += 1; }

        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Exam> items = examDao.queryForPageItems(begin, pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
}
