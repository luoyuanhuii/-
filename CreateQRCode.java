package qrCode;

import java.io.File;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class CreateQRCode {

	public static void main(String[] args) throws Exception {
		String text = "π„Œ˜√Ò¥Û¿∂«≈4∞‡ÀÔÀß";
		int width = 100;
		int height = 100;
		String format = "png";
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		File outputFile = new File("E:\\1¿∂«≈\\ÀÔÀß.png");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

	}
}