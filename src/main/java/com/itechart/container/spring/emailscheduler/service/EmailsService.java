package com.itechart.container.spring.emailscheduler.service;

import com.itechart.container.spring.emailscheduler.generated.model.Email;
import com.itechart.container.spring.emailscheduler.generated.model.EmailRequest;

import java.util.List;
import java.util.UUID;

public interface EmailsService {

    void synchronize(Email email);

    void deleteById(UUID id);

    Email getById(UUID id);

    Email updateById(UUID id, EmailRequest emailRequest);

    Email create(EmailRequest emailRequest);

    List<Email> getAll();

}
