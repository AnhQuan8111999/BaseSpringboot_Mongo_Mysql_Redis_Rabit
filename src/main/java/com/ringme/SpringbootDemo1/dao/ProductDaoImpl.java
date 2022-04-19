package com.ringme.SpringbootDemo1.dao;

import com.ringme.SpringbootDemo1.entity.redis.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String create(Product product) {
        redisTemplate.opsForHash().put("Product",product.getId(),product);
        return "product create";
    }

    @Override
    public List<Product> getAll() {
        return redisTemplate.opsForHash().values("Product");
    }

    @Override
    public Product findProductById(long id) {
        return (Product) redisTemplate.opsForHash().get("Product",id);
    }

    @Override
    public String deleteProduct(long id) {
        redisTemplate.opsForHash().delete("Product",id);
        return "product removed !";
    }
}
