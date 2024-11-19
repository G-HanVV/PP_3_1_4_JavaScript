package ru.truecasper.javascript.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.truecasper.javascript.dto.UserDTO;
import ru.truecasper.javascript.models.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {

    List<User> getUsers();

    void addUser(User user);

    User getUser(int id);

    User getUser(String name);

    void updateUser(User user);

    void deleteUser(int id);
}
