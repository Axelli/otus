package axelli.otus.userservice.service;

import axelli.otus.userservice.domain.User;
import axelli.otus.userservice.exception.ResourceNotFoundException;
import axelli.otus.userservice.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@Data
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found. id = " + id));
    }

    public List<User> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(toList());
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User update(User user) {
        if (repository.existsById(user.getId())) {
            return repository.save(user);
        }

        throw new ResourceNotFoundException("User not found. id = " + user.getId());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
