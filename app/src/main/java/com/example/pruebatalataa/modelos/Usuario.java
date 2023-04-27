package com.example.pruebatalataa.modelos;

import java.util.Date;

public class Usuario {

    private int id;
    private String email;
    private String fist_name;
    private String last_name;
    private String password;
    private int count_logged_in;
    private int indentification;
    private Date created_at;
    private Date updated_at;

    public Usuario() {
    }


    public int getCount_logged_in() {
        return count_logged_in;
    }

    public void setCount_logged_in(int count_logged_in) {
        this.count_logged_in = count_logged_in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFist_name() {
        return fist_name;
    }

    public void setFist_name(String fist_name) {
        this.fist_name = fist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getIndentification() {
        return indentification;
    }

    public void setIndentification(int indentification) {
        this.indentification = indentification;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
