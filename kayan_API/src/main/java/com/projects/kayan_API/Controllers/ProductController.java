package com.projects.kayan_API.Controllers;

import com.projects.kayan_API.Models.ProductDTO;
import com.projects.kayan_API.Exceptions.CustomeResponse;
import com.projects.kayan_API.Services.ProductServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductServiceInt productService;


    @PostMapping("/addproduct")
    private ProductDTO addNewProduct(@RequestBody ProductDTO new_product)
    {
        return productService.addProduct(new_product);
    }

//    @GetMapping("/get_product_by_id")
//    private ProductDTO getProductById(@RequestParam Long id)
//    {
//        return productService.getProductById(id);
//    }


    @org.jetbrains.annotations.NotNull
    @GetMapping("/getproductbyid")
    private ResponseEntity<?> getProductById(@RequestParam Long id)
    {

        CustomeResponse<ProductDTO> response =new CustomeResponse<>("01","success",Boolean.TRUE,productService.getProductById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/allproducts")
    private List<ProductDTO> getAllProducts()
    {
        return productService.getAllProducts();
    }


}
