package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.RoleAdminDTO;
import ru.portal.onlearn.model.Role;
import ru.portal.onlearn.repo.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleAdminServiceImpl implements RoleAdminService {

    private final RoleRepository roleRepository;

    public RoleAdminServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleAdminDTO> showAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(RoleAdminDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleAdminDTO> findRoleById(Long id) {
        return roleRepository.findById(id)
                .map(RoleAdminDTO::new);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void save(RoleAdminDTO roleAdminDTO) {
        Role role = new Role();
        role.setId(roleAdminDTO.getId());
        role.setTitle(roleAdminDTO.getTitle());
        role.setUsers(roleAdminDTO.getUsers());
        roleRepository.save(role);
    }
}
