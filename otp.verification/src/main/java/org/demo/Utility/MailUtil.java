package org.demo.Utility;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailMessage;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MailUtil {

    @Inject
    MailClient client;

    public String sendMail(String to, String subject, int otp) {
        try {
            MailMessage message = new MailMessage();
            message.setFrom("test124@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText("Please verify your OTP for login .Your OTP is: " + otp);
            client.sendMail(message)
                    .onSuccess(System.out::println)
                    .onFailure(Throwable::printStackTrace);
            System.out.println("Mail sent successfully to " + to);
            return "Success";
        }catch (Exception e){
            return "Failed";
        }
    }

}
