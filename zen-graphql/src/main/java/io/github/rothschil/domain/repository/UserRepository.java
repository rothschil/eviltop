package io.github.rothschil.domain.repository;

import io.github.rothschil.base.persistence.jpa.repository.BaseRepository;
import io.github.rothschil.domain.entity.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User,Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    List<User> findByGender(int gender);
}
