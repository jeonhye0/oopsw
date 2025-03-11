import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class UserScanner{
	private BufferedReader br;
	public UserScanner(InputStream is){
		br=new BufferedReader(new InputStreamReader(is));
	}
	public int nextAge(){
		try{
			return Integer.parseInt(br.readLine());
		}catch(Exception e){
			//e.printStackTrace();
		}				
		return -1;
	}
	public String nextLine(){
		try {
			return br.readLine();
		} catch (IOException e) {			
			e.printStackTrace();//throw new RuntimeException("¿¹¿Ü");
		}
		return null;
	}
}
public class UserTest {
	public static void main(String[] args) {
		UserScanner u1=new UserScanner(System.in);
		System.out.println(u1.nextAge());
	}
}
