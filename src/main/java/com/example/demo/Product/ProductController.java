package com.example.demo.Product;

import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;
    //查出所有的产品
    @CrossOrigin
    @RequestMapping(value = "/get/product/All",method = RequestMethod.GET)
    public Result selectAllProduct(){
        List<Product> products = productService.selectAll();
        if(products != null) {
            return new Result(Msg.SelectAllProductSuccess,products);
        }else {
            return new Result(Msg.SelectAllProductFailed);
        }
    }
    //根据ID查询产品
    @CrossOrigin
    @RequestMapping(value = "/get/product/{Id}",method = RequestMethod.GET)
    public Result selectProductById(@PathVariable("Id") int id){
        Optional<Product> product = productService.selectProductById(id);
        if(product != null) {
            return new Result(Msg.SelectProductByIdSuccess,product);
        }else {
            return new Result(Msg.SelectProductByIdFailed);
        }
    }
    //添加或者修改商品
    @CrossOrigin
    @RequestMapping(value = "/post/produce/updateOrAdd",method = RequestMethod.POST)
    public Result updateOrAddProduct(@RequestBody Product product){
        Product product1 = productService.updateOrAdd(product);
        if(product != null) {
            return new Result(Msg.UpdateUserInfoSuccess, product1);
        }else {
            return new Result(Msg.UpdateUserInfoFailed, product1);
        }
    }
}
