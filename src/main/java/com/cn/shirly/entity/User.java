package com.cn.shirly.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private int id;
    private String userName;
    private int passWord;
    private String mail;
    private String typePrefere;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "passWord")
    public int getPassWord() {
        return passWord;
    }

    public void setPassWord(int passWord) {
        this.passWord = passWord;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "typePrefere")
    public String getTypePrefere() {
        return typePrefere;
    }

    public void setTypePrefere(String typePrefere) {
        this.typePrefere = typePrefere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (passWord != user.passWord) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (typePrefere != null ? !typePrefere.equals(user.typePrefere) : user.typePrefere != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + passWord;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (typePrefere != null ? typePrefere.hashCode() : 0);
        return result;
    }
}
