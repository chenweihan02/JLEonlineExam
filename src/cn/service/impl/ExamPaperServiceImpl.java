package cn.service.impl;

import cn.bean.ExamPaper;
import cn.dao.impl.ExamPaperDaoImpl;
import cn.service.ExamPaperService;

import java.util.List;

/**
 * @author xiaochen
 * @create 2021-06-22 14:58
 */
public class ExamPaperServiceImpl implements ExamPaperService {
    private ExamPaperDaoImpl examPaperDao = new ExamPaperDaoImpl();

    @Override
    public List<ExamPaper> query(String studentId) {
        return examPaperDao.queryExamPaperByStudentId(studentId);
    }

    @Override
    public List<ExamPaper> query(int examId) {
        return examPaperDao.queryExamPaperByExamId(examId);
    }

    @Override
    public ExamPaper query(int examId, String studentId) {
        return examPaperDao.queryExamPaperByStudentIdAndExamId(examId, studentId);
    }

    @Override
    public int deleteExamPaper(int examId) {
        return examPaperDao.deleteExamPaper(examId);
    }
}
