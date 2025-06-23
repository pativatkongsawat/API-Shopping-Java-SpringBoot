package com.example.spring.helper;

public class RequestProduct {

    private Integer id;
    private Double price;
    private Integer quantity;

    public RequestProduct(){};

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price = price;}
    
    public Integer getQuantity() {return quantity;}
    public void setQuantity(Integer quantity){this.quantity = quantity;}
    
}
