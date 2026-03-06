package com.jetacademy.otp.controller;

import com.jetacademy.otp.dto.OtpRequest;
import com.jetacademy.otp.dto.VerifyRequest;
import com.jetacademy.otp.service.CodeSender;
import com.jetacademy.otp.service.Verification;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/otp")
@RequiredArgsConstructor
public class OtpController {

    private final CodeSender codeSender;
    private final Verification verification;

    @PostMapping("/requestcode")
    public String requestOtpCode(@RequestBody OtpRequest dto){
        return codeSender.sendOtpCode(dto);
    }

    @PostMapping("/verifynumber")
    public String verifyPhoneNumber(@RequestBody VerifyRequest dto){
        return verification.verify(dto);
    }
}
