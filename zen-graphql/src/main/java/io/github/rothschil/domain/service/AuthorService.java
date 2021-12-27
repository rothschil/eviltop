package io.github.rothschil.domain.service;

import io.github.rothschil.base.persistence.jpa.service.BaseService;
import io.github.rothschil.domain.entity.Author;
import io.github.rothschil.domain.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends BaseService<AuthorRepository, Author,String> {

    public Author findById(String id) {
        return baseRepository.findById(id).orElse(null);
    }
}
