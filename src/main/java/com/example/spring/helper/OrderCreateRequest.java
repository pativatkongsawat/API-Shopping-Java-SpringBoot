package com.example.spring.helper;

import java.util.List;

public class OrderCreateRequest {

    private List<RequestProduct> products;
    private String userId;
    private String email;

    public OrderCreateRequest() {}

    public List<RequestProduct> getProducts() {return products;}
    public void setProducts(List<RequestProduct> products) {this.products = products;}

    public String getUserId(){return userId;}
    public void setUserId(String userId){this.userId = userId;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}


}
