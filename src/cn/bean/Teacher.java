package cn.bean;

/** 老师通过id 和 password进行登录
 * @author xiaochen
 * @create 2021-06-16 20:07
 */
public class Teacher {
    private int id;
    private String teacherId; // id 工号
    private String name; // 名字
    private String password; // 密码
    private int isAdmin; // 0, 1权限

    public Teacher() {
    }

    public Teacher(int id, String teacherId, String name, String password, int isAdmin) {
        this.id = id;
        this.teacherId = teacherId;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
