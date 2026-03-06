package com.jetacademy.otp.dao.repository;

import com.jetacademy.otp.dao.entity.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository <OtpEntity,Long> {

    Optional<OtpEntity> findByPhoneNumber(String phoneNumber);

    void deleteByExpiresAtBefore(LocalDateTime time);
}
