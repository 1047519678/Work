package cn.mvc.tools;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class DeNEnCoder {
    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();

    /**
     * 字符串加密
     */
    public static String Encode(String text) throws UnsupportedEncodingException {
        byte[] textByte = text.getBytes("UTF-8");

        String encodedText = encoder.encodeToString(textByte);

        return encodedText;
    }

    /**
     * 字符串解密
     */
    public static String Decode(String text) throws UnsupportedEncodingException {
        byte[] textByte = text.getBytes("UTF-8");

        String decodedText = new String(decoder.decode(textByte));

        return decodedText;
    }
}
