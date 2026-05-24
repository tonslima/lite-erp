package com.ton.liteerp.infrastructure.repository.catalog;

import com.ton.liteerp.domain.catalog.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, UUID> { }
