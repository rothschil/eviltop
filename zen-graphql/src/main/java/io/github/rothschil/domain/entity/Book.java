package io.github.rothschil.domain.entity;

import io.github.rothschil.base.persistence.jpa.entity.BaseJpaPo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book extends BaseJpaPo<String> {

    @Id
    private String id;

    private String name;

    private Integer pageCount;

    private String authorId;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
