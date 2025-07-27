package com.example.Aadhar.service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class BarcodeGenerator {
	 public static byte[] generateBarcode(String aadhaarNumber) throws Exception {
	        int width = 300;
	        int height = 100;
	        
	        BitMatrix bitMatrix = new MultiFormatWriter().encode(aadhaarNumber, BarcodeFormat.CODE_128, width, height);
	        BufferedImage barcodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(barcodeImage, "png", baos);
	        return baos.toByteArray(); // Return barcode as byte array
	    }
}
