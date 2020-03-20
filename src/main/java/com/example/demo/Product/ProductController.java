package com.example.demo.Product;

import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true",origins = {"*"})
public class ProductController {
    @Autowired
    ProductService productService;
    //查出所有的产品
    @RequestMapping(value = "/get/product/All",method = RequestMethod.GET)
    public Result selectAllProduct(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String sessionId = "";
        if(cookies == null || cookies.length == 0){
            System.out.println("cookies为空");
        }else {
            for (Cookie str : cookies) {
                if(str.getName().equals("email")){
                   sessionId= str.getValue();
                }
                System.out.println(str.getName() + " " + str.getValue());
            }
        }
//        Object attribute = request.getSession().getAttribute(sessionId);
//        System.out.println((String)attribute);
//        if(cookie == null || cookie == ""){
//            System.out.println("cookie为空");
//        }else {
//            System.out.println(cookie);
//        }
        List<Product> products = productService.selectAll();
        if(products != null) {
            return new Result(Msg.SelectAllProductSuccess,products);
        }else {
            return new Result(Msg.SelectAllProductFailed);
        }
    }
    //根据ID查询产品
    @RequestMapping(value = "/get/product/{Id}",method = RequestMethod.GET)
    public Result selectProductById(@PathVariable("Id") int id, @CookieValue("loginUser") String cookie){
        Optional<Product> product = productService.selectProductById(id);
        if(product != null) {
            System.out.println(cookie);
            return new Result(Msg.SelectProductByIdSuccess,product);
        }else {
            return new Result(Msg.SelectProductByIdFailed);
        }
    }
    //添加或者修改商品
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
