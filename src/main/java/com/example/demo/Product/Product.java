package com.example.demo.Product;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int pid;
    String image;
    float grade;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date;
    @NotNull
    String info;
    @NotNull
    String address;
    String pname;

    public Product(String image, float grade, Date date, String info, String address, String pname) {
        this.image = image;
        this.grade = grade;
        this.date = date;
        this.info = info;
        this.address = address;
        this.pname = pname;
    }
}
