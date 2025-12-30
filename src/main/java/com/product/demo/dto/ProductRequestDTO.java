package com.product.demo.dto;

import jakarta.validation.constraints.*;

public record ProductRequestDTO(
    @NotBlank(message = "Nama produk tidak boleh kosong")
    String name,

    @NotBlank(message = "Kategori tidak boleh kosong")
    String category,

    @NotNull(message = "Harga tidak boleh kosong")
    @Min(value = 100, message = "Harga minimal adalah 100")
    Double price,

    @Min(value = 0, message = "Stok tidak boleh negatif")
    Integer stock
) {}