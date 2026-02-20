package com.loja.exeception;

import java.util.Date;

public record ExeceptionResponde(
        String mensagem,
        Integer status,
        Date date,
        String description
) {
}
