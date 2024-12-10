package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.request.UserRequest.UserCreateRequest;
import com.hhh.doctor_appointment_app.dto.request.UserRequest.UserSignupRequest;
import com.hhh.doctor_appointment_app.dto.response.UserResponse;
import com.hhh.doctor_appointment_app.entity.Admin;
import com.hhh.doctor_appointment_app.entity.Doctor;
import com.hhh.doctor_appointment_app.entity.Patient;
import com.hhh.doctor_appointment_app.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T22:36:27+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( request.getFirstName() );
        user.lastName( request.getLastName() );
        if ( request.getGender() != null ) {
            user.gender( request.getGender() );
        }
        user.phone( request.getPhone() );
        user.email( request.getEmail() );
        user.password( request.getPassword() );
        user.dateOfBirth( request.getDateOfBirth() );
        user.address( request.getAddress() );

        return user.build();
    }

    @Override
    public User toUser(UserSignupRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( request.getFirstName() );
        user.lastName( request.getLastName() );
        user.gender( request.isGender() );
        user.phone( request.getPhone() );
        user.email( request.getEmail() );
        user.password( request.getPassword() );

        return user.build();
    }

    @Override
    public Admin toAdmin(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Admin.AdminBuilder admin = Admin.builder();

        admin.profile( userCreateRequestToUser( request ) );

        return admin.build();
    }

    @Override
    public Patient toPatient(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Patient.PatientBuilder patient = Patient.builder();

        patient.profile( userCreateRequestToUser1( request ) );

        return patient.build();
    }

    @Override
    public Doctor toDoctor(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Doctor.DoctorBuilder doctor = Doctor.builder();

        doctor.profile( userCreateRequestToUser2( request ) );

        return doctor.build();
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.fullName( user.getFullName() );
        userResponse.firstName( user.getFirstName() );
        userResponse.lastName( user.getLastName() );
        userResponse.email( user.getEmail() );
        userResponse.phone( user.getPhone() );
        userResponse.address( user.getAddress() );
        userResponse.dateOfBirth( user.getDateOfBirth() );
        userResponse.gender( user.isGender() );
        userResponse.avatarFilePath( user.getAvatarFilePath() );
        userResponse.role( user.getRole() );

        return userResponse.build();
    }

    protected User userCreateRequestToUser(UserCreateRequest userCreateRequest) {
        if ( userCreateRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( userCreateRequest.getFirstName() );
        user.lastName( userCreateRequest.getLastName() );
        user.email( userCreateRequest.getEmail() );
        user.phone( userCreateRequest.getPhone() );
        user.dateOfBirth( userCreateRequest.getDateOfBirth() );
        user.address( userCreateRequest.getAddress() );
        if ( userCreateRequest.getGender() != null ) {
            user.gender( userCreateRequest.getGender() );
        }

        return user.build();
    }

    protected User userCreateRequestToUser1(UserCreateRequest userCreateRequest) {
        if ( userCreateRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( userCreateRequest.getFirstName() );
        user.lastName( userCreateRequest.getLastName() );
        user.email( userCreateRequest.getEmail() );
        user.phone( userCreateRequest.getPhone() );
        user.dateOfBirth( userCreateRequest.getDateOfBirth() );
        user.address( userCreateRequest.getAddress() );
        if ( userCreateRequest.getGender() != null ) {
            user.gender( userCreateRequest.getGender() );
        }

        user.fullName( userCreateRequest.getFirstName() + " " + userCreateRequest.getLastName() );

        return user.build();
    }

    protected User userCreateRequestToUser2(UserCreateRequest userCreateRequest) {
        if ( userCreateRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( userCreateRequest.getFirstName() );
        user.lastName( userCreateRequest.getLastName() );
        user.email( userCreateRequest.getEmail() );
        user.phone( userCreateRequest.getPhone() );
        user.dateOfBirth( userCreateRequest.getDateOfBirth() );
        user.address( userCreateRequest.getAddress() );
        if ( userCreateRequest.getGender() != null ) {
            user.gender( userCreateRequest.getGender() );
        }

        return user.build();
    }
}
