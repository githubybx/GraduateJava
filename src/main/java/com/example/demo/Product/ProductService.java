package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;
    //查出所有商品
    public List<Product> selectAll(){
        return productDao.findAll();
    }
    //根据id查找商品
    public Optional<Product> selectProductById(int id){
        return productDao.findById(id);
    }
    //添加或者修改商品
    public Product updateOrAdd(Product product){
         return productDao.save(product);
    }
 }
