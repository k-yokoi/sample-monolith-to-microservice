package net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.util;

import java.sql.Timestamp;
import java.util.Date;

public interface DateUtils {

    public static String now(){
        return (new Timestamp(System.currentTimeMillis()).toString());
    }

    public static Date nowDate(){
        return  new Date(System.currentTimeMillis());
    }

}
