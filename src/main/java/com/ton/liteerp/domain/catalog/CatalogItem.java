package com.ton.liteerp.domain.catalog;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "catalog_items")
public class CatalogItem {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private BigDecimal price;

  @Column(nullable = false)
  private Boolean active;

  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  public CatalogItem() {
  }

  public CatalogItem(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
    this.active = true;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Boolean getActive() {
    return active;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    CatalogItem that = (CatalogItem) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}
