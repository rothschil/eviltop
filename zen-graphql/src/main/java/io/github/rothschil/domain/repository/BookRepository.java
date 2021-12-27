package io.github.rothschil.domain.repository;

import io.github.rothschil.base.persistence.jpa.repository.BaseRepository;
import io.github.rothschil.domain.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookRepository extends BaseRepository<Book,String> {

    List<Book> findByNameLike(String name);

    Book findByIdAndPageCount(String id,Integer pageCount);

    Page<Book> findByPageCount(Integer pageCount, Pageable pageable);
}
