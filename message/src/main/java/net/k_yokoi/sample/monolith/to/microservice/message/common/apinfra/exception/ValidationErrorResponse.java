package net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.exception;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ValidationErrorResponse implements ErrorResponse{

    private List<ValidationError> validationErrors;

}
