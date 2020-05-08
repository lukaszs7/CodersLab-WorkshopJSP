package com.szmolke.coderslab.submissions.model;

import java.util.List;

public class UsersGroup {
    private int id;
    private String name;
    private List<User> users;

    public UsersGroup(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public UsersGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
