package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.ConversationResponse.ConversationResponse;
import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorChatResponse;
import com.hhh.doctor_appointment_app.dto.response.PatientResponse.PatientChatResponse;
import com.hhh.doctor_appointment_app.entity.Conversation;
import com.hhh.doctor_appointment_app.entity.Doctor;
import com.hhh.doctor_appointment_app.entity.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T22:36:28+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ConversationMapperImpl implements ConversationMapper {

    @Override
    public ConversationResponse toResponse(Conversation conversation) {
        if ( conversation == null ) {
            return null;
        }

        ConversationResponse.ConversationResponseBuilder conversationResponse = ConversationResponse.builder();

        conversationResponse.id( conversation.getId() );
        conversationResponse.doctor( doctorToDoctorChatResponse( conversation.getDoctor() ) );
        conversationResponse.patient( patientToPatientChatResponse( conversation.getPatient() ) );

        return conversationResponse.build();
    }

    @Override
    public List<ConversationResponse> toListResponse(List<Conversation> conversations) {
        if ( conversations == null ) {
            return null;
        }

        List<ConversationResponse> list = new ArrayList<ConversationResponse>( conversations.size() );
        for ( Conversation conversation : conversations ) {
            list.add( toResponse( conversation ) );
        }

        return list;
    }

    protected DoctorChatResponse doctorToDoctorChatResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorChatResponse.DoctorChatResponseBuilder doctorChatResponse = DoctorChatResponse.builder();

        doctorChatResponse.id( doctor.getId() );
        doctorChatResponse.specialty( doctor.getSpecialty() );

        return doctorChatResponse.build();
    }

    protected PatientChatResponse patientToPatientChatResponse(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientChatResponse.PatientChatResponseBuilder patientChatResponse = PatientChatResponse.builder();

        patientChatResponse.id( patient.getId() );

        return patientChatResponse.build();
    }
}
