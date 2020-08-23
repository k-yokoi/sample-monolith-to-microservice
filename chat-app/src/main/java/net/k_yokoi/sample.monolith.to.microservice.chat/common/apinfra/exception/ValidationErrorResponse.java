package net.k_yokoi.sample.monolith.to.microservice.chat.common.apinfra.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ValidationErrorResponse implements ErrorResponse{

    private List<ValidationError> validationErrors;

}
