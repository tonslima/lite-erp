package com.ton.liteerp.web.catalog.dto;

import com.ton.liteerp.domain.catalog.CatalogItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CatalogItemResponse(
    UUID id,
    String name,
    BigDecimal price,
    Boolean active,
    LocalDateTime createdAt
) {
  public static CatalogItemResponse from(CatalogItem item) {
    return new CatalogItemResponse(
        item.getId(),
        item.getName(),
        item.getPrice(),
        item.getActive(),
        item.getCreatedAt()
    );
  }
}
