package PropertyFileProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\meral\\my-app\\src\\test\\java\\PropertyFileProject\\config.properties");
			prop.load(fis);
		}catch (IOException e) {
			e.printStackTrace();
		}
System.out.println(prop.getProperty("ASA"));
	}

}
