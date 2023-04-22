package Payloads;


import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {

    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus httpStatus;
    protected String reason;
    protected String message;

    protected Map<?, ?> data; // przypisuje klucze(etykiety) do zbioru danych (posługuje sie jak idkami w tablicach, muszą być unikalne)
}
