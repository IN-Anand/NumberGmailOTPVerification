package org.demo.DTO;

import lombok.Data;

@Data
public class OTP {
    private String login;
    private int otp;
    private long startTime;
    private long endTime;
}
