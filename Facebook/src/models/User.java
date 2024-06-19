package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {


    String name;
    String email;
    String password;

    public User(String nam, String emal, String pwd){
        this.name=nam;
        this.email=emal;
        this.password =pwd;



    }


}
