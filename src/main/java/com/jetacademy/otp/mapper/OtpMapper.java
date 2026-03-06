package com.jetacademy.otp.mapper;

import com.jetacademy.otp.dao.entity.OtpEntity;
import com.jetacademy.otp.dto.OtpRequest;
import com.jetacademy.otp.dto.VerifyRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OtpMapper {

    OtpRequest OtpRequestToDto (OtpEntity entity);
    VerifyRequest VerifyRequestToDto (OtpEntity entity);
    OtpEntity OtpEntityToEntity(OtpRequest dto);
    OtpEntity VerifyRequestToEntity(VerifyRequest dto);
}
