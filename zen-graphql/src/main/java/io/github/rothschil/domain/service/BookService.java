package io.github.rothschil.domain.service;

import io.github.rothschil.base.persistence.jpa.service.BaseService;
import io.github.rothschil.domain.entity.Author;
import io.github.rothschil.domain.entity.Book;
import io.github.rothschil.domain.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseService<BookRepository, Book,String> {

    @Override
    public void delete(String id) {
        baseRepository.deleteById(id);
    }

    public void create(Book book) {
        baseRepository.save(book);
    }
    public Book findById(String id) {
        return baseRepository.findById(id).orElse(null);
    }

    public Book findByIdAndPageCount(String id, Integer pageCount) {
        return baseRepository.findByIdAndPageCount(id,pageCount);
    }
    @Override
    public List<Book> findAll() {
        return baseRepository.findAll();
    }

    public Page bookByPage(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Book> bookPage = baseRepository.findAll(pageRequest);
        return bookPage;
    }

    public Page<Book> booksPagingByPageCount(Integer page, Integer pageSize, Integer pageCount) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Book> bookPage = baseRepository.findByPageCount(pageCount, pageRequest);
        return bookPage;
    }

    public List<Book> booksLikeByName(String name) {
        List<Book> bookList = baseRepository.findByNameLike("%"+name+"%");
        return bookList;
    }
}
