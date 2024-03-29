import java.io.File;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.filechooser.FileFilter;



public class ImageFileFiltrer extends FileFilter{
	public boolean accept(File file) {
	    if (file.isDirectory()) return true;
	    String fname = file.getName().toLowerCase();
	    return fname.endsWith("jpg");
	  }

	  public String getDescription() {
	    return "File jpeg";
	  }
	  public Image getScaledImage(Image srcImg, int w, int h){
		    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D g2 = resizedImg.createGraphics();

		    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    g2.drawImage(srcImg, 0, 0, w, h, null);
		    g2.dispose();

		    return resizedImg;
		}	  

	
	  	
	  	
	  }
	

