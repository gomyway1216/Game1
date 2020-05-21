package com.tutorial.main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	private BufferedImage image;
	
	public BufferedImage loadImage(String path) {
		try {
//			before = ImageIO.read(getClass().getResource(path));
////			BufferedImage before = getBufferedImage(encoded);
//			int w = before.getWidth();
//			int h = before.getHeight();
//			BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//			AffineTransform at = new AffineTransform();
//			at.scale(0.1, 0.1);
//			AffineTransformOp scaleOp = 
//			   new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//			after = scaleOp.filter(before, after);
//			return after;
			image = ImageIO.read(getClass().getResource(path));
			return resize(image, 32, 32);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	    
		return dimg;
	}
}
