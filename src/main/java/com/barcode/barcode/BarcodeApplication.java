package com.barcode.barcode;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class BarcodeApplication {

			public static void main(String[] args) throws OutputException {
				String code = "shruti"; // the input code for the barcode
				Barcode barcode = null;
				try {
					barcode = BarcodeFactory.createCode128(code);
				} catch (BarcodeException e) {
					e.printStackTrace();
				}
				BufferedImage image = BarcodeImageHandler.getImage(barcode);
				File outputDirectory = new File("/home/shruti/Documents/IntellijIdea Project/Barcode/");
				if (!outputDirectory.exists()) {
					outputDirectory.mkdirs();
				}
				File outputFile = new File(outputDirectory, "barcode.png");
				try {
					ImageIO.write(image, "png", outputFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

