package entitiesConfig;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

public class Image {
	
	private BufferedImage foto;
	
	private String enderecoFoto;
	
	public String saveFoto(ServletContext context, File foto, String identificador, String pasta){
		try {
			enderecoFoto= context.getRealPath("") + "\\images\\" + "\\" + pasta  + "\\";
			this.foto = ImageIO.read(foto);
			ImageIO.write(this.foto, "JPG", new File(this.enderecoFoto + identificador + ".jpg"));
			return "\\images\\" + pasta  + "\\" + identificador + ".jpg";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "erro";
			
		}
	}
	
	public String getFoto(ServletContext context, String foto){
		return context.getRealPath("") + foto;
	}
	
	public void deleteFoto(ServletContext context, String foto, String pasta){
		if(context!=null && foto !=null && !"".equals(foto)){
			enderecoFoto= context.getRealPath("") + "\\images\\" + "\\"+ pasta + "\\";
			File file = new File(context.getRealPath("") + foto);
			file.delete();
		}
	}
}
