package ru.portal.onlearn.service;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.UserDTO;
import ru.portal.onlearn.error.NotFoundException;
import ru.portal.onlearn.model.User;
import ru.portal.onlearn.repo.UserRepository;
import ru.portal.onlearn.service.model.UserService;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<UserDTO> findUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> UserService.mapToUserDTO(user));
    }

    @Override
    public void saveUser(UserDTO userDTO) throws IOException {
        User user;
        if (userDTO.getId() != null) user = userRepository.findById(userDTO.getId())
                .orElseThrow(NotFoundException::new);
        else user = new User();
        user.setId(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setRoles(userDTO.getRoles());
        userRepository.save(user);
    }
}
