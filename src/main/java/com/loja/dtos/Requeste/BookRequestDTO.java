package com.loja.dtos.Requeste;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookRequestDTO(
        String title,
        BigDecimal price,
        LocalDate launchDate,
        Long authorId,
        Long categoryId
) {
}
