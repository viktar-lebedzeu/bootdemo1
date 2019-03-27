package com.example.bootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Simple error message bean
 * @author Viktar Lebedzeu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    public static final ErrorMessage UNKNOWN = new ErrorMessage(-1, "Unknown error");

    /** Error code number */
    @Getter
    @Setter
    private Integer errorCode;

    /** Error message text */
    @Getter
    @Setter
    private String message;
}
