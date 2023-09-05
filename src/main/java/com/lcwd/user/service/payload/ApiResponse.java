package com.lcwd.user.service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder//so we can follow thw bulider patent to build the object of this class
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

}
