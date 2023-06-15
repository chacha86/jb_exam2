package 시험2.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String nowDateTime(){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowdate=sdf1.format(now);
        return nowdate;
    }
}
