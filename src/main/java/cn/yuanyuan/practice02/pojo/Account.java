package cn.yuanyuan.practice02.pojo;

public class Account {
    private int id;
    private String username;
    private int balance;
    private long midifiedtime;

    public Account(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int userId) {
        this.id = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getMidifiedtime() {
        return midifiedtime;
    }

    public void setMidifiedtime(long midifiedtime) {
        this.midifiedtime = midifiedtime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", midifiedtime=" + midifiedtime +
                '}';
    }
}
