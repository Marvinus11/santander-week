package marvinus.santander_week.service;

import marvinus.santander_week.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
