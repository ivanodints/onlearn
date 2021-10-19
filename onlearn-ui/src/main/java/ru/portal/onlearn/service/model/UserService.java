package ru.portal.onlearn.service.model;

import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.UserDTO;
import ru.portal.onlearn.model.User;

import java.io.IOException;
import java.util.Optional;

@Service
public interface UserService {

    Optional<UserDTO> findUserById(Long id);

    Optional<UserDTO> findUserByLogin(String login);
//
//    Long findUserByName(String name);

    static UserDTO mapToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getRoles());
    }

    void saveUser (UserDTO userDTO) throws IOException;
}
