package axelli.otus.userservice.web;

import axelli.otus.userservice.domain.User;
import axelli.otus.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(params = "errorFrequency")
    public List<User> findAllWithErrors(@RequestParam Long errorFrequency) {
        var v = ThreadLocalRandom.current().nextDouble();
        var frequency = 1.0 / errorFrequency;
        if (v < frequency) throw new RuntimeException("Ooooops");

        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User save(@Valid @RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(
        @PathVariable Long id,
        @Valid @RequestBody User user
    ) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
