package com.ton.liteerp.domain.catalog;

import java.math.BigDecimal;

public interface CatalogItemService {
  CatalogItem create(String name, BigDecimal price);
}
