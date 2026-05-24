package com.ton.liteerp.application.catalog;

import com.ton.liteerp.domain.catalog.CatalogItem;
import com.ton.liteerp.domain.catalog.CatalogItemService;
import com.ton.liteerp.infrastructure.repository.catalog.CatalogItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CatalogItemServiceImpl implements CatalogItemService {

  private final CatalogItemRepository catalogRepository;

  public CatalogItemServiceImpl(CatalogItemRepository catalogRepository) {
    this.catalogRepository = catalogRepository;
  }

  @Override
  public CatalogItem create(String name, BigDecimal price) {
    var item = new CatalogItem(name, price);

    return catalogRepository.save(item);
  }
}
