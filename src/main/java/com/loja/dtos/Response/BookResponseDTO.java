package com.loja.dtos.Response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookResponseDTO(
        Long id,
        String name,
        BigDecimal price,
        LocalDate laucheDate,
        Long authorId,
        Long categoryId
) {
}
