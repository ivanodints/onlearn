package ru.portal.onlearn.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.portal.onlearn.controller.DTO.UserAdminDTO;
import ru.portal.onlearn.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface UserAdminService {

    Optional<UserAdminDTO> findUserById(Long id);

    List<UserAdminDTO> findAllUser();

    void deleteUserById(Long id);

    Page<UserAdminDTO> findByFilter(String surname, Integer page, Integer size);

    static UserAdminDTO mapToAdminUserDTO(User user) {
        return new UserAdminDTO(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getRoles());
    }

    void saveUser (UserAdminDTO userAdminDTO) throws IOException;

}
