package io.github.rothschil.domain.entity;

import io.github.rothschil.base.persistence.jpa.entity.BaseJpaPo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author extends BaseJpaPo<String> {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
