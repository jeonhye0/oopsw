import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOTest {
	public static void main(String[] args) throws IOException {
		System.out.println("1234ABCDÇÑ±Û");
		InputStream is=System.in;
		InputStreamReader isr=new InputStreamReader(is);
		//int data=isr.read();
		//System.out.println((char)data+""+(char)(data+1));
		//char-->String
		BufferedReader br=new BufferedReader(isr);
		System.out.println(br.readLine());
	}
}
