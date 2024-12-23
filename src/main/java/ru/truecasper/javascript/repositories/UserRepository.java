package ru.truecasper.javascript.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.truecasper.javascript.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
