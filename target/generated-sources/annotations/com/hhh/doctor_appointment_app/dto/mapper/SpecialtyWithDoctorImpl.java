package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorResponse;
import com.hhh.doctor_appointment_app.dto.response.SpecialtyResponse.SpecialResponeWithDoctorList;
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
public class SpecialtyWithDoctorImpl implements SpecialtyWithDoctor {

    @Override
    public SpecialResponeWithDoctorList toResponse(Specialty specialty) {
        if ( specialty == null ) {
            return null;
        }

        SpecialResponeWithDoctorList.SpecialResponeWithDoctorListBuilder specialResponeWithDoctorList = SpecialResponeWithDoctorList.builder();

        specialResponeWithDoctorList.id( specialty.getId() );
        specialResponeWithDoctorList.specialtyName( specialty.getSpecialtyName() );
        specialResponeWithDoctorList.doctorList( doctorListToDoctorResponseList( specialty.getDoctorList() ) );
        specialResponeWithDoctorList.headDoctor( specialty.getHeadDoctor() );

        return specialResponeWithDoctorList.build();
    }

    protected DoctorResponse doctorToDoctorResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorResponse.DoctorResponseBuilder doctorResponse = DoctorResponse.builder();

        doctorResponse.id( doctor.getId() );
        doctorResponse.specialty( doctor.getSpecialty() );
        doctorResponse.averageRating( doctor.getAverageRating() );

        return doctorResponse.build();
    }

    protected List<DoctorResponse> doctorListToDoctorResponseList(List<Doctor> list) {
        if ( list == null ) {
            return null;
        }

        List<DoctorResponse> list1 = new ArrayList<DoctorResponse>( list.size() );
        for ( Doctor doctor : list ) {
            list1.add( doctorToDoctorResponse( doctor ) );
        }

        return list1;
    }
}
