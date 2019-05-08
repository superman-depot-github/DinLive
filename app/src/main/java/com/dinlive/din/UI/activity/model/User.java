package com.dinlive.din.UI.activity.model;

public class User {

    private long id;
    private String account;
    private String password;
    private String nikename;
    private long sendnums;
    private long getnums;
    private String telephon;
    private String mail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public long getSendnums() {
        return sendnums;
    }

    public void setSendnums(long sendnums) {
        this.sendnums = sendnums;
    }

    public long getGetnums() {
        return getnums;
    }

    public void setGetnums(long getnums) {
        this.getnums = getnums;
    }

    public String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", vector_account='" + account + '\'' +
                ", vector_password='" + password + '\'' +
                ", nikename='" + nikename + '\'' +
                ", sendnums=" + sendnums +
                ", getnums=" + getnums +
                ", telephon='" + telephon + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}

