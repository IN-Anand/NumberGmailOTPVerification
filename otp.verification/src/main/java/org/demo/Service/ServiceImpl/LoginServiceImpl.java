package org.demo.Service.ServiceImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.demo.Dao.LoginDao;
import org.demo.Service.LoginService;

@ApplicationScoped
public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginDao loginDao;

    @Override
    public String loginService(String login) {
        try {
             if (login.contains("@")) {
                 loginDao.saveOTP(login);
            }else if (isNumeric(login)) {
                //send OTP to number
            } else {
                return "Not valid login";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String validateService(String login,int otp) {
        try {
            loginDao.validateOTP(login, otp);
            return "Success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Failed";
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
