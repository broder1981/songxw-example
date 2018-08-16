package com.songxw.universalbox.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * commons-lang.jar
 */
public class StringUtilsDemo {

    /**
     * 判断字符串是否为空
     * @param str  初始字符串
     */
    private void isEmpty(String str) {
        //判断字符串是否为空(null或者"")
        System.out.println("isEmpty:【" + StringUtils.isEmpty(str) + "】");
        //判断字符串是否不为空(null或者"")
        System.out.println("isNotEmpty:【" + StringUtils.isNotEmpty(str) + "】");
        //判断字符串是否为空(null、""、" "、"\t"、"\n"、"\f"、"\r")
        System.out.println("isBlank:【" + StringUtils.isBlank(str) + "】");
        //判断字符串是否不为空(null、""、" "、"\t"、"\n"、"\f"、"\r")
        System.out.println("isNotBlank:【" + StringUtils.isNotBlank(str) + "】");
        //如果字符串为null,默认值为""
        System.out.println("defaultString:【" + StringUtils.defaultString(str) + "】");
        //如果字符串为null,默认值为指定字符串
        System.out.println("defaultString:【" + StringUtils.defaultString(str, "sa") + "】");
    }

    /**
     * 字符串截取
     * @param str  初始字符串
     */
    private void cutString(String str) {
        //从字符串最左侧开始截取len位
        System.out.println("left:【" + StringUtils.left(str, 10) + "】");
        //从字符串最右侧开始截取len位
        System.out.println("right:【" + StringUtils.right(str, 10) + "】");
        //从字符串的第start位开始截取到最后一位
        System.out.println("substring:【" + StringUtils.substring(str, 3) + "】");
        //从字符串的第start位开始截取到第end-1位(第end位本身不会被截取)
        System.out.println("substring:【" + StringUtils.substring(str, 4, 8) + "】");
        //从字符串的第pos位开始截取len位
        System.out.println("mid:【" + StringUtils.mid(str, 10, 5) + "】");
        //从字符串中的指定子串的后一位开始截取到最后一位
        //如果存在多个相同的指定子串则以第一个为准
        System.out.println("substringAfter:【" + StringUtils.substringAfter(str, "xycd") + "】");
        //从字符串中的指定子串的后一位开始截取到最后一位
        //如果存在多个相同的指定子串则以最后一个为准
        System.out.println("substringAfterLast:【" + StringUtils.substringAfterLast(str, "xycd") + "】");
        //从字符串的第一位开始截取到指定子串的前一位
        //如果存在多个相同的指定子串则以第一个为准
        System.out.println("substringBefore:【" + StringUtils.substringBefore(str, "xycd") + "】");
        //从字符串的第一位开始截取到指定子串的前一位
        //如果存在多个相同的指定子串则以最后一个为准
        System.out.println("substringBeforeLast:【" + StringUtils.substringBeforeLast(str, "xycd") + "】");
        //从字符串中截取两个相同子串之间的部分
        //如果存在两个以上相同的指定子串则只截取前两个之间的
        System.out.println("substringBetween:【" + StringUtils.substringBetween(str, "yc") + "】");
        //从字符串中截取一对区间内的部分
        //如果存在多对区间则默认截取第一对区间内的部分
        System.out.println("substringBetween:【" + StringUtils.substringBetween(str, "ab", "xy") + "】");
        //从字符串中截取一对或者多对区间内的部分生成数组
        System.out.println("substringsBetween:【" + StringUtils.substringsBetween(str, "ab", "xy").length + "】");
    }

    /**
     * 字符串填充
     * @param str  初始字符串
     */
    private void fillString(String str) {
        //在字符串最左侧循环填充子串,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("leftPad:【" + StringUtils.leftPad(str, 10, "-+=3") + "】");
        //在字符串最左侧循环填充字符,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("leftPad:【" + StringUtils.leftPad(str, 10, '-') + "】");
        //在字符串最左侧循环填充空格,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("leftPad:【" + StringUtils.leftPad(str, 5) + "】");
        //在字符串最右侧循环填充子串,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("rightPad:【" + StringUtils.rightPad(str, 10, "-+=3") + "】");
        //在字符串最右侧循环填充字符,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("rightPad:【" + StringUtils.rightPad(str, 10, '-') + "】");
        //在字符串最右侧循环填充空格,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("rightPad:【" + StringUtils.rightPad(str, 5) + "】");
        //在字符串两侧循环填充子串,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("center:【" + StringUtils.center(str,12,"5+") + "】");
        //在字符串两侧循环填充字符,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("center:【" + StringUtils.center(str,12,'-') + "】");
        //在字符串两侧循环填充空格,直到"填充的位数"+"字符串长度"="size参数"
        System.out.println("center:【" + StringUtils.center(str,12) + "】");
        //字符串重复若干次
        System.out.println("repeat:【" + StringUtils.repeat(str, 3) + "】");
        //字符串末尾加上后缀之后再重复若干次
        System.out.println("repeat:【" + StringUtils.repeat(str, "seed", 3) + "】");
    }

