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
    public Response getProductList(@PathVariable("APP_TYPE") String app_type) {

            List<Product> productList = productService.getProductList();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
            JSONObject resObject = new JSONObject();
            resObject.put("result",productList);

        return new Response(StatusCode.OK,"성공",resObject);


    }

    @GetMapping(value = "/{APP_TYPE}/product/getTop5Product")
    public Response getTop5ProductID(@PathVariable("APP_TYPE") String app_type, HttpServletRequest req) {
            Response result = null;
        try{
            List<ProductDTO> top5Product = productService.getTop5Product();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
            JSONObject resObject = new JSONObject();
            resObject.put("result",top5Product);
            result =  new Response(StatusCode.OK,"성공",resObject);
        }catch (Exception e){
            logger.error(String.valueOf(e));
            result = new Response(StatusCode.INTERNAL_SERVER_ERROR,"에러");
            return result;
        }
        return result;

    }

    @PostMapping(value = "/{APP_TYPE}/product/setProductInterest")
    public Response setProductInterest(@PathVariable("APP_TYPE") String app_type, HttpServletRequest req
            , @RequestParam(name = "product_id") String product_id
            , @RequestParam(name = "user_id") String user_id){
        Response result = null;
        try {
            productService.setProductInterest(product_id,user_id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
            result = new Response(StatusCode.OK,"성공");
        }catch (Exception e){
            logger.error(e.toString());
            result = new Response(StatusCode.INTERNAL_SERVER_ERROR,"에러");
            return result;
        }
        return result;
    }


}
