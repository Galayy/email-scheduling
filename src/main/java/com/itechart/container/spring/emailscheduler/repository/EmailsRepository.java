package com.itechart.container.spring.emailscheduler.repository;

import com.itechart.container.spring.emailscheduler.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailsRepository extends JpaRepository<EmailEntity, UUID> {
}
