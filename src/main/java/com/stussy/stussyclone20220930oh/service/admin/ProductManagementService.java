package com.stussy.stussyclone20220930oh.service.admin;

import com.stussy.stussyclone20220930oh.dto.admin.CategoryResponseDto;
import com.stussy.stussyclone20220930oh.dto.admin.ProductMstOptionRespDto;
import com.stussy.stussyclone20220930oh.dto.admin.ProductRegisterReqDto;

import java.util.List;

public interface ProductManagementService {

    public List<CategoryResponseDto> getCategoryList() throws Exception;
    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception;
    public List<ProductMstOptionRespDto> getProductMstList() throws Exception;
}
