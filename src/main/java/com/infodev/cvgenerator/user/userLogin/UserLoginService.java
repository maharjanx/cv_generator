package com.infodev.cvgenerator.user.userLogin;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService {
    private final UserLoginRepository userLoginRepository;
    private final UserLoginEntityDtoConverter userLoginEntityDtoConverter;

    public UserLoginService(UserLoginRepository userLoginRepository, UserLoginEntityDtoConverter userLoginEntityDtoConverter) {
        this.userLoginRepository = userLoginRepository;
        this.userLoginEntityDtoConverter = userLoginEntityDtoConverter;
    }

    List<UserLoginDto> getUsers(){
        return userLoginEntityDtoConverter.toDto(userLoginRepository.findAll());
    }
}
