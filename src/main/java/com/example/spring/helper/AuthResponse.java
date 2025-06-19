package com.example.spring.helper;

public class AuthResponse {

    private String status;
    private String token;
    private String id;
    private String email;
    private String firstname;
    private String lastname;
    private int permissionId;

    public AuthResponse(){}

    public String getStatus(){return status;}
    public void setStatus(String status){this.status = status;}

    public String getToken(){return token;}
    public void setToken(String token){this.token = token;}

    public String getId(){return id;}
    public void setId(String id){this.id = id;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getFirstName(){return firstname;}
    public void setFirstName(String firstname) {this.firstname = firstname;}

    public String getLastName(){return lastname;}
    public void setLastName(String lastname){this.lastname = lastname;}

    public Integer getPermissionId(){return permissionId;}
    public void setPermissionId(Integer permissionId){this.permissionId = permissionId;}
    
}
