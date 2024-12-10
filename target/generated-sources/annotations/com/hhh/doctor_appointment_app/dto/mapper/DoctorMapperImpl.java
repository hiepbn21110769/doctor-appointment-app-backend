package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorBookingResponse;
import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorChatResponse;
import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorResponse;
import com.hhh.doctor_appointment_app.entity.Doctor;
import com.hhh.doctor_appointment_app.entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T22:36:27+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorResponse toResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorResponse.DoctorResponseBuilder doctorResponse = DoctorResponse.builder();

        doctorResponse.firstName( doctorProfileFirstName( doctor ) );
        doctorResponse.lastName( doctorProfileLastName( doctor ) );
        doctorResponse.fullName( doctorProfileFullName( doctor ) );
        doctorResponse.gender( doctorProfileGender( doctor ) );
        doctorResponse.phone( doctorProfilePhone( doctor ) );
        doctorResponse.email( doctorProfileEmail( doctor ) );
        doctorResponse.dateOfBirth( doctorProfileDateOfBirth( doctor ) );
        doctorResponse.address( doctorProfileAddress( doctor ) );
        doctorResponse.specialty( doctor.getSpecialty() );
        doctorResponse.avatarFilePath( doctorProfileAvatarFilePath( doctor ) );
        doctorResponse.id( doctor.getId() );
        doctorResponse.averageRating( doctor.getAverageRating() );

        return doctorResponse.build();
    }

    @Override
    public DoctorBookingResponse toBookingResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorBookingResponse.DoctorBookingResponseBuilder doctorBookingResponse = DoctorBookingResponse.builder();

        doctorBookingResponse.firstName( doctorProfileFirstName( doctor ) );
        doctorBookingResponse.lastName( doctorProfileLastName( doctor ) );
        doctorBookingResponse.fullName( doctorProfileFullName( doctor ) );
        doctorBookingResponse.id( doctor.getId() );
        doctorBookingResponse.schedule( doctor.getSchedule() );
        doctorBookingResponse.specialty( doctor.getSpecialty() );
        doctorBookingResponse.averageRating( doctor.getAverageRating() );

        return doctorBookingResponse.build();
    }

    @Override
    public List<DoctorBookingResponse> toListDoctorBookingResponse(List<Doctor> doctors) {
        if ( doctors == null ) {
            return null;
        }

        List<DoctorBookingResponse> list = new ArrayList<DoctorBookingResponse>( doctors.size() );
        for ( Doctor doctor : doctors ) {
            list.add( toBookingResponse( doctor ) );
        }

        return list;
    }

    @Override
    public DoctorChatResponse toChatResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorChatResponse.DoctorChatResponseBuilder doctorChatResponse = DoctorChatResponse.builder();

        doctorChatResponse.fullName( doctorProfileFullName( doctor ) );
        doctorChatResponse.avatarFilePath( doctorProfileAvatarFilePath( doctor ) );
        doctorChatResponse.email( doctorProfileEmail( doctor ) );
        doctorChatResponse.id( doctor.getId() );
        doctorChatResponse.specialty( doctor.getSpecialty() );

        return doctorChatResponse.build();
    }

    @Override
    public List<DoctorChatResponse> toListDoctorChatResponse(List<Doctor> doctors) {
        if ( doctors == null ) {
            return null;
        }

        List<DoctorChatResponse> list = new ArrayList<DoctorChatResponse>( doctors.size() );
        for ( Doctor doctor : doctors ) {
            list.add( toChatResponse( doctor ) );
        }

        return list;
    }

    private String doctorProfileFirstName(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        String firstName = profile.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String doctorProfileLastName(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        String lastName = profile.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String doctorProfileFullName(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        String fullName = profile.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private boolean doctorProfileGender(Doctor doctor) {
        if ( doctor == null ) {
            return false;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return false;
        }
        boolean gender = profile.isGender();
        return gender;
    }

    private String doctorProfilePhone(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        String phone = profile.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    private String doctorProfileEmail(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        String email = profile.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private Date doctorProfileDateOfBirth(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        Date dateOfBirth = profile.getDateOfBirth();
        if ( dateOfBirth == null ) {
            return null;
        }
        return dateOfBirth;
    }

    private String doctorProfileAddress(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        String address = profile.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private String doctorProfileAvatarFilePath(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }
        User profile = doctor.getProfile();
        if ( profile == null ) {
            return null;
        }
        String avatarFilePath = profile.getAvatarFilePath();
        if ( avatarFilePath == null ) {
            return null;
        }
        return avatarFilePath;
    }
}
