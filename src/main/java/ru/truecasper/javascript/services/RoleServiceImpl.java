package ru.truecasper.javascript.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.truecasper.javascript.models.Role;
import ru.truecasper.javascript.repositories.RoleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(String id) {
        return roleRepository.findById(Integer.parseInt(id)).orElse(null);
    }
}
