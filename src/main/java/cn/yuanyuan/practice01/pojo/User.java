package cn.yuanyuan.practice01.pojo;

public class User {
    private int userId;
    private String userName;
    private String userPassword;

    public User(String name, String password) {
        this.userName=name;
        this.userPassword=password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
