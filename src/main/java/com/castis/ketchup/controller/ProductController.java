package com.castis.ketchup.controller;

import com.castis.ketchup.dto.ProductDTO;
import com.castis.ketchup.entity.Response;
import com.castis.ketchup.entity.product.Product;
import com.castis.ketchup.global.error.StatusCode;
import com.castis.ketchup.service.ProductService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/app")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{APP_TYPE}/product/getProductList")
    public Response getProductList(
            @RequestParam(name = "location", required = false) String location,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "price", required = false) String price,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "page", required = false) String page,
            @PathVariable("APP_TYPE") String app_type) {

        List<ProductDTO> productList = productService.getProductList(location, category, price, search, page);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
        JSONObject resObject = new JSONObject();
        resObject.put("productList", productList);

        return new Response(StatusCode.OK, "성공", resObject);


    }

    @GetMapping(value = "/{APP_TYPE}/product/getTop5Product")
    public Response getTop5ProductID(@PathVariable("APP_TYPE") String app_type, HttpServletRequest req) {
        Response result = null;
        try {
            List<ProductDTO> top5Product = productService.getTop5Product();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            JSONObject resObject = new JSONObject();
            resObject.put("productList", top5Product);
            result = new Response(StatusCode.OK, "성공", resObject);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
            result = new Response(StatusCode.INTERNAL_SERVER_ERROR, "에러입니다");
            return result;
        }
        return result;

    }

    @PostMapping(value = "/{APP_TYPE}/product/setProductInterest")
    public Response setProductInterest(@PathVariable("APP_TYPE") String app_type, HttpServletRequest req
            , @RequestParam(name = "product_id") String product_id
            , @RequestParam(name = "user_id") String user_id
            , @RequestParam(name = "reg_date", required = false) String reg_date) {
        Response result = null;
        try {
            productService.setProductInterest(product_id, user_id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            result = new Response(StatusCode.OK, "성공");
        } catch (Exception e) {
            logger.error(e.toString());
            result = new Response(StatusCode.INTERNAL_SERVER_ERROR, "에러");
            return result;
        }
        return result;
    }

    @PostMapping(value = "/{APP_TYPE}/product/setProductReg")
    public Response addProduct(
            @RequestParam(name = "product_id") String product_id,
            @RequestParam(name = "location_id") String location_id,
            @RequestParam(name = "category_id") String category_id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "contents") String contents,
            @RequestParam(name = "price", required = false) int price,
            @RequestParam(name = "photo", required = false) String photo,
            @RequestParam(name = "photo_path", required = false) String photo_path,
            @RequestParam(name = "reg_user", required = false) String reg_user,
            @RequestParam(name = "reg_date", required = false) String reg_date,
            @RequestParam(name = "get_user", required = false) String get_user,
            @RequestParam(name = "get_date", required = false) String get_date,
            @RequestParam(name = "product_YN", required = false) String product_YN,
            @RequestParam(name = "product_del_YN", required = false) String product_del_YN
    ) {
        Response result = null;
        try {
            productService.addProduct(product_id, location_id, category_id, title, contents, price, photo, photo_path, reg_user, reg_date, get_user, get_date, product_YN, product_del_YN);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            result = new Response(StatusCode.OK, "성공");
        } catch (Exception e) {
            logger.error(e.toString());
            result = new Response(StatusCode.INTERNAL_SERVER_ERROR, "에러");
            return result;
        }
        return result;
    }

    @PutMapping(value = "/{APP_TYPE}/product/setProductEdit")
    public Response editProduct(
            @RequestParam(name = "product_id") String product_id,
            @RequestParam(name = "location_id") String location_id) {
        Response result = null;
        try {
            productService.editProduct(product_id, location_id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            result = new Response(StatusCode.OK, "성공");
        } catch (Exception e) {
            logger.error(e.toString());
            result = new Response(StatusCode.INTERNAL_SERVER_ERROR, "에러");
            return result;
        }
        return result;

    }

    @DeleteMapping(value = "/{APP_TYPE}/product/setProductDelete")
    public Response deleteProduct(@RequestParam(name = "product_id") String product_id){
        Response result = null;

        try {
            productService.deleteProduct(product_id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            result = new Response(StatusCode.OK, "성공");
        }catch (Exception e){
            logger.error(e.toString());
            result = new Response(StatusCode.INTERNAL_SERVER_ERROR, "에러");
            return result;
        }
        return result;
    }


}
