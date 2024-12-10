package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.SpecialtyResponse.SpecialtyResponse;
import com.hhh.doctor_appointment_app.entity.Doctor;
import com.hhh.doctor_appointment_app.entity.Specialty;
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
public class SpecialtyMapperImpl implements SpecialtyMapper {

    @Override
    public SpecialtyResponse toResponse(Specialty specialty) {
        if ( specialty == null ) {
            return null;
        }

        SpecialtyResponse.SpecialtyResponseBuilder specialtyResponse = SpecialtyResponse.builder();

        specialtyResponse.id( specialty.getId() );
        specialtyResponse.specialtyName( specialty.getSpecialtyName() );
        List<Doctor> list = specialty.getDoctorList();
        if ( list != null ) {
            specialtyResponse.doctorList( new ArrayList<Doctor>( list ) );
        }
        specialtyResponse.headDoctor( specialty.getHeadDoctor() );

        return specialtyResponse.build();
    }
}
