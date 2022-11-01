package com.stussy.stussyclone20220930oh.service;

import com.stussy.stussyclone20220930oh.dto.CheckoutRespDto;
import com.stussy.stussyclone20220930oh.dto.CollectionListRespDto;

import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;

    public Object getProduct(int pdtId) throws Exception;

    public CheckoutRespDto getCheckoutProduct(int pdtDtlId) throws Exception;
}
