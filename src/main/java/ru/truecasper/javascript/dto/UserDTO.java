package ru.truecasper.javascript.dto;

import org.springframework.stereotype.Component;
import ru.truecasper.javascript.models.Role;
import ru.truecasper.javascript.models.User;

import java.util.List;

@Component
public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String age;
    private List<Role> roles;

    public UserDTO() {}
    public UserDTO(int id, String name, String password, String surname, String age, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.roles = roles;
    }
    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.age = user.getAge();
        this.roles = user.getRoles();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", roles=" + roles +
                '}';
    }
}
