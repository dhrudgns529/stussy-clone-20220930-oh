package com.stussy.stussyclone20220930oh.service.admin;

import com.stussy.stussyclone20220930oh.dto.admin.CategoryResponseDto;
import com.stussy.stussyclone20220930oh.dto.admin.ProductRegisterReqDto;
import com.stussy.stussyclone20220930oh.repository.admin.ProductManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManagementServiceImpl implements ProductManagementService{

    private final ProductManagementRepository productManagementRepository;

    @Override
    public List<CategoryResponseDto> getCategoryList() throws Exception {

        return null;
    }

    @Override
    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception {

    }
}
