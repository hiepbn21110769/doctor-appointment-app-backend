package com.hhh.doctor_appointment_app.dto.mapper;

import com.hhh.doctor_appointment_app.dto.response.FeedbackResponse.FeedbackResponse;
import com.hhh.doctor_appointment_app.entity.Feedback;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-10T22:36:27+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class FeedbackMapperImpl implements FeedbackMapper {

    @Override
    public FeedbackResponse toResponse(Feedback feedback) {
        if ( feedback == null ) {
            return null;
        }

        FeedbackResponse feedbackResponse = new FeedbackResponse();

        feedbackResponse.setId( feedback.getId() );
        feedbackResponse.setComment( feedback.getComment() );
        feedbackResponse.setDateComment( feedback.getDateComment() );
        feedbackResponse.setRating( feedback.getRating() );

        return feedbackResponse;
    }
}
