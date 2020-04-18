package com.bdqn.bills.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;

public class PasswordUtil {

    /**
     * 对密码加密 md5
     * @param source  要加密的明文
     * @param salt  盐
     * @param hashIterations  散列次数
     * @return
     */
    public static String md5(String source, Object salt, Integer hashIterations) {
        return new Md5Hash(source, salt, hashIterations).toString();
    }


    /**
     * 对密码加密sha1
     * @param source  要加密的明文
     * @param salt  盐
     * @param hashIterations  散列次数
     * @return
     */
    public static String sha1(String source, Object salt, Integer hashIterations) {
        return new Sha1Hash(source, salt, hashIterations).toString();
    }


    public static void main(String[] args) {
        String pwd = "123456";//加密前的密码
        String salt = "admin";//加密作料（盐）,建议盐值唯一
        System.out.println(PasswordUtil.md5(pwd,salt,3));
    }

}
