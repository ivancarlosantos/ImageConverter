package com.imageconveeter;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author icarlos
 */
public class ImageConverter {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String imagePath = "C:\\Users\\Carol\\Pictures\\cavalodamae.jpg";
		File file = new File(imagePath);

		FileInputStream fis = new FileInputStream(file);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bufferByte = new byte[256];

		try {
			for (int readNum; (readNum = fis.read(bufferByte)) != -1;) {
				baos.write(bufferByte, 0, readNum);
				System.out.println("Ler " + readNum + " bytes,");
			}
		} catch (IOException ex) {
			Logger.getLogger(ImageConverter.class.getName()).log(Level.SEVERE, null, ex);
		}

		byte[] bytes = baos.toByteArray();

		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

		ImageReader reader = (ImageReader) readers.next();
		Object source = bais;
		ImageInputStream iis = ImageIO.createImageInputStream(source);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();

		Image image = reader.read(0, param);
		// got an image file

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		// bufferedImage is the RenderedImage to be written

		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(image, null, null);

		File imageFile = new File("C:\\Users\\Carol\\Pictures\\cavalodamaeTRES_TETA.jpg");
		ImageIO.write(bufferedImage, "jpg", imageFile);

		System.out.println(imageFile.getPath());
	}
	
	/*
	 * String dirName = "C:\\Users\\Carol\\Pictures\\"; 
	 * ByteArrayOutputStream baos = new ByteArrayOutputStream(1024); 
	 * BufferedImage img = ImageIO.read(new File(dirName,"cavalodamae.jpg")); 
	 * ImageIO.write(img,"jpg", baos); 
	 * baos.flush();
	 * 
	 * String base64String = Base64.encode(baos.toByteArray()); 
	 * baos.close();
	 * 
	 * byte[] bytearray = Base64.decode(base64String);
	 * 
	 * BufferedImage imag = ImageIO.read(new ByteArrayInputStream(bytearray));
	 * ImageIO.write(imag, "jpg", new File(dirName,"egua.jpg")); }
	 */
}
