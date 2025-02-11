package com.hhh.doctor_appointment_app.dto.request.NurseRequest;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class UpdateNurseProfileRequest {
    @Size(max = 50, message = "Firstname must not exceed 50 characters")
    private String firstName;

    @Size(max = 50, message = "Lastname must not exceed 50 characters")
    private String lastName;

    private boolean gender;

    private String phone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // Định dạng ngày yyyy-MM-dd
    private Date dateOfBirth;

    private String address;

    private String avatarFilePath;
}
