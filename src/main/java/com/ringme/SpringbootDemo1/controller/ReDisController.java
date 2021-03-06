package com.ringme.SpringbootDemo1.controller;

import com.ringme.SpringbootDemo1.dao.ProductDao;
import com.ringme.SpringbootDemo1.entity.redis.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ReDisController {
    @Autowired
    ProductDao productDao;

    private static Logger logger= Logger.getLogger(ReDisController.class);

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        String s= productDao.create(product);
        logger.debug("loi "+s);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Product> products=productDao.getAll();
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Product findProductById (@PathVariable long id){
        return productDao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById (@PathVariable long id){
        return productDao.deleteProduct(id);
    }
}
