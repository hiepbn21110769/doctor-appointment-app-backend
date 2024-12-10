package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.AppointmentResponse.AppointmentBookedResponse;
import com.hhh.doctor_appointment_app.dto.response.AppointmentResponse.AppointmentDetailResponse;
import com.hhh.doctor_appointment_app.dto.response.AppointmentResponse.AppointmentResponse;
import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorResponse;
import com.hhh.doctor_appointment_app.dto.response.MedicalRecordResponse.MedicalRecordResponse;
import com.hhh.doctor_appointment_app.dto.response.NotificationResponse.BookingNotificationResponse;
import com.hhh.doctor_appointment_app.entity.Appointment;
import com.hhh.doctor_appointment_app.entity.Doctor;
import com.hhh.doctor_appointment_app.entity.MedicalRecord;
import com.hhh.doctor_appointment_app.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T22:36:27+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentResponse toResponse(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentResponse appointmentResponse = new AppointmentResponse();

        appointmentResponse.setDoctor( userToDoctorResponse( appointmentDoctorProfile( appointment ) ) );
        appointmentResponse.setId( appointment.getId() );
        appointmentResponse.setFullName( appointment.getFullName() );
        appointmentResponse.setPhone( appointment.getPhone() );
        appointmentResponse.setEmail( appointment.getEmail() );
        appointmentResponse.setReason( appointment.getReason() );
        appointmentResponse.setDateBooking( appointment.getDateBooking() );
        appointmentResponse.setBookingHour( appointment.getBookingHour() );
        appointmentResponse.setCusType( appointment.getCusType() );
        appointmentResponse.setAppointmentStatus( appointment.getAppointmentStatus() );

        return appointmentResponse;
    }

    @Override
    public AppointmentDetailResponse toAppointmentDetailResponse(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentDetailResponse appointmentDetailResponse = new AppointmentDetailResponse();

        appointmentDetailResponse.setDoctor( userToDoctorResponse( appointmentDoctorProfile( appointment ) ) );
        appointmentDetailResponse.setId( appointment.getId() );
        appointmentDetailResponse.setFullName( appointment.getFullName() );
        appointmentDetailResponse.setPhone( appointment.getPhone() );
        appointmentDetailResponse.setEmail( appointment.getEmail() );
        appointmentDetailResponse.setReason( appointment.getReason() );
        appointmentDetailResponse.setDateBooking( appointment.getDateBooking() );
        appointmentDetailResponse.setBookingHour( appointment.getBookingHour() );
        appointmentDetailResponse.setCusType( appointment.getCusType() );
        appointmentDetailResponse.setAppointmentStatus( appointment.getAppointmentStatus() );

        return appointmentDetailResponse;
    }

    @Override
    public AppointmentBookedResponse toBookedResponse(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentBookedResponse.AppointmentBookedResponseBuilder appointmentBookedResponse = AppointmentBookedResponse.builder();

        appointmentBookedResponse.doctor( appointment.getDoctor() );
        appointmentBookedResponse.id( appointment.getId() );
        appointmentBookedResponse.dateBooking( appointment.getDateBooking() );
        appointmentBookedResponse.bookingHour( appointment.getBookingHour() );
        appointmentBookedResponse.patient( appointment.getPatient() );

        return appointmentBookedResponse.build();
    }

    @Override
    public List<MedicalRecordResponse> toMedicalRecordResponse(List<MedicalRecord> medicalRecordList) {
        if ( medicalRecordList == null ) {
            return null;
        }

        List<MedicalRecordResponse> list = new ArrayList<MedicalRecordResponse>( medicalRecordList.size() );
        for ( MedicalRecord medicalRecord : medicalRecordList ) {
            list.add( medicalRecordToMedicalRecordResponse( medicalRecord ) );
        }

        return list;
    }

    @Override
    public List<AppointmentBookedResponse> toBookedResponses(List<Appointment> appointments) {
        if ( appointments == null ) {
            return null;
        }

        List<AppointmentBookedResponse> list = new ArrayList<AppointmentBookedResponse>( appointments.size() );
        for ( Appointment appointment : appointments ) {
            list.add( toBookedResponse( appointment ) );
        }

        return list;
    }

    @Override
    public List<AppointmentResponse> toResponses(List<Appointment> appointments) {
        if ( appointments == null ) {
            return null;
        }

        List<AppointmentResponse> list = new ArrayList<AppointmentResponse>( appointments.size() );
        for ( Appointment appointment : appointments ) {
            list.add( toResponse( appointment ) );
        }

        return list;
    }

    @Override
    public BookingNotificationResponse toBookingNotificationResponse(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        BookingNotificationResponse.BookingNotificationResponseBuilder bookingNotificationResponse = BookingNotificationResponse.builder();

        bookingNotificationResponse.appointmentId( appointment.getId() );
        bookingNotificationResponse.doctor( appointment.getDoctor() );
        bookingNotificationResponse.dateBooking( appointment.getDateBooking() );
        bookingNotificationResponse.bookingHour( appointment.getBookingHour() );

        return bookingNotificationResponse.build();
    }

    private User appointmentDoctorProfile(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        Doctor doctor = appointment.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        return profile;
    }

    protected DoctorResponse userToDoctorResponse(User user) {
        if ( user == null ) {
            return null;
        }

        DoctorResponse.DoctorResponseBuilder doctorResponse = DoctorResponse.builder();

        doctorResponse.id( user.getId() );
        doctorResponse.firstName( user.getFirstName() );
        doctorResponse.lastName( user.getLastName() );
        doctorResponse.fullName( user.getFullName() );
        doctorResponse.gender( user.isGender() );
        doctorResponse.phone( user.getPhone() );
        doctorResponse.email( user.getEmail() );
        doctorResponse.dateOfBirth( user.getDateOfBirth() );
        doctorResponse.address( user.getAddress() );
        doctorResponse.avatarFilePath( user.getAvatarFilePath() );

        return doctorResponse.build();
    }

    protected MedicalRecordResponse medicalRecordToMedicalRecordResponse(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }

        MedicalRecordResponse.MedicalRecordResponseBuilder medicalRecordResponse = MedicalRecordResponse.builder();

        medicalRecordResponse.id( medicalRecord.getId() );
        medicalRecordResponse.bloodType( medicalRecord.getBloodType() );
        medicalRecordResponse.heartRate( medicalRecord.getHeartRate() );
        medicalRecordResponse.temperature( medicalRecord.getTemperature() );
        medicalRecordResponse.weight( medicalRecord.getWeight() );
        medicalRecordResponse.height( medicalRecord.getHeight() );
        medicalRecordResponse.description( medicalRecord.getDescription() );
        medicalRecordResponse.allergies( medicalRecord.getAllergies() );
        medicalRecordResponse.diagnosis( medicalRecord.getDiagnosis() );
        medicalRecordResponse.prescription( medicalRecord.getPrescription() );
        medicalRecordResponse.treatmentPlan( medicalRecord.getTreatmentPlan() );
        medicalRecordResponse.note( medicalRecord.getNote() );
        medicalRecordResponse.filePath( medicalRecord.getFilePath() );
        medicalRecordResponse.dateCreated( medicalRecord.getDateCreated() );
        medicalRecordResponse.lastModified( medicalRecord.getLastModified() );

        return medicalRecordResponse.build();
    }
}
