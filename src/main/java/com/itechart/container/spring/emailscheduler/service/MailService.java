package com.itechart.container.spring.emailscheduler.service;

import com.itechart.container.spring.emailscheduler.generated.model.Email;

public interface MailService {

    void sendEmail(Email email);

}
