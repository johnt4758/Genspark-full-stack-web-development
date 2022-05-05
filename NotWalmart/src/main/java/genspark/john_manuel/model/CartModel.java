package genspark.john_manuel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="shopping_cart")
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private int quantity;

    public CartModel(){}

    public CartModel(Product product, int quantity, User user){
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.date = new Date();
    }

    public Integer getId() {return id;}
    public Date getDate() {return date;}
    public Product getProduct() {return product;}
    public User getUser() {return user;}
    public int getQuantity() {return quantity;}

    public void setId( Integer id ) {this.id = id;}
    public void setDate( Date date ) {this.date = date;}
    public void setProduct( Product product ) {this.product = product;}
    public void setUser( User user ) {this.user = user;}
    public void setQuantity( int quantity ) {this.quantity = quantity;}
}
