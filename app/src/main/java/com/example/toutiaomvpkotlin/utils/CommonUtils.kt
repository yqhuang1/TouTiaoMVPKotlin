package com.example.toutiaomvpkotlin.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object CommonUtils {
    private const val regExp = "^^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}\$"

    //手机号码正则
    fun checkMobile(mobile: String): Boolean = Pattern.compile(regExp).matcher(mobile).matches()

    //去空格、回车、换行符、制表符
    fun replaceBlank(str: String): String {
        var dest: String = ""
        if (str != null) {
            val p: Pattern = Pattern.compile("\\s*|\t|\r|\n")
            val m: Matcher = p.matcher(str)
            dest = m.replaceAll("")
        }
        return dest
    }
}