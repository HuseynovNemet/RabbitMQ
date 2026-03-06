package com.jetacademy.otp.service;

import com.jetacademy.otp.dao.entity.OtpEntity;
import com.jetacademy.otp.dao.repository.OtpRepository;
import com.jetacademy.otp.dto.VerifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Verification {

    private final OtpRepository otpRepository;

    public String verify(VerifyRequest dto) {
        OtpEntity entity = otpRepository.findByPhoneNumber(dto.getPhoneNumber())
                .orElseThrow(() -> new RuntimeException("Kod kecersizdir"));

        if (entity.getOtpCode().equals(dto.getOtpCode())) {
            // Təsdiqlə...
            return "Uğurlu!";
        }
        return "Yanlış kod!";
    }

}
