package qrCode;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
 
public class JunitImage {
	 
    /**
     * @param srcImgPath ԴͼƬ·��
     * @param tarImgPath �����ͼƬ·��
     * @param waterMarkContent ˮӡ����
     * @param markContentColor ˮӡ��ɫ
     * @param font ˮӡ����
     */
    public void addWaterMark(String srcImgPath, String tarImgPath, String waterMarkContent, Color markContentColor, Font font) {
 
        try {
            // ��ȡԭͼƬ��Ϣ
            File srcImgFile = new File(srcImgPath);//�õ��ļ�
            Image srcImg = ImageIO.read(srcImgFile);//�ļ�ת��ΪͼƬ
            int srcImgWidth = srcImg.getWidth(null);//��ȡͼƬ�Ŀ�
            int srcImgHeight = srcImg.getHeight(null);//��ȡͼƬ�ĸ�
            // ��ˮӡ
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //����ͼƬ�ı�������ˮӡ��ɫ
            g.setFont(font);              //��������
 
            //����ˮӡ������
            int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 10;
            int y = srcImgHeight - 10;
            g.drawString(waterMarkContent, x, y);  //����ˮӡ
            g.dispose();
            // ���ͼƬ
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            System.out.println("���ˮӡ���");
            outImgStream.flush();
            outImgStream.close();
 
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }
    public static void main(String[] args) {
        Font font = new Font("΢���ź�", Font.PLAIN, 60);                     //ˮӡ����
        String srcImgPath="D:\\1.jpg"; //ԴͼƬ��ַ
        String tarImgPath="D:\\1.jpg"; //���洢�ĵ�ַ
        String waterMarkContent="������";  //ˮӡ����
        Color color=new Color(255,255,255,128);                               //ˮӡͼƬɫ���Լ�͸����
        new JunitImage().addWaterMark(srcImgPath, tarImgPath,waterMarkContent, color ,font);
 
    }
 
}