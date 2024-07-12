package marvinus.santander_week.service.implem;

import marvinus.santander_week.domain.model.User;
import marvinus.santander_week.domain.repository.UserRepository;
import marvinus.santander_week.service.UserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImplem implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplem(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("User with id " + userToCreate.getId() + " already exists");
        }
        return userRepository.save(userToCreate);
    }
}
