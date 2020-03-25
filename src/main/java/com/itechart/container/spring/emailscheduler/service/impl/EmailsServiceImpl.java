package com.itechart.container.spring.emailscheduler.service.impl;

import com.itechart.container.spring.emailscheduler.entity.EmailEntity;
import com.itechart.container.spring.emailscheduler.exception.EntityNotFoundException;
import com.itechart.container.spring.emailscheduler.generated.model.Email;
import com.itechart.container.spring.emailscheduler.generated.model.EmailRequest;
import com.itechart.container.spring.emailscheduler.repository.EmailsRepository;
import com.itechart.container.spring.emailscheduler.service.EmailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.itechart.container.spring.emailscheduler.mapper.EmailMapper.EMAIL_MAPPER;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailsServiceImpl implements EmailsService {

    private final EmailsRepository emailsRepository;

    @Override
    @Transactional
    public void synchronize(final Email email) {
        emailsRepository.saveAndFlush(EMAIL_MAPPER.toEntity(email));
        log.info("Mail was sent at {}", email.getLastSentAt());
    }

    @Override
    @Transactional
    public void deleteById(final UUID id) {
        emailsRepository.deleteById(id);
        log.info("Email with id {} was successfully deleted", id);
    }

    @Override
    @Transactional(readOnly = true)
    public Email getById(final UUID id) {
        return emailsRepository.findById(id).map(EMAIL_MAPPER::toModel)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no email with id %s", id)));
    }

    @Override
    @Transactional
    public Email updateById(UUID id, EmailRequest emailRequest) {
        var email = emailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("There is no email with id %s", id)));
        email.setEmailAddress(emailRequest.getEmailAddress());
        return EMAIL_MAPPER.toModel(emailsRepository.saveAndFlush(email));
    }

    @Override
    @Transactional
    public Email create(final EmailRequest emailRequest) {
        var email = new EmailEntity();
        email.setEmailAddress(emailRequest.getEmailAddress());
        return EMAIL_MAPPER.toModel(emailsRepository.saveAndFlush(email));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Email> getAll() {
        return emailsRepository.findAll().stream().map(EMAIL_MAPPER::toModel).collect(toList());
    }

}
