package HBDONF.util;

import HBDONF.domain.common.CommonResponseDto;
import org.apache.http.HttpStatus;

public class ResponseUtil {

    public static <T> CommonResponseDto<T> success(T response) {
        return new CommonResponseDto(String.valueOf(HttpStatus.SC_OK), response);
    }

    public static <T> CommonResponseDto<T> fail(String code, T response) {
        return new CommonResponseDto(code, response);
    }
} 