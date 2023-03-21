package com.castis.ketchup.repository;

import com.castis.ketchup.dto.ProductDTO;
import com.castis.ketchup.entity.User;
import com.castis.ketchup.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductRepository {

    List<Product> getProductList();
    List<ProductDTO> getTop5Product();

    void setProductInterest(String product_id, String user_id);


}
