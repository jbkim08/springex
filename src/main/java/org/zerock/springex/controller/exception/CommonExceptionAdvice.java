package org.zerock.springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(NoHandlerFoundException e) {
        return "custom404";
    }

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exception(NumberFormatException e) {
        log.error("-------------------------------------");
        log.error(e.getMessage());

        return "NUMBER FORMAT EXCEPTION";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception e) {
        log.error("-------------------------------------");
        log.error(e.getMessage());
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>").append(e.getMessage()).append("</li>");
        Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>").append(stackTraceElement.toString()).append("</li>");
        });
        buffer.append("</ul>");
        return buffer.toString();
    }


}
