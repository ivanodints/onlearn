package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.UserAdminDTO;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.repo.specification.UserSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAdminServiceImpl implements UserAdminService{

    private final UserRepository userRepository;

    public UserAdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserAdminDTO> findUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> UserAdminService.mapToAdminUserDTO(user));
    }

    @Override
    public List<UserAdminDTO> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserAdminDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<UserAdminDTO> findByFilter(String login, Integer page, Integer size){
        Specification<User> spec = Specification.where(null);
        if (login != null){
            spec = spec.and(UserSpecification.byLogin(login));
        }

        Page<Long> ids = userRepository.findAll(PageRequest.of(page - 1, size))
                .map(User::getId);

        List<UserAdminDTO> allByIds = userRepository.findAll().stream()
                .map(user -> UserAdminService.mapToAdminUserDTO(user))
                .collect(Collectors.toList());
        return new PageImpl<>(allByIds, PageRequest.of(page -1, size), ids.getTotalElements());
    }
}
