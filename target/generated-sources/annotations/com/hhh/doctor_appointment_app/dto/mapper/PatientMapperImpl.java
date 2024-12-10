package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.PatientResponse.PatientChatResponse;
import com.hhh.doctor_appointment_app.dto.response.PatientResponse.PatientResponse;
import com.hhh.doctor_appointment_app.entity.Patient;
import com.hhh.doctor_appointment_app.entity.Role;
import com.hhh.doctor_appointment_app.entity.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T22:36:28+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientResponse toResponse(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientResponse.PatientResponseBuilder patientResponse = PatientResponse.builder();

        patientResponse.firstName( patientProfileFirstName( patient ) );
        patientResponse.lastName( patientProfileLastName( patient ) );
        patientResponse.gender( patientProfileGender( patient ) );
        patientResponse.phone( patientProfilePhone( patient ) );
        patientResponse.email( patientProfileEmail( patient ) );
        patientResponse.dateOfBirth( patientProfileDateOfBirth( patient ) );
        patientResponse.address( patientProfileAddress( patient ) );
        patientResponse.avatarFilePath( patientProfileAvatarFilePath( patient ) );
        patientResponse.role( patientProfileRole( patient ) );
        patientResponse.fullName( patientProfileFullName( patient ) );
        patientResponse.id( patient.getId() );

        return patientResponse.build();
    }

    @Override
    public PatientChatResponse toChatResponse(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientChatResponse.PatientChatResponseBuilder patientChatResponse = PatientChatResponse.builder();

        patientChatResponse.fullName( patientProfileFullName( patient ) );
        patientChatResponse.email( patientProfileEmail( patient ) );
        patientChatResponse.avatarFilePath( patientProfileAvatarFilePath( patient ) );
        patientChatResponse.id( patient.getId() );

        return patientChatResponse.build();
    }

    private String patientProfileFirstName(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        String firstName = profile.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String patientProfileLastName(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        String lastName = profile.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private boolean patientProfileGender(Patient patient) {
        if ( patient == null ) {
            return false;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return false;
        }
        boolean gender = profile.isGender();
        return gender;
    }

    private String patientProfilePhone(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        String phone = profile.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    private String patientProfileEmail(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        String email = profile.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private Date patientProfileDateOfBirth(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        Date dateOfBirth = profile.getDateOfBirth();
        if ( dateOfBirth == null ) {
            return null;
        }
        return dateOfBirth;
    }

    private String patientProfileAddress(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        String address = profile.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private String patientProfileAvatarFilePath(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        String avatarFilePath = profile.getAvatarFilePath();
        if ( avatarFilePath == null ) {
            return null;
        }
        return avatarFilePath;
    }

    private Role patientProfileRole(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        Role role = profile.getRole();
        if ( role == null ) {
            return null;
        }
        return role;
    }

    private String patientProfileFullName(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User profile = patient.getProfile();
        if ( profile == null ) {
            return null;
        }
        String fullName = profile.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }
}
