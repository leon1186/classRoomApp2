package com.example.classRoomAPI.models;
import com.example.classRoomAPI.helper.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name",length = 100,nullable = false)
    private String name;

    @Column(name = "password", length = 255,nullable = false)
    private String password;

    @Column(name = "email",length = 150,unique = true,nullable = false)
    private String email;

    @Column(name = "telephone",length = 20,nullable = true)
    private String telephone;


    private UserType userType;

    public User() {
    }

    public User(Integer userId, String name, String password, String email, String telephone, UserType userType) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
