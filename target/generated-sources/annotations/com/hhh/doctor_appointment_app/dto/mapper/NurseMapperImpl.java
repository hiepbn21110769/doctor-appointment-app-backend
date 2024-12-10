package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.NurseResponse.NurseResponse;
import com.hhh.doctor_appointment_app.entity.Nurse;
import com.hhh.doctor_appointment_app.entity.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T22:36:27+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class NurseMapperImpl implements NurseMapper {

    @Override
    public NurseResponse toResponse(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }

        NurseResponse.NurseResponseBuilder nurseResponse = NurseResponse.builder();

        nurseResponse.firstName( nurseProfileFirstName( nurse ) );
        nurseResponse.lastName( nurseProfileLastName( nurse ) );
        nurseResponse.fullName( nurseProfileFullName( nurse ) );
        nurseResponse.gender( nurseProfileGender( nurse ) );
        nurseResponse.phone( nurseProfilePhone( nurse ) );
        nurseResponse.email( nurseProfileEmail( nurse ) );
        nurseResponse.dateOfBirth( nurseProfileDateOfBirth( nurse ) );
        nurseResponse.address( nurseProfileAddress( nurse ) );
        nurseResponse.avatarFilePath( nurseProfileAvatarFilePath( nurse ) );
        nurseResponse.id( nurse.getId() );

        return nurseResponse.build();
    }

    private String nurseProfileFirstName(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }
        User profile = nurse.getProfile();
        if ( profile == null ) {
            return null;
        }
        String firstName = profile.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String nurseProfileLastName(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }
        User profile = nurse.getProfile();
        if ( profile == null ) {
            return null;
        }
        String lastName = profile.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String nurseProfileFullName(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }
        User profile = nurse.getProfile();
        if ( profile == null ) {
            return null;
        }
        String fullName = profile.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private boolean nurseProfileGender(Nurse nurse) {
        if ( nurse == null ) {
            return false;
        }
        User profile = nurse.getProfile();
        if ( profile == null ) {
            return false;
        }
        boolean gender = profile.isGender();
        return gender;
    }

    private String nurseProfilePhone(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }
        User profile = nurse.getProfile();
        if ( profile == null ) {
            return null;
        }
        String phone = profile.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    private String nurseProfileEmail(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }
        User profile = nurse.getProfile();
        if ( profile == null ) {
            return null;
        }
        String email = profile.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private Date nurseProfileDateOfBirth(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }
        User profile = nurse.getProfile();
        if ( profile == null ) {
            return null;
        }
        Date dateOfBirth = profile.getDateOfBirth();
        if ( dateOfBirth == null ) {
            return null;
        }
        return dateOfBirth;
    }

    private String nurseProfileAddress(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }
        User profile = nurse.getProfile();
        if ( profile == null ) {
            return null;
        }
        String address = profile.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private String nurseProfileAvatarFilePath(Nurse nurse) {
        if ( nurse == null ) {
            return null;
        }
        User profile = nurse.getProfile();
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
