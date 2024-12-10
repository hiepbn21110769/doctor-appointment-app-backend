package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.ChatResponse.ChatMessageResponse;
import com.hhh.doctor_appointment_app.dto.response.ConversationResponse.ConversationResponse;
import com.hhh.doctor_appointment_app.dto.response.DoctorResponse.DoctorChatResponse;
import com.hhh.doctor_appointment_app.dto.response.PatientResponse.PatientChatResponse;
import com.hhh.doctor_appointment_app.entity.ChatMessage;
import com.hhh.doctor_appointment_app.entity.Conversation;
import com.hhh.doctor_appointment_app.entity.Doctor;
import com.hhh.doctor_appointment_app.entity.Patient;
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
public class ChatMessageMapperImpl implements ChatMessageMapper {

    @Override
    public ChatMessageResponse toChatMessageResponse(ChatMessage chatMessage) {
        if ( chatMessage == null ) {
            return null;
        }

        ChatMessageResponse.ChatMessageResponseBuilder chatMessageResponse = ChatMessageResponse.builder();

        chatMessageResponse.id( chatMessage.getId() );
        chatMessageResponse.message( chatMessage.getMessage() );
        chatMessageResponse.sender( chatMessage.getSender() );
        chatMessageResponse.conversation( conversationToConversationResponse( chatMessage.getConversation() ) );
        chatMessageResponse.timeStamp( chatMessage.getTimeStamp() );

        return chatMessageResponse.build();
    }

    @Override
    public List<ChatMessageResponse> toChatMessageResponseList(List<ChatMessage> chatMessageList) {
        if ( chatMessageList == null ) {
            return null;
        }

        List<ChatMessageResponse> list = new ArrayList<ChatMessageResponse>( chatMessageList.size() );
        for ( ChatMessage chatMessage : chatMessageList ) {
            list.add( toChatMessageResponse( chatMessage ) );
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

    protected ConversationResponse conversationToConversationResponse(Conversation conversation) {
        if ( conversation == null ) {
            return null;
        }

        ConversationResponse.ConversationResponseBuilder conversationResponse = ConversationResponse.builder();

        conversationResponse.id( conversation.getId() );
        conversationResponse.doctor( doctorToDoctorChatResponse( conversation.getDoctor() ) );
        conversationResponse.patient( patientToPatientChatResponse( conversation.getPatient() ) );

        return conversationResponse.build();
    }
}
