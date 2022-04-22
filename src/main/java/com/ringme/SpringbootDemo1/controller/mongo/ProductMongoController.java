package com.ringme.SpringbootDemo1.controller.mongo;

import com.ringme.SpringbootDemo1.entity.mongoDb.ProductMongo;
import com.ringme.SpringbootDemo1.service.mongo.ProductMongoService;
import com.ringme.SpringbootDemo1.service.mongo.ProductMongoServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class ProductMongoController {

    private static Logger logger= Logger.getLogger(ProductMongoController.class);
    @Autowired
    ProductMongoService productMongoService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProduct(){
        List<ProductMongo> productMongoList = productMongoService.getAllProduct();
        return new ResponseEntity<List<ProductMongo>>(productMongoList,HttpStatus.OK);
    }

    @RequestMapping(value = {"/add"}, method = {RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    public ResponseEntity<?> addProduct(@RequestBody ProductMongo productMongoRq){
        try{
            productMongoService.createProduct(productMongoRq);
            return new ResponseEntity<>("Create product success !", HttpStatus.OK);
        }catch(Exception e){
            logger.info("Fail " + e);
            return new ResponseEntity<>("Create product UNsuccess !", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateproduct(ProductMongo productMongoRq){
        try{
            productMongoService.updateProduct(productMongoRq);
            return new ResponseEntity<>("Update product success !", HttpStatus.OK);
        }catch(Exception e){
            logger.info("Fail is : "+ e);
            return new ResponseEntity<>("Update product UNsuccess !", HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam("id") String idProduct){
        ProductMongo productMongo= productMongoService.getById(idProduct);
        if(productMongo != null){
            productMongoService.DeleteProduct(idProduct);
            return new ResponseEntity<>("Delete product success !", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Product need delete does not exits !", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getProductById(@RequestParam("id") String id ){
        ProductMongo productMongo = productMongoService.getById(id);
        return new ResponseEntity<ProductMongo>(productMongo,HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getProductByName(@RequestParam("nameProduct") String nameProduct){
        List<ProductMongo> productMongos =productMongoService.getByName(nameProduct);
        return new ResponseEntity<List<ProductMongo>>(productMongos,HttpStatus.OK);
    }
}
