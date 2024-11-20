package ru.truecasper.javascript.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.truecasper.javascript.dto.UserDTO;
import ru.truecasper.javascript.models.Role;
import ru.truecasper.javascript.models.User;
import ru.truecasper.javascript.services.RoleService;
import ru.truecasper.javascript.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;
    private final RoleService roleService;

    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getUsers().stream().map(UserDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody /**@Valid*/ User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserDTO(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody /**@Valid*/ User user) {
        System.out.println(user);
        user.setId(id);
        userService.updateUser(user);
        return ResponseEntity.ok(new UserDTO(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(new UserDTO(userService.getUser(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/new")
    public ResponseEntity<UserDTO> newUser() {
        return ResponseEntity.ok(new UserDTO());
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleService.findAll();
    }
}