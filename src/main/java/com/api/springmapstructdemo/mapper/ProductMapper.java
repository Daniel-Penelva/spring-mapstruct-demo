package com.api.springmapstructdemo.mapper;

import com.api.springmapstructdemo.dto.ProductDto;
import com.api.springmapstructdemo.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "product.desc", target = "description", defaultValue = "description") // indica como os campos "desc" e "description" devem ser mapeados.
    @Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "product.items", target = "itemsList")
    ProductDto modelToDto(Product product);

    @InheritInverseConfiguration
    Product dtoToModel(ProductDto productDto); // Use os nomes das propriedades diretamente

}
