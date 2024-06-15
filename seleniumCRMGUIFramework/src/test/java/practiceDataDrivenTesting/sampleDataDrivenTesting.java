package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class sampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("./testdata/commondata.Properties");
    Properties p= new Properties();
    p.load(fis);
   System.out.println(p.getProperty("browser"));
   System.out.println(p.getProperty("url"));
    

	}

}
