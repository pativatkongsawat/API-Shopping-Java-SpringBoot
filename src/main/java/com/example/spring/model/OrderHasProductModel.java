package com.example.spring.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_has_products")
public class OrderHasProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer order_id;

    private Integer product_id;

    private Integer order_product_total;

    public OrderHasProductModel(){};

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public Integer getOrderId(){return order_id;}
    public void setOrderID(Integer order_id){this.order_id = order_id;}


    public Integer getProductId(){return product_id;}
    public void setProductId(Integer product_id){this.product_id = product_id;}

    public Integer getOrderProductTotal(){return order_product_total;}
    public void setOrderProductTotal(Integer order_product_total){this.order_product_total = order_product_total;}
}
