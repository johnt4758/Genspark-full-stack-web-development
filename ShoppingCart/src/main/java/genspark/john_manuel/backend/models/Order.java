package genspark.john_manuel.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") //table name set to orders specifically because ORDER is reserved by SQL
public class Order{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;
    
    private String status;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<OrderProduct> orderProducts = new ArrayList<>();
    
    @Transient
    public Double getTotalOrderPrice(){
        double totalSum = 0D;
        List<OrderProduct> orderProducts = getOrderProducts();
        for(OrderProduct product : orderProducts){
            totalSum += product.getTotalPrice();
        }
        return totalSum;
    }
    
    @Transient
    public int getNumberOfProducts(){
        return this.orderProducts.size();
    }
    
    public long getId(){return id;}
    public LocalDate getDateCreated(){return dateCreated;}
    public String getStatus(){return status;}
    public List<OrderProduct> getOrderProducts(){return orderProducts;}
    
    public void setId(long id){this.id = id;}
    public void setDateCreated(LocalDate dateCreated){this.dateCreated = dateCreated;}
    public void setStatus(String status){this.status = status;}
    public void setOrderProducts(List<OrderProduct> orderProducts){this.orderProducts = orderProducts;}
}