    /**
     * 字符串删除
     * @param str  初始字符串
     */
    private void removeString(String str) {
        //删除字符串的最后一位
        System.out.println("chop:【" + StringUtils.chop(str) + "】");
        //删除字符串末尾的最后一个换行符(如果末尾包含多个换行符,只去掉最后一个)
        System.out.println("chomp:【" + StringUtils.chomp(str) + "】");
        //删除字符串中所有指定子串
        System.out.println("remove:【" + StringUtils.remove(str, "sa") + "】");
        //删除字符串末尾的指定子串
        System.out.println("removeEnd:【" + StringUtils.removeEnd(str, "af") + "】");
        //删除字符串末尾的指定子串,不区分大小写
        System.out.println("removeEndIgnoreCase:【" + StringUtils.removeEndIgnoreCase(str, "fD") + "】");
        //删除字符串起始的指定子串
        System.out.println("removeStart:【" + StringUtils.removeStart(str, "c2") + "】");
        //删除字符串起始的指定子串,不区分大小写
        System.out.println("removeStartIgnoreCase:【" + StringUtils.removeStartIgnoreCase(str, "C2aB") + "】");
        //删除字符串首尾空格
        System.out.println("trim:【" + StringUtils.trim(str) + "】");
        //删除字符串中所有空格
        System.out.println("deleteWhitespace:【" + StringUtils.deleteWhitespace(str) + "】");
    }

    /**
     * 字符串替换
     * @param str  初始字符串
     */
    private void replaceString(String str) {
        //把字符串中的子串替换为新的子串,替换所有找到的子串
        System.out.println("replace:【" + StringUtils.replace(str, "sa", "ma") + "】");
        //把字符串中的子串替换为新的子串,最多替换max个找到子串
        System.out.println("replace:【" + StringUtils.replace(str, "sa", "ma", 1) + "】");
        //把字符串中的子串替换为新的子串,只替换一个找到的子串
        System.out.println("replaceOnce:【" + StringUtils.replaceOnce(str, "sa", "ma") + "】");
    }

    /**
     * 字符串查找
     * @param str  初始字符串
     */
    private void findString(String str) {
        //指定子串在字符串中出现的次数,没找到为0
        System.out.println("countMatches:【" + StringUtils.countMatches(str, "ma") + "】");
        //指定子串在字符串中出现的位置,如果含多个则返回找到的第一个子串的位置,没找到为-1
        System.out.println("indexOf:【" + StringUtils.indexOf(str, "ma") + "】");
        //判断字符串中是否包含指定的子串
        System.out.println("contains:【" + StringUtils.contains(str, "ma") + "】");
        //判断字符串起始是否包含子串
        System.out.println("startsWith:【" + StringUtils.startsWith(str, "ma") + "】");
        //判断字符串起始是否包含子串,不区分大小写
        System.out.println("startsWithIgnoreCase:【" + StringUtils.startsWithIgnoreCase(str, "ma") + "】");
        //判断字符串末尾是否包含子串
        System.out.println("endsWith:【" + StringUtils.endsWith(str, "ma") + "】");
        //判断字符串末尾是否包含子串,不区分大小写
        System.out.println("endsWithIgnoreCase:【" + StringUtils.endsWithIgnoreCase(str, "ma") + "】");
    }

    /**
     * 数值判断
     * @param str  初始字符串
     */
    private void isNumeric(String str) {
        //判断字符串是否是整数(不包括负数),坑爹的是""也为true,慎用
        System.out.println("isNumeric:【" + StringUtils.isNumeric(str) + "】");
    }

    public static void main(String[] args) {
        StringUtilsDemo stringUtilsDemo = new StringUtilsDemo();
        String str = "mafaljfklsdjlma";
        stringUtilsDemo.isEmpty(str);
        stringUtilsDemo.isNumeric(str);
        stringUtilsDemo.cutString(str);
        stringUtilsDemo.fillString(str);
        stringUtilsDemo.removeString(str);
        stringUtilsDemo.replaceString(str);
        stringUtilsDemo.findString(str);
    }

}
