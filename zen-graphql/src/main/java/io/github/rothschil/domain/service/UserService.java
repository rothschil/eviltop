package io.github.rothschil.domain.service;

import io.github.rothschil.base.persistence.jpa.service.BaseService;
import io.github.rothschil.domain.entity.User;
import io.github.rothschil.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<UserRepository, User, Integer> {

    @Override
    public User save(User user) {
        return baseRepository.save(user);

    }

    public User findByUsernameAndPassword(String username, String password) {
        return baseRepository.findByUsernameAndPassword(username, password);
    }

    public User findByUsername(String username) {
        return baseRepository.findByUsername(username);
    }

    public User findById(Integer userId) {
        return baseRepository.findById(userId).orElse(null);
    }

    public List<User> userByGender(int gender) {
        return baseRepository.findByGender(gender);
    }
}
