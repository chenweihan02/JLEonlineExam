package cn.bean;

/**
 * 学生类， 使用学号和密码进行登录账户
 * @author xiaochen
 * @create 2021-06-16 20:01
 */
public class Student {
    private int id;
    private String studentId; // 学号
    private String name; //姓名
    private String password; // 密码

    public Student() {
    }

    public Student(int id, String studentId, String name, String password) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
