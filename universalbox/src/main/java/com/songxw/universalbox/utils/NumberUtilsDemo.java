package com.songxw.universalbox.utils;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * commons-lang.jar
 */
public class NumberUtilsDemo {

    /**
     * 数字判断
     * @param str  初始字符串
     */
    private void isNumeric(String str) {
        //判断字符串是否是数字(不包含带加号的数字)
        System.out.println("isNumber:【" + NumberUtils.isNumber(str) + "】");
        //判断字符串是否都是数字(不包含- + .等等)
        System.out.println("isDigits:【" + NumberUtils.isDigits(str) + "】");
    }

    public static void main(String[] args) {
        NumberUtilsDemo numberUtilsDemo = new NumberUtilsDemo();
        String str = "-023.34536092";
        numberUtilsDemo.isNumeric(str);
    }

}
