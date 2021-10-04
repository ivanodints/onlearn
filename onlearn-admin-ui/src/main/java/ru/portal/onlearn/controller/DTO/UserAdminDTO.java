package ru.portal.onlearn.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.portal.onlearn.model.Role;
import ru.portal.onlearn.model.User;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAdminDTO {

    private Long id;

    private String login;

    private String password;

    private Set<Role> roles;

    public UserAdminDTO(@NotEmpty String login, @NotEmpty Set<Role> roles) {
        this.login = login;
        this.roles = roles;
        this.password = password;
    }

    public UserAdminDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.roles = new HashSet<>(user.getRoles());
    }
    
    public String getRoleTitle (){
        return roles.stream().map(loginTitle -> loginTitle.getTitle()).collect(Collectors.joining(", "));
    }
}
