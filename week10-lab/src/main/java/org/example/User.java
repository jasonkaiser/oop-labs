package org.example;

public abstract class User {

    private String username;

    public User(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

@UserPermission(permission = "user")
class RegularUser extends User{

    public RegularUser(String username){
        super(username);
    }
}

@UserPermission(permission = "admin")
class AdminUser extends User{

    public AdminUser(String username){
        super(username);
    }
}