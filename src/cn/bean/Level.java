package cn.bean;

/** 成绩的区间分段 划分比例
 *
 * 优良率
 * bad (0, 60)
 * common[60, 70]
 * good(70, 85]
 * best(85, 100]
 * @author xiaochen
 * @create 2021-06-17 13:23
 */

public class Level {
    private Long id;
    private Long examId;
    private int bad;
    private int common;
    private int good;
    private int best;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public int getCommon() {
        return common;
    }

    public void setCommon(int common) {
        this.common = common;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getBest() {
        return best;
    }

    public void setBest(int best) {
        this.best = best;
    }
}
