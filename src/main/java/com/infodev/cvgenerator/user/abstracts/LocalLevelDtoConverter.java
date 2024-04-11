package com.infodev.cvgenerator.user.abstracts;

import com.infodev.cvgenerator.user.dto.LocalLevelDto;
import com.infodev.cvgenerator.user.entity.LocalLevel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalLevelDtoConverter extends AbstractConverter<LocalLevelDto, LocalLevel>{
    @Autowired
    private ModelMapper modelMapper;

    public LocalLevel toEntity(LocalLevelDto dto){
        return super.toEntity(dto);
    }

    public LocalLevelDto toDto(LocalLevel entity){
        return modelMapper.map(entity, LocalLevelDto.class);
    }

    public List<LocalLevelDto> toDto(List<LocalLevel> entityList){
        if (entityList.isEmpty()){
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
