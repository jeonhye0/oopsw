import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class UI {
	private Scanner sc;
	private boolean flag=true;
	private Collection<Integer> scores;
	public UI(InputStream in) {
		sc=new Scanner(in);		
		scores=new ArrayList<Integer>();
		menu();
	}
	//UI
	private void menu() {
		while(flag){
			try{
				System.out.print("메뉴를 입력 1.성적 추가, 2.모두 출력 3.점수 수정 4.저장 or exit :");
				String menuItem=sc.nextLine();
				menuCheck(menuItem);
			}catch(NumberFormatException e){
				System.out.println("error~~숫자를 입력");
			}catch(RuntimeException e){              //-->서버나 프레임워크 처리
				System.out.println(e.getMessage());//
			}catch(ScoreValueException e){
				System.out.println("점수는 0~100까지만");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}//		
	}
	//Action Event 
	private void menuCheck(String menuItem) throws ScoreValueException, IOException {
		switch(menuItem){
		case "1":
			addScore();
			break;
		case "2":
			printAll();
			break;
		case "3":
			updateScore();
			break;
		case "4":
			save();
			break;
		case "exit":
			eventHandlingExit();
			break;
		default :
			defaultMessage();
		}		
	}
	private void defaultMessage() {
		System.out.println("메뉴 다시 확인하세요");		
	}
	private void save() throws IOException {
		//FileOutputStream byteFile=new FileOutputStream("byteFile.txt");
		FileWriter charFile=new FileWriter("charFile.txt", true);
		charFile.write(scores.toString());
		charFile.flush();
		charFile.close();		
	}
	private void eventHandlingExit() {
		flag=false;		
	}
	private int inputInt(String title){
		System.out.print(title);
		return Integer.parseInt(sc.nextLine());
	}
	//입력된 점수의 1번의 점수 40점으로 수정 
	private void updateScore() {
		int index=inputInt("몇번째 점수:");
		ArrayList<Integer> tmp=(ArrayList)scores;  //1
		if(tmp.size() >=index){
			tmp.set(index-1, inputInt("점수 입력(0~100):"));   //2
		}else{
			throw new RuntimeException("점수 갯수 확인 "+tmp.size());
		}		
	}
	private void addScore() throws ScoreValueException {		
		int score=inputInt("점수 입력(0~100):")	;
		if(score<0 || score>100)
			throw new ScoreValueException("0~100");//현재 작업에서 예외 발생
		scores.add(score);		
	}	
	private void printAll() {
		System.out.println(scores);	
	}
	
}
