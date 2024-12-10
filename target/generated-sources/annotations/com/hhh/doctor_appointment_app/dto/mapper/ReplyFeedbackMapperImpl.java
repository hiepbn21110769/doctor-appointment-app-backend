package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.ReplyFeedbackResponse.ReplyFeedbackResponse;
import com.hhh.doctor_appointment_app.entity.ReplyFeedback;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T22:36:27+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ReplyFeedbackMapperImpl implements ReplyFeedbackMapper {

    @Override
    public ReplyFeedbackResponse toResponse(ReplyFeedback replyFeedback) {
        if ( replyFeedback == null ) {
            return null;
        }

        ReplyFeedbackResponse replyFeedbackResponse = new ReplyFeedbackResponse();

        replyFeedbackResponse.setId( replyFeedback.getId() );
        replyFeedbackResponse.setComment( replyFeedback.getComment() );
        replyFeedbackResponse.setDateComment( replyFeedback.getDateComment() );

        return replyFeedbackResponse;
    }
}
