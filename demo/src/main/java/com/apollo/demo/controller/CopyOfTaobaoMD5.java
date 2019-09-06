package com.apollo.demo.controller;




import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CopyOfTaobaoMD5 {

    public static byte[] getMD5Mac(byte[] bySourceByte){
        byte[] byDisByte;
        MessageDigest md;
        try{
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(bySourceByte);
            byDisByte = md.digest();
        }catch (NoSuchAlgorithmException n){

            return(null);
        }
        return(byDisByte);
    }

    public static String bintoascii(byte []bySourceByte)

    {
        int len,i;
        byte tb;
        char high,tmp,low;
        String result=new String();
        len=bySourceByte.length;
        for(i=0;i<len;i++)
        {
            tb=bySourceByte[i];
            tmp=(char)((tb>>>4)&0x000f);
            if(tmp>=10)
                high=(char)('a'+tmp-10);
            else
                high=(char)('0'+tmp);
            result+=high;
            tmp=(char)(tb&0x000f);
            if(tmp>=10)
                low=(char)('a'+tmp-10);
            else
                low=(char)('0'+tmp);
            result+=low;
        }
        return result;
    }
    public static String getMD5ofStr(String inbuf)
    {
        if(inbuf==null||"".equals(inbuf)) return "";
        return bintoascii(getMD5Mac(inbuf.getBytes()));
    }
    /**
     * 该方法用于生成签名，参数inbuf=签名种子+xml字符串
     * @param inbuf
     * @return
     */
    public static String getSign(String inbuf){
        return getMD5ofStr(inbuf).toLowerCase();
    }

    public static void main(String args[])
    {

    }
}

