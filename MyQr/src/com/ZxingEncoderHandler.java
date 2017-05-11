package com;

/**
 * Created by Administrator on 2017/5/10.
 */

        import java.io.File;
       import java.util.Hashtable;

        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
        import java.util.HashMap;


        import java.util.Map;

        import javax.imageio.ImageIO;

        import com.google.zxing.BarcodeFormat;
        import com.google.zxing.EncodeHintType;
        import com.google.zxing.MultiFormatWriter;
        import com.google.zxing.client.j2se.MatrixToImageWriter;
        import com.google.zxing.common.BitMatrix;

        import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


public class ZxingEncoderHandler {

    /**
     * 编码
     * @param contents
     * @param width
     * @param height
     * @param imgPath
     */
    public void encode(String contents, int width, int height, String imgPath) {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();

        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "GBK");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,BarcodeFormat.QR_CODE, width, height, hints);

            MatrixToImageWriter
                    .writeToFile(bitMatrix, "png", new File(imgPath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String imgPath = "C:/Users/ghh01/Desktop/MyQr/MyQrV2_20170512/res/qrcode2.png";
        String contents = "Hello Damin,welcome to Zxing!"
                + "\nDamin’s blog [ zhoudm.com ]"
                + "\nEMail [ me@zhoudm.com ]" + "\nSchool [ SYSU ]";
        int width = 300, height = 300;
        ZxingEncoderHandler handler = new ZxingEncoderHandler();
        handler.encode(contents, width, height, imgPath);

        System.out.println("Damin ,you have finished zxing encode.");
    }
}

