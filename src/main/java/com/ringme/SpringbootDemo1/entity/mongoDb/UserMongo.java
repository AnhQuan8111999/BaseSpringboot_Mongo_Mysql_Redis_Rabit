package com.ringme.SpringbootDemo1.entity.mongoDb;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "user")
public class UserMongo {
    @Id
    @Nullable
    private String id;
    @Field(value = "username")
    private String username;
    @Field(value = "password")
    private String password;
    @Field(value = "date")
    private Date date;

    @Nullable
    public String getId() {
        return id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
