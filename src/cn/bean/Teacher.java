package cn.bean;

/** 老师通过id 和 password进行登录
 * @author xiaochen
 * @create 2021-06-16 20:07
 */
public class Teacher {
    private String t_id; // id 工号
    private String t_name; // 名字
    private String t_password; // 密码
    private int t_isadmin; // 0, 1权限

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public int getT_isadmin() {
        return t_isadmin;
    }

    public void setT_isadmin(int t_isadmin) {
        this.t_isadmin = t_isadmin;
    }
}
