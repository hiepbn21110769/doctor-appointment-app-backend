package com.hhh.doctor_appointment_app.dto.response.AppointmentResponse;

import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorResponse;
import com.hhh.doctor_appointment_app.dto.response.MedicalRecordResponse.MedicalRecordResponse;
import com.hhh.doctor_appointment_app.dto.response.PatientResponse.PatientResponse;
import com.hhh.doctor_appointment_app.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentResponse {
    private Long id;

    private String fullName;

    private Long patientId;

    private Date patientBirthday;

    private String phone;

    private String email;

    private String reason;

    private Date dateBooking;

    private String bookingHour;

    private String cusType;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;

    private DoctorResponse doctor;

    private MedicalRecordResponse medicalRecordResponse;

    private String avatarFilePath;

    private PatientResponse patientResponse;

}
