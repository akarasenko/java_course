package ru.stqa.ptf.mantisbt.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name =  "mantis_user_table")
public class User {

    @Id
    public int id;

    public String username;

    public String email;


    public User(){
        this.username = "";
        this.email = "";
    }

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
    }
}
