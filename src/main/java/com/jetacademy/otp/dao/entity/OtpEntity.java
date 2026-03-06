package com.jetacademy.otp.dao.entity;

import com.jetacademy.otp.util.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "otp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String phoneNumber;
    Status status;
    Integer otpCode;
    Integer smsCount;
    LocalDateTime createdAt;
    LocalDateTime expiresAt;
}
