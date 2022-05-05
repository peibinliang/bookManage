package com.book.manage.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author liangpeibin
 * @ClassName UserUtils
 * @Description
 * @since 2022/5/3 22:45
 */
public class UserUtils {

    /**
     * 校正手机号
     * @param phoneNumber 手机号
     * @return boolean 手机号格式是否正确
     */
    public static boolean CorrectPhoneNumber(String phoneNumber){
        String regex = "/^(13[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})|(19[0-9]{9})$/";
        return Pattern.matches(regex,phoneNumber);
    }

    /**
     * 时间格式化
     * @param date
     * @return
     */
    public static String FormatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = simpleDateFormat.format(date);
        return formatDate;
    }

    /**
     * 图书库编号生成器
     * @return
     */
    public static String generateLibraryNo(){
        String libraryNo = "LN";
        Date now = new Date();
        libraryNo += Integer.toOctalString((int)now.getTime());
        return libraryNo;
    }

    public static void main(String[] args) {
        System.out.println(generateLibraryNo());
    }
}
