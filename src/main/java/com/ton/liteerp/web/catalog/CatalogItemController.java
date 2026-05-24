package com.ton.liteerp.web.catalog;

import com.ton.liteerp.domain.catalog.CatalogItemService;
import com.ton.liteerp.web.catalog.dto.CatalogItemRequest;
import com.ton.liteerp.web.catalog.dto.CatalogItemResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogItemController {

  private final CatalogItemService catalogService;

  public CatalogItemController(CatalogItemService catalogService) {
    this.catalogService = catalogService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CatalogItemResponse registerItem(@RequestBody @Valid CatalogItemRequest request) {
    var item = catalogService.create(request.name(), request.price());

    return CatalogItemResponse.from(item);
  }
}
