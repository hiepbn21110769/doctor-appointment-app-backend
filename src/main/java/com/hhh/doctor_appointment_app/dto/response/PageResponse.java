package com.hhh.doctor_appointment_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T>  extends  ApiResponse<T> {
    private double totalPage;
    private Long totalSize;
}