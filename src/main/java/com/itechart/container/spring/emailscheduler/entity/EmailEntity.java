package com.itechart.container.spring.emailscheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emails")
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    protected UUID id;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "last_sent_at")
    private Instant lastSentAt;

}
