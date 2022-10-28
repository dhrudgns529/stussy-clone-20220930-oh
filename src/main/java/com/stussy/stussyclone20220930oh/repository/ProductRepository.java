package com.stussy.stussyclone20220930oh.repository;

import com.stussy.stussyclone20220930oh.domain.CollectionsProduct;
import com.stussy.stussyclone20220930oh.domain.Product;
import com.stussy.stussyclone20220930oh.dto.ProductRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {
    public List<CollectionsProduct> getProductList(Map<String, Object> map) throws Exception;
    public Product getProduct(int pdtId) throws Exception;
}
