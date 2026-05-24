package com.ton.liteerp.application.catalog;

import com.ton.liteerp.domain.catalog.CatalogItem;
import com.ton.liteerp.infrastructure.repository.catalog.CatalogItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatalogItemServiceImplTest {

  @Mock
  private CatalogItemRepository catalogRepository;

  @InjectMocks
  private CatalogItemServiceImpl catalogItemService;

  @Test
  void shouldCreateNewCatalogItem() {
    // arrange
    var name = "Limpeza";
    var price = BigDecimal.valueOf(299.9);
    var expected = new CatalogItem(name, price);
    when(catalogRepository.save(any(CatalogItem.class))).thenReturn(expected);

    // act
    var result = catalogItemService.create(name, price);

    // assert
    assertNotNull(result);
    assertEquals(name, result.getName());
    assertEquals(price, result.getPrice());
    verify(catalogRepository).save(any(CatalogItem.class));
  }
}
