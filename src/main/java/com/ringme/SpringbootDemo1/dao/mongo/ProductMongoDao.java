package com.ringme.SpringbootDemo1.dao.mongo;

import com.ringme.SpringbootDemo1.entity.mongoDb.ProductMongo;

import java.util.List;

public interface ProductMongoDao {
    List<ProductMongo> getAllProduct();

    void createProduct(ProductMongo productMongo);

    void updateProduct(ProductMongo productMongo);

    void DeleteProduct (String idProduct);

    ProductMongo getById (String idProduct);

    List<ProductMongo> getByName(String nameProduct);
}
