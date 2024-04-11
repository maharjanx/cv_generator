package com.infodev.cvgenerator.user.service.impl;

import com.infodev.cvgenerator.user.abstracts.LocalLevelDtoConverter;
import com.infodev.cvgenerator.user.dto.LocalLevelDto;
import com.infodev.cvgenerator.user.entity.LocalLevel;
import com.infodev.cvgenerator.user.repository.LocalLevelRepository;
import com.infodev.cvgenerator.user.service.LocalLevelService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LocalLevelServiceImpl implements LocalLevelService
{
    private final LocalLevelRepository localLevelRepository;
    private final LocalLevelDtoConverter localLevelDtoConverter;

    public LocalLevelServiceImpl(LocalLevelRepository localLevelRepository, LocalLevelDtoConverter localLevelDtoConverter) {
        this.localLevelRepository = localLevelRepository;
        this.localLevelDtoConverter = localLevelDtoConverter;
    }

    @Override
    public List<LocalLevelDto> getAllLocalLevels() {
        return localLevelDtoConverter.toDto(localLevelRepository.findAll());
    }


}
