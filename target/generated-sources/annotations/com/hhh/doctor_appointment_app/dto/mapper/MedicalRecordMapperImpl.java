package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorResponse;
import com.hhh.doctor_appointment_app.dto.response.MedicalRecordResponse.MedicalRecordResponse;
import com.hhh.doctor_appointment_app.entity.Doctor;
import com.hhh.doctor_appointment_app.entity.MedicalRecord;
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
public class MedicalRecordMapperImpl implements MedicalRecordMapper {

    @Override
    public MedicalRecordResponse toResponse(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }

        MedicalRecordResponse.MedicalRecordResponseBuilder medicalRecordResponse = MedicalRecordResponse.builder();

        medicalRecordResponse.doctorResponse( doctorToDoctorResponse( medicalRecord.getDoctorModified() ) );
        medicalRecordResponse.dateCreated( medicalRecord.getDateCreated() );
        medicalRecordResponse.lastModified( medicalRecord.getLastModified() );
        medicalRecordResponse.emailPatient( medicalRecordPatientProfileEmail( medicalRecord ) );
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

        return medicalRecordResponse.build();
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

    private String medicalRecordPatientProfileEmail(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }
        Patient patient = medicalRecord.getPatient();
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
}
