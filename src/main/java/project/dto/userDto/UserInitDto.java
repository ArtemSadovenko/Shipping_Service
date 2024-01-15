package project.dto.userDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.enums.UserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInitDto {
    private Long id;

    private String firstName;

    private String lastName;

    private UserRole userRole;

    private String email;

    private String password;
}
