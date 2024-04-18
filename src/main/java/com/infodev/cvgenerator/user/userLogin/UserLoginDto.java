package com.infodev.cvgenerator.user.userLogin;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDto {
    private String email;
    private String password;
}
