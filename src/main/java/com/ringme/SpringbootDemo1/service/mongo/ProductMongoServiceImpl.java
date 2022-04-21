package com.ringme.SpringbootDemo1.service.mongo;

import com.ringme.SpringbootDemo1.dao.mongo.ProductMongoDao;
import com.ringme.SpringbootDemo1.entity.mongoDb.ProductMongo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMongoServiceImpl implements ProductMongoService {

    @Autowired
    ProductMongoDao productMongoDao;

    private static Logger logger = Logger.getLogger(ProductMongoServiceImpl.class);

    @Override
    public List<ProductMongo> getAllProduct() {
        return productMongoDao.getAllProduct();
    }

    @Override
    public void createProduct(ProductMongo productMongo) {
            productMongoDao.createProduct(productMongo);
    }

    @Override
    public void updateProduct(ProductMongo productMongoRq) {
        ProductMongo productMongo = productMongoDao.getById(productMongoRq.getIdProduct());
        if (productMongo != null) {
            productMongo.setNameProduct(productMongoRq.getNameProduct());
            productMongo.setQuantityProduct(productMongoRq.getQuantityProduct());
            productMongo.setPrice(productMongoRq.getPrice());
            productMongoDao.updateProduct(productMongo);
        } else {
            logger.info("Product need update does exit");
        }
    }

    @Override
    public void DeleteProduct(String idProduct) {
        productMongoDao.DeleteProduct(idProduct);
    }

    @Override
    public ProductMongo getById(String idProduct) {
        ProductMongo productMongo = productMongoDao.getById(idProduct);
        return productMongo;
    }

    @Override
    public List<ProductMongo> getByName(String nameProduct) {
        return productMongoDao.getByName(nameProduct);
    }
}
