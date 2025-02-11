package com.hhh.doctor_appointment_app.controller;

import com.hhh.doctor_appointment_app.dto.request.FeedbackRequest.CreateFeedbackByPatientRequest;
import com.hhh.doctor_appointment_app.dto.request.ReplyFeedbackRequest.ReplyFeedbackByDoctorRequest;
import com.hhh.doctor_appointment_app.dto.response.ApiResponse;
import com.hhh.doctor_appointment_app.service.FeedbackService.Command.CreateFeedbackByPatient.CreateFeedbackByPatientCommand;
import com.hhh.doctor_appointment_app.service.FeedbackService.Query.GetFeedbackOfDoctor.GetFeedbackOfDoctorQuery;
import com.hhh.doctor_appointment_app.service.FeedbackService.Query.GetFeedbackOfDoctorWithPage.GetFeedbackOfDoctorByDoctorWithPageQuery;
import com.hhh.doctor_appointment_app.service.ReplyFeedbackService.Command.CreateReplyFeedbackByDoctor.CreateReplyFeedbackByDoctorCommand;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/feedback")
@CrossOrigin
public class FeedbackController {

    @Autowired
    private CreateFeedbackByPatientCommand createFeedbackByPatientCommand;

    @Autowired
    private GetFeedbackOfDoctorQuery getFeedbackOfDoctorQuery;

    @Autowired
    private CreateReplyFeedbackByDoctorCommand createReplyFeedbackByDoctorCommand;

    @Autowired
    private GetFeedbackOfDoctorByDoctorWithPageQuery getFeedbackOfDoctorByDoctorWithPageQuery;

    @PostMapping("/patient/create")
    public ResponseEntity<?> createFeedbackByPatient(@Valid @RequestBody CreateFeedbackByPatientRequest createFeedbackByPatientRequest, BindingResult bindingResult) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage(errorMessage);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
        try {
            apiResponse = createFeedbackByPatientCommand.createFeedbackByPatient(createFeedbackByPatientRequest);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK); //  for success
        } catch (Exception ex) {

            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("An unexpected error occurred: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
    }

    @GetMapping("/list/doctor/{id}")
    public ResponseEntity<?> getFeedbackOfDoctor(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(getFeedbackOfDoctorQuery.getFeedbackOfDoctorByDoctorId(id), HttpStatus.OK);
        } catch (Exception ex) {
            ApiResponse<Object> apiResponse = new ApiResponse<>();
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("An unexpected error occurred: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
    }

    @PostMapping("/doctor/reply")
    public ResponseEntity<?> replyFeedbackByDoctor(@Valid @RequestBody ReplyFeedbackByDoctorRequest replyFeedbackByDoctorRequest, BindingResult bindingResult) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage(errorMessage);
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
        try {
            apiResponse = createReplyFeedbackByDoctorCommand.createReplyFeedbackByDoctor(replyFeedbackByDoctorRequest);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK); //  for success
        } catch (Exception ex) {

            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("An unexpected error occurred: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }
    }

    @GetMapping("/doctor/all")
    public ResponseEntity<?> getDoctors(@RequestParam(defaultValue = "1") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        try {
            return new ResponseEntity<>(getFeedbackOfDoctorByDoctorWithPageQuery.getFeedbackOfDoctorByDoctorEmail(page, size), HttpStatus.OK);
        } catch (Exception ex) {
            ApiResponse<Object> apiResponse = new ApiResponse<>();
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMessage("An unexpected error occurred: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

        }
    }
}
