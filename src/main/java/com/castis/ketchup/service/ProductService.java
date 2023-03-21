package com.castis.ketchup.service;

import com.castis.ketchup.dto.ProductDTO;
import com.castis.ketchup.entity.Response;
import com.castis.ketchup.entity.product.Product;
import com.castis.ketchup.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList()
    {
        return  productRepository.getProductList();
    }

    public List<ProductDTO> getTop5Product(){

        return productRepository.getTop5Product();
    }

    public void setProductInterest(String product_id,String user_id){
        productRepository.setProductInterest(product_id,user_id);
    }
}
