package com.enigma.tokonyadiaboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_purchases")
public class Purchase {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    private String customerId;
    private String productId;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    @JsonIgnoreProperties({"purchases"})
//    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", customerId='" + customerId + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
