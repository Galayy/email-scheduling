package com.itechart.container.spring.emailscheduler.mapper;

import com.itechart.container.spring.emailscheduler.entity.EmailEntity;
import com.itechart.container.spring.emailscheduler.generated.model.Email;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmailMapper {

    EmailMapper EMAIL_MAPPER = Mappers.getMapper(EmailMapper.class);

    Email toModel(EmailEntity entity);

    EmailEntity toEntity(Email model);

}
