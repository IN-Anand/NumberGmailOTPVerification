package org.demo.Dao;

public interface LoginDao {
    int saveOTP(String login);
    boolean validateOTP(String login,int otp);
}
