package com.jetacademy.otp.service;

import com.jetacademy.otp.dao.entity.OtpEntity;
import com.jetacademy.otp.dao.repository.OtpRepository;
import com.jetacademy.otp.dto.OtpRequest;
import com.jetacademy.otp.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CodeSender {

    private final OtpRepository otpRepository;

    public String sendOtpCode(OtpRequest dto) {
        Integer generatedCode = 1000 + new Random().nextInt(9000);

        OtpEntity entity = new OtpEntity();
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setOtpCode(generatedCode);
        Integer currentCount = entity.getSmsCount();
        if (currentCount == null) {
            currentCount = 0;
        }
            entity.setSmsCount(currentCount + 1);
            entity.setStatus(Status.PENDING);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setExpiresAt(LocalDateTime.now().plusMinutes(1));

            otpRepository.save(entity);
            return "SMS gönderildi";
        }
    }
