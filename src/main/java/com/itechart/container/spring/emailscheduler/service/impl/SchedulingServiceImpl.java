package com.itechart.container.spring.emailscheduler.service.impl;

import com.itechart.container.spring.emailscheduler.service.EmailsService;
import com.itechart.container.spring.emailscheduler.service.MailService;
import com.itechart.container.spring.emailscheduler.service.SchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SchedulingServiceImpl implements SchedulingService {

    private final EmailsService emailsService;
    private final MailService mailService;

    @Override
    @Scheduled(fixedRate = 15 * 60 * 1000)
    public void performMailing() {
        var emails = emailsService.getAll();
        emails.forEach(email -> {
            mailService.sendEmail(email);
            email.setLastSentAt(Instant.now());
            emailsService.synchronize(email);
        });
    }

}
