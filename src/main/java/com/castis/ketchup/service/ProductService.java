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

    public List<ProductDTO> getProductList(String location, String category, String price, String search, String page) {
        return productRepository.getProductList(location, category, price, search,page);
    }

    public List<ProductDTO> getTop5Product() {

        return productRepository.getTop5Product();
    }

    public void setProductInterest(String product_id, String user_id) {
        productRepository.setProductInterest(product_id, user_id);
    }

    public void addProduct(String product_id, String location_id, String category_id, String title, String contents, int price, String photo, String photo_path, String reg_user, String reg_date, String get_user, String get_date, String product_YN, String product_del_YN) {
        Product addProduct = Product.builder()
                .product_id(product_id)
                .location_id(location_id)
                .category_id(category_id)
                .title(title)
                .contents(contents)
                .price(price)
                .photo(photo)
                .photo_path(photo_path)
                .reg_user(reg_user)
                .reg_date(reg_date)
                .get_user(get_user)
                .get_date(get_date)
                .product_YN(product_YN)
                .product_del_YN(product_del_YN)
                .build();
        productRepository.addProduct(addProduct);

    }
}
