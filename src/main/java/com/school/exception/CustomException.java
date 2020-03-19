package com.school.exception;

import com.school.domain.ResultJson;
import lombok.Getter;


@Getter
public class CustomException extends RuntimeException{
    private ResultJson resultJson;

    public CustomException(ResultJson resultJson) {
        this.resultJson = resultJson;
    }
}
