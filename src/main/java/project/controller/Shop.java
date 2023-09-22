package project.controller;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.dto.UserDto;

@Table(name = "shops")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "address")
    private String address;

    UserDto
}
