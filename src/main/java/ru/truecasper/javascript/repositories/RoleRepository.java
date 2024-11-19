package ru.truecasper.javascript.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.truecasper.javascript.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
//    Set<Role> findAllById(List<Integer> ids);
}
