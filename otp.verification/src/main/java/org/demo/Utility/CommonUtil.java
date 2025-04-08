package org.demo.Utility;

import java.util.Random;

public class CommonUtil {

    public static int  generateRandomOTP(){
        Random random = new Random();
        return  100000 + random.nextInt(900000);
    }


}
