package com.api.springmapstructdemo.mapper;

import com.api.springmapstructdemo.dto.ProductDto;
import com.api.springmapstructdemo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "product.desc", target = "description") // indica como os campos "desc" e "description" devem ser mapeados.
    ProductDto modelToDto(Product product);

    @Mapping(source = "productDto.description", target = "desc")
    Product dtoToModel(ProductDto productDto); // Use os nomes das propriedades diretamente

}
