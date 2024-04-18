package com.infodev.cvgenerator.user.userLogin;

import com.infodev.cvgenerator.user.abstracts.AbstractConverter;
import com.infodev.cvgenerator.user.dto.AddressInformationRequestDto;
import com.infodev.cvgenerator.user.entity.AddressInformation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserLoginEntityDtoConverter extends AbstractConverter<UserLoginDto, UserLogin> {

    @Override
    public UserLogin toEntity(UserLoginDto dto){
        return UserLogin.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    @Override
    public UserLoginDto toDto(UserLogin entity) {
        return UserLoginDto.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public List<UserLoginDto> toDto(List<UserLogin> entityList){
        if (entityList.isEmpty()){
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
