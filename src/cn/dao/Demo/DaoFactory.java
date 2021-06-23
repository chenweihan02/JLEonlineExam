package cn.dao.Demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 工厂 + 单例(饿汉 创建时间长，线程安全)返回各个使用实例对象
 * @author xiaochen
 * @create 2021-06-16 21:53
 */
public class DaoFactory {
    private static DaoFactory factory = new DaoFactory();
    private Map<String, Object> map = new ConcurrentHashMap<>();
    private DaoFactory(){}

    public static DaoFactory getInstance() {
        return factory;
    }

    // 返回有关学生操作的对象
    public StudentDao getStudentDao() {
        StudentDao dao = (StudentDao) map.get("StudentDao");
        if (dao != null) {
            return dao;
        } else {
            dao = new StudentDao();
            map.put("StudentDao", dao);
        }
        return dao;
    }

    //返回有关老师操作的对象
    public TeacherDao getTeacherDao() {
        TeacherDao dao = (TeacherDao) map.get("TeacherDao");
        if (dao != null) {
            return dao;
        } else {
            dao = new TeacherDao();
            map.put("TeacherDao", dao);
        }
        return dao;
    }
    //返回有关考场操作的对象
    public ExamDao getExamDao() {
        ExamDao dao = (ExamDao) map.get("ExamDao");
        if (dao != null) {
            return dao;
        } else {
            dao = new ExamDao();
            map.put("ExamDao", dao);
        }
        return dao;
    }

    //返回exampaper操作的对象
    public ExamPaperDao getExamPaperDao() {
        ExamPaperDao dao = (ExamPaperDao) map.get("ExamPaperDao");
        if (dao != null) {
            return dao;
        } else {
            dao = new ExamPaperDao();
            map.put("ExamPaperDao", dao);
        }
        return dao;
    }

    //返回exampaperanswer操作对象
    public ExamPaperAnswerDao getExamPaperAnswerDao() {
        ExamPaperAnswerDao dao = (ExamPaperAnswerDao) map.get("ExamPaperAnswerDao");
        if (dao != null) {
            return dao;
        } else {
            dao = new ExamPaperAnswerDao();
            map.put("ExamPaperAnswerDao", dao);
        }
        return dao;
    }

    //返回question操作对象
    public QuestionDao getQuestionDao() {
        QuestionDao dao = (QuestionDao) map.get("QuestionDao");
        if (dao != null) {
            return dao;
        } else {
            dao = new QuestionDao();
            map.put("QuestionDao", dao);
        }
        return dao;
    }
}
