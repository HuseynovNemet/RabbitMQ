package com.jetacademy.otp.service;

import com.jetacademy.otp.dao.repository.OtpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OtpCleanupService {

    private final OtpRepository otpRepository;

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void deleteExpiredOtp() {
        LocalDateTime now = LocalDateTime.now();
        otpRepository.deleteByExpiresAtBefore(now);
        System.out.println("Vaxtı keçmiş OTP-lər təmizləndi: " + now);
    }
}