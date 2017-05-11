package com;
/**
 * Created by Administrator on 2017/5/10.
 */
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.util.Hashtable;

        import javax.imageio.ImageIO;

        import  com.google.zxing.BinaryBitmap;
        import com.google.zxing.DecodeHintType;
        import com.google.zxing.LuminanceSource;

        import com.google.zxing.Result;
        import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
        import com.google.zxing.common.HybridBinarizer;
        import com.google.zxing.MultiFormatReader;


public class ZxingDecoderHandler {

    /**
     * @param imgPath
     * @return String
     */
    public String decode(String imgPath) {
        BufferedImage image = null;
        Result result = null;
        try {
            image = ImageIO.read(new File(imgPath));
            if (image == null) {
                System.out.println("the decode image may be not exit.");
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "GBK");

            result = new MultiFormatReader().decode(bitmap, hints);

            return result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String imgPath = "C:/Users/ghh01/Desktop/MyQr/MyQrV2_20170512/res/qrcode2.png";

        ZxingDecoderHandler handler = new ZxingDecoderHandler();
        String decodeContent = handler.decode(imgPath);
        System.out.println("解码内容如下：");
        System.out.println(decodeContent);
        System.out.println("Damin ,you have finished zxing decode.");

    }
}
