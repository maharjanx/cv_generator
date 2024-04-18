package com.infodev.cvgenerator.user.userLogin;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_login_seq_gen")
    @SequenceGenerator(name = "user_login_seq_gen", sequenceName = "seq_user_login")
    private Short id;

    private String email;

    private String password;

    private String hashedPassword;
}
