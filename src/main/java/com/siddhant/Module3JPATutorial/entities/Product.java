package com.siddhant.Module3JPATutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "sku"),
                @UniqueConstraint(columnNames = "title")
        },
        indexes = {
                @Index(name = "idx_sku",columnList = "sku")
        }
      )
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String sku;

    //We can define various Parameters in @Column like "name"(when we want to change the column name),
    // "nullable"(when we don't want to add NULL values we can set this to false), "length"(where we can define MAX Length) etc.
    @Column(name = "title", nullable = false, length = 20)
    private String title;

    private BigDecimal price;
    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
