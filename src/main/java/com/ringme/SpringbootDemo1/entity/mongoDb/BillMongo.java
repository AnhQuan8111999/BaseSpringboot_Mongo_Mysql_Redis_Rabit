package com.ringme.SpringbootDemo1.entity.mongoDb;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bill")
public class BillMongo {

    @Id
    @Nullable
    private String id;

    private UserMongo userMongo;

    private List<ProductMongo>  productMongos;
}
