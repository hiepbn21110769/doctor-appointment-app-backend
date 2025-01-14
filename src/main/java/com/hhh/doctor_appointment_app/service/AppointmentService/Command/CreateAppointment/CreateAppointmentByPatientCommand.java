package com.hhh.doctor_appointment_app.service.AppointmentService.Command.CreateAppointment;

import com.hhh.doctor_appointment_app.dto.mapper.AppointmentMapper;
import com.hhh.doctor_appointment_app.dto.request.AppointmentRequest.AppointmentByPatientRequest;
import com.hhh.doctor_appointment_app.dto.response.ApiResponse;
import com.hhh.doctor_appointment_app.dto.response.AppointmentResponse.AppointmentResponse;
import com.hhh.doctor_appointment_app.entity.Appointment;
import com.hhh.doctor_appointment_app.entity.Doctor;
import com.hhh.doctor_appointment_app.entity.Patient;
import com.hhh.doctor_appointment_app.entity.User;
import com.hhh.doctor_appointment_app.enums.AppointmentStatus;
import com.hhh.doctor_appointment_app.exception.NotFoundException;
import com.hhh.doctor_appointment_app.repository.AppointmentRepository;
import com.hhh.doctor_appointment_app.repository.DoctorRepository;
import com.hhh.doctor_appointment_app.repository.PatientRepository;
import com.hhh.doctor_appointment_app.service.EmailService.Command.SendAppointmentNotification.SendAppointmentNotificationCommand;
import com.hhh.doctor_appointment_app.service.NotificationService.Implement.BookingNotificationService;
import com.hhh.doctor_appointment_app.service.UserService.Query.FindUserByEmail.FindUserByEmailQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Service
public class CreateAppointmentByPatientCommand {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private FindUserByEmailQuery findUserByEmailQuery;

    @Autowired
    private BookingNotificationService bookingNotificationService;

    @Autowired
    private SendAppointmentNotificationCommand sendAppointmentNotificationCommand;

    public ApiResponse<Object> createAppointmentByPatient(AppointmentByPatientRequest appointmentByPatientRequest) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        try {
            var context = SecurityContextHolder.getContext();
            String username = context.getAuthentication().getName();
            User user = findUserByEmailQuery.findUserByEmail(username)
                    .orElseThrow(() -> new NotFoundException("User not found"));

            Patient patient = patientRepository.findPatientByProfile_Email(user.getEmail())
                    .orElseThrow(() -> new NotFoundException("Patient Not Found"));

            Doctor doctor = doctorRepository.findById(appointmentByPatientRequest.getDoctorId())
                    .orElseThrow(() -> new NotFoundException("Doctor Not Found"));

            // Convert the dateBooking from Date to LocalDateTime
            LocalDateTime dateBooking = appointmentByPatientRequest.getDateBooking()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            // Get the current date and time
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Check if the dateBooking is after the current date and time
            if (dateBooking.isBefore(currentDateTime)) {
                return ApiResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message("The booking date and time must be in the future.")
                        .build();
            }

            // Generate reference code for the new appointment
            String referenceCode = UUID.randomUUID().toString();

            Appointment appointment = Appointment.builder()
                    .fullName(patient.getProfile().getFullName())
                    .phone(patient.getProfile().getPhone())
                    .email(patient.getProfile().getEmail())
                    .dateBooking(appointmentByPatientRequest.getDateBooking())
                    .bookingHour(appointmentByPatientRequest.getBookingHour())
                    .reason(appointmentByPatientRequest.getReason())
                    .patient(patient)
                    .cusType("PATIENT")
                    .doctor(doctor)
                    .appointmentStatus(AppointmentStatus.PENDING)
                    .referenceCode(referenceCode)
                    .build();


            appointmentRepository.saveAndFlush(appointment);
            AppointmentResponse appointmentResponse = appointmentMapper.toResponse(appointment);

            bookingNotificationService.sendBookingMessage(
                    appointmentMapper.toBookingNotificationResponse(appointment)
            );

            sendAppointmentNotificationCommand.sendAppointmentNotification(
                    appointment.getEmail(),
                    appointment.getFullName(),
                    appointment.getPhone(),
                    appointment.getAppointmentStatus().toString(),
                    appointment.getReferenceCode(),
                    appointment.getDateBooking().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                    appointment.getBookingHour(),
                    appointment.getDoctor().getProfile().getFullName()
            );
            apiResponse.setMessage("Appointment Created Successfully !");
            apiResponse.ok(appointmentResponse);
            return apiResponse;


        } catch (NotFoundException ex) {
            return ApiResponse.builder()
                    .statusCode(HttpStatus.NOT_FOUND.value())
                    .message(ex.getMessage())
                    .build();
        } catch (Exception ex) {
            return ApiResponse.builder()
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(ex.getMessage())
                    .build();
        }
    }


}
