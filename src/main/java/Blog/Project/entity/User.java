package Blog.Project.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    private Integer id;

    @Email(message = ("Email address is not valid"))
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty
    @Column(name = "password")
    @Size(min = 3 ,max = 20,message = "password must be minimum 3 char and max 20 char  ")
    private String password;

    @NotEmpty
    @Column(name = "about")
    private String about;

    @NotEmpty
    @Size(min=4,message="User name must be greater then 4 character  ")
    @Column(name = "name")
    private String name;

}
























