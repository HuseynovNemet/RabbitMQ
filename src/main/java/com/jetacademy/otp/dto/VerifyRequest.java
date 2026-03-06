package com.jetacademy.otp.dto;

import lombok.Data;

@Data
public class VerifyRequest {
    String phoneNumber;
    Integer otpCode;
}
