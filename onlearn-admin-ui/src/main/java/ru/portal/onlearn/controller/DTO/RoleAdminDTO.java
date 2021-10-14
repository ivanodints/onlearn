package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.portal.onlearn.model.Role;
import ru.portal.onlearn.model.User;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleAdminDTO {

    private Long id;

    private String title;

    private Set<User> users;

    public RoleAdminDTO(@NotEmpty String title, Set<User> users) {
        this.title = title;
        this.users = users;
    }

    public RoleAdminDTO(Role role) {
        this.id = role.getId();
        this.title = role.getTitle();
        this.users = role.getUsers();
    }
}
