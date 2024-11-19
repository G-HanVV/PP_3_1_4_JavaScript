package ru.truecasper.javascript.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.truecasper.javascript.models.Role;
import ru.truecasper.javascript.models.User;
import ru.truecasper.javascript.repositories.RoleRepository;
import ru.truecasper.javascript.repositories.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        user.getAuthorities().isEmpty();
        return user;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUser(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    public void updateUser(User user) {
        Objects.requireNonNull(userRepository.findById(user.getId()).orElse(null)).update(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
