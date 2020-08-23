package net.k_yokoi.sample.monolith.to.microservice.chat.common.apinfra.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BusinessExceptionResponse implements ErrorResponse{

    private BusinessException businessException;

}
