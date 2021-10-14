package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.UserAdminDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.repo.specification.UserSpecification;

import java.io.IOException;
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

    @Override
    public void saveUser(UserAdminDTO userAdminDTO) throws IOException {
        User user;
        if (userAdminDTO.getId() != null) user = userRepository.findById(userAdminDTO.getId())
                .orElseThrow(NotFoundException::new);
        else user = new User();
        user.setId(userAdminDTO.getId());
        user.setLogin(userAdminDTO.getLogin());
        user.setPassword(userAdminDTO.getPassword());
        user.setRoles(userAdminDTO.getRoles());
        userRepository.save(user);
    }

}
