package project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.Hibernate;
import project.enums.UserRole;

import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role", columnDefinition = "ENUM('CUSTOMER', 'SHOP_OWNER', 'COURIER')")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
