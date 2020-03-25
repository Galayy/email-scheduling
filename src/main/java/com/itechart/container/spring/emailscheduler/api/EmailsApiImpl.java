package com.itechart.container.spring.emailscheduler.api;

import com.itechart.container.spring.emailscheduler.generated.api.EmailsApi;
import com.itechart.container.spring.emailscheduler.generated.model.Email;
import com.itechart.container.spring.emailscheduler.generated.model.EmailRequest;
import com.itechart.container.spring.emailscheduler.service.EmailsService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@Api(tags = "emails")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmailsApiImpl implements EmailsApi {

    private final EmailsService emailsService;

    @Override
    public ResponseEntity<Void> deleteById(@PathVariable final UUID id) {
        emailsService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }


    @Override
    public ResponseEntity<Email> getById(@PathVariable final UUID id) {
        var email = emailsService.getById(id);
        return new ResponseEntity<>(email, OK);
    }

    @Override
    public ResponseEntity<Email> updateById(@PathVariable final UUID id, @RequestBody final EmailRequest emailRequest) {
        var email = emailsService.updateById(id, emailRequest);
        return new ResponseEntity<>(email, OK);
    }

    @Override
    public ResponseEntity<List<Email>> getEmails() {
        var emails = emailsService.getAll();
        return new ResponseEntity<>(emails, OK);
    }


    @Override
    public ResponseEntity<Email> create(@Valid @RequestBody EmailRequest emailRequest) {
        var email = emailsService.create(emailRequest);
        return new ResponseEntity<>(email, CREATED);
    }

}
