package org.demo.Dao.DaoImpl;

import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailMessage;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.demo.DTO.OTP;
import org.demo.Dao.LoginDao;
import org.demo.Utility.CommonUtil;
import org.demo.Utility.MailUtil;

import java.util.HashMap;

@ApplicationScoped
public class LoginDaoImpl extends CommonUtil implements LoginDao {

    @Inject
    private MailUtil mailUtil;

    private HashMap<String, OTP> DB= new HashMap<>();

    @Override
    public int saveOTP(String login) {
        try{
            int otp = generateRandomOTP();
            OTP o=new OTP();
            o.setOtp(otp);
            o.setLogin(login);
            o.setStartTime(System.currentTimeMillis());
            o.setEndTime(System.currentTimeMillis()+30000);
            DB.put(login, o);
            mailUtil.sendMail("test_to@gmail.com","OTP verification",otp);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean validateOTP(String login, int otp) {
        OTP o=DB.get(login);
        if(o.getEndTime()<System.currentTimeMillis()){
            return false;
        }else return o.getOtp() == otp;
    }
}
