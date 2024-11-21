package com.projects.kayan_API.Services;

import com.projects.kayan_API.Models.ProductDTO;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface ProductServiceInt {

    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO addProduct(ProductDTO newProduct);

}
