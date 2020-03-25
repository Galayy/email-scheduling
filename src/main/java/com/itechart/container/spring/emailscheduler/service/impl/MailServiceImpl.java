package com.itechart.container.spring.emailscheduler.service.impl;

import com.itechart.container.spring.emailscheduler.generated.model.Email;
import com.itechart.container.spring.emailscheduler.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.Instant;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private static final String TEMPLATE = "report-template";
    private static final String THEME = "Simple mail";

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Override
    @SneakyThrows
    public void sendEmail(final Email email) {
        var context = new Context();
        context.setVariable("date", Instant.now());

        var html = templateEngine.process(TEMPLATE, context);
        var message = mailSender.createMimeMessage();

        var helper = new MimeMessageHelper(message, MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        helper.setTo(email.getEmailAddress());
        helper.setText(html, true);
        helper.setSubject(THEME);

        mailSender.send(message);
        log.info("Mail was successfully sent to {}", email.getEmailAddress());
    }

}
