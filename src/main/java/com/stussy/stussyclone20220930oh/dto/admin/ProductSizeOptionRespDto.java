package com.stussy.stussyclone20220930oh.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductSizeOptionRespDto {
    private int sizeId;
    private String sizeName;
}
