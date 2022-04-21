package com.ringme.SpringbootDemo1.entity.mongoDb;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMongo {

    @Id
    @Nullable
    private String idProduct;

    @Field(value="nameProduct")
    private String nameProduct;

    @Field(value="quantityProduct")
    private long quantityProduct;

    @Field(value="price")
    private Double price;
}
