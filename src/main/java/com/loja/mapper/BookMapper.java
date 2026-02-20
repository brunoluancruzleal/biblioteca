package com.loja.mapper;

import com.loja.dtos.Requeste.BookRequestDTO;
import com.loja.dtos.Response.BookResponseDTO;
import com.loja.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(BookRequestDTO bookDTO);

    BookResponseDTO toDTO(Book book);

}
