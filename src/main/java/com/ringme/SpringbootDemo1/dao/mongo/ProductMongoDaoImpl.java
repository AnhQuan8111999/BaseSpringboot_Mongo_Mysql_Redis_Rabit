package com.ringme.SpringbootDemo1.dao.mongo;

import com.ringme.SpringbootDemo1.entity.mongoDb.ProductMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductMongoDaoImpl implements ProductMongoDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ProductMongo> getAllProduct() {
        List<ProductMongo> productMongos = new ArrayList<>();
        productMongos=mongoTemplate.findAll(ProductMongo.class,"product");
        return productMongos;
    }

    @Override
    public void createProduct(ProductMongo productMongo) {

        mongoTemplate.insert(productMongo,"product");
    }

    @Override
    public void updateProduct(ProductMongo productMongo) {
        mongoTemplate.save(productMongo,"product");
    }

    @Override
    public void DeleteProduct(String id) {
        ProductMongo productMongo=mongoTemplate.findById(id,ProductMongo.class,"product");
        mongoTemplate.remove(productMongo,"product");
    }

    @Override
    public ProductMongo getById(String id) {
        ProductMongo productMongo=mongoTemplate.findById(id,ProductMongo.class,"product");
        return productMongo;
    }

    @Override
    public List<ProductMongo> getByName(String nameProduct) {
        List<ProductMongo> productMongos=new ArrayList<>();
        Query query= new Query(Criteria.where("nameProduct").regex(nameProduct));

        Query query1= new Query(Criteria.where("nameProduct").regex("^" + nameProduct) ); // find all product start = nameProduct

        Query query2= new Query(Criteria.where("nameProduct").regex( nameProduct+"$") );  // find all product end = nameProduct

        productMongos=mongoTemplate.find(query2,ProductMongo.class,"product");
        return productMongos;
    }
}
