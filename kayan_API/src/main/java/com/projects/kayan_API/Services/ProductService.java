package com.projects.kayan_API.Services;

import com.projects.kayan_API.Entities.ProductEntity;
import com.projects.kayan_API.Exceptions.NotFoundException;
import com.projects.kayan_API.Models.ProductDTO;
import com.projects.kayan_API.Repositories.ProductRepoInt;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductService implements ProductServiceInt{

    private final ProductRepoInt productRepo;
    private final ModelMapper mapper=new ModelMapper();




    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepo.findAll().stream()
                .map(productEntity -> mapper.map(productEntity, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
            return mapper.map(productRepo.findById(id).orElseThrow(()->new NotFoundException("failed to find id: "+id)), ProductDTO.class);

    }

    @Override
    public ProductDTO addProduct(ProductDTO newProduct) {
           if(newProduct !=null)
           {

               return mapper.map(productRepo.save(mapper.map(newProduct, ProductEntity.class)), ProductDTO.class);

           }
           return null;
    }
}
