package com.ringme.SpringbootDemo1.service.mongo;

import com.ringme.SpringbootDemo1.entity.mongoDb.ProductMongo;

import java.util.List;

public interface ProductMongoService {
    List<ProductMongo> getAllProduct();

    void createProduct(ProductMongo productMongo);

    void updateProduct(ProductMongo productMongo);

    void DeleteProduct (String idProduct);

    ProductMongo getById (String idProduct);

    List<ProductMongo> getByName(String nameProduct);
}
