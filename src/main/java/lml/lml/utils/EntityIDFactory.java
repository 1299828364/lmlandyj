package lml.lml.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EntityIDFactory {

    private static SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static String preID="";


    public static synchronized String createID(){
        String id=format.format(Calendar.getInstance().getTime());
        while (id.equals(preID)){
            id=format.format(Calendar.getInstance().getTime());
        }
        preID=id;
        return id;
    }
}
