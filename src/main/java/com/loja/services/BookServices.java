package com.loja.services;

import com.loja.dtos.Requeste.BookRequestDTO;
import com.loja.dtos.Response.BookResponseDTO;
import com.loja.exeception.SearchExceptionNotFound;
import com.loja.mapper.BookMapper;
import com.loja.model.Author;
import com.loja.model.Book;
import com.loja.model.Category;
import com.loja.repository.AuthorRepository;
import com.loja.repository.BookRepository;
import com.loja.repository.CategoryRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServices {
    @Autowired
    BookMapper bookMapper;

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRespository categoryRespository;

    public BookServices(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRespository categoryRespository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRespository = categoryRespository;
    }


    public Page<BookResponseDTO> findAll(Pageable pageable) {
        Page<Book> page = bookRepository.findAll(pageable);
        return page.map(bookMapper::toDTO);
    }

    public BookResponseDTO findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(
                        () -> new SearchExceptionNotFound("Não existe esse ID")
                );

        return bookMapper.toDTO(book);
    }

    @Transactional
    public BookResponseDTO createBook(BookRequestDTO dto) {

        Book book = bookMapper.toEntity(dto);

        Author author = authorRepository.findById(dto.authorId())
                .orElseThrow(() -> new SearchExceptionNotFound("Author não encontrado"));

        Category category = categoryRespository.findById(dto.categoryId())
                .orElseThrow(() -> new SearchExceptionNotFound("Categoria não encontrada"));


        book.setTitle(dto.title());
        book.setPrice(dto.price());
        book.setLaunchDate(dto.launchDate());
        book.setAuthor(author);
        book.setCategory(category);

        Book save = bookRepository.save(book);

        return bookMapper.toDTO(save);
    }

    @Transactional
    public BookResponseDTO updateBook(BookRequestDTO dto, Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(
                        () -> new SearchExceptionNotFound("Não existe esse ID")
                );


        Author author = authorRepository.findById(dto.authorId())
                .orElseThrow(() -> new SearchExceptionNotFound("Author não encontrado"));

        Category category = categoryRespository.findById(dto.categoryId())
                .orElseThrow(() -> new SearchExceptionNotFound("Categoria não encontrada"));


        book.setTitle(dto.title());
        book.setPrice(dto.price());
        book.setLaunchDate(dto.launchDate());
        book.setAuthor(author);
        book.setCategory(category);

        Book save = bookRepository.save(book);

        return bookMapper.toDTO(save);
    }


    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(
                        () -> new SearchExceptionNotFound("Não existe esse ID")
                );
        if (bookRepository.existsByAuthorId(id)) {
            throw new RuntimeException("Não é possível deletar autor que possui livros cadastrados");
        }

        bookRepository.delete(book);
    }
}
