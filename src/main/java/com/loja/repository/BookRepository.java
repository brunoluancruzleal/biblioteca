package com.loja.repository;

import com.loja.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


    boolean existsByAuthorId(Long authorId);
}
