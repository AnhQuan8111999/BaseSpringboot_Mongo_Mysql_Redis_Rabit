package com.ringme.SpringbootDemo1.dao;

import com.ringme.SpringbootDemo1.entity.redis.Product;

import java.util.List;

public interface ProductDao {
     String create(Product product);

     List<Product> getAll();

     Product findProductById (long id);

     String deleteProduct(long id);
}
