package com.api.springmapstructdemo.mapper;

import com.api.springmapstructdemo.dto.ProductDto;
import com.api.springmapstructdemo.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto modelToDto(Product product);

    List<ProductDto> modelsToDtos(List<Product> product); // mapeando uma lista de produtos

    @InheritInverseConfiguration
    Product dtoToModel(ProductDto productDto);

}
