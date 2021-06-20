package cn.bean;

/**
 * 学生类， 使用学号和密码进行登录账户
 * @author xiaochen
 * @create 2021-06-16 20:01
 */
public class Student {
    private Long id;
    private String s_id; // 学号
    private String s_name; //姓名
    private String s_password; // 密码

    public Student() {
    }

    public Student(Long id, String s_id, String s_name, String s_password) {
        this.id = id;
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_password = s_password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", s_id='" + s_id + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_password='" + s_password + '\'' +
                '}';
    }
}
