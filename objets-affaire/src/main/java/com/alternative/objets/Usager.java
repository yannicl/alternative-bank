package com.alternative.objets;

import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Usager {
    @Id
    private long id;

    @Size(max = 80)
    private String username;

    @Size(max = 80)
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}