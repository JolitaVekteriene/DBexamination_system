package lt.codeacademy.service;

import lt.codeacademy.entity.User;
import lt.codeacademy.repository.UserRepository;

import java.util.List;

public class UserService {      //biznio logika
    private final UserRepository repository;

    private final UserRepository repository() {
        return null;
    }

    public UserService() {
        repository = new UserRepository();
    }

    public void createUser (User user) {
        repository.createUser(user);
    }

    public List<User> getUsers() {
        return repository.getUsers();

    }

    public void updateUser(User user) {
        repository.updateUser(user);
    }

}

