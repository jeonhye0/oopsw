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
				System.out.print("�޴��� �Է� 1.���� �߰�, 2.��� ��� 3.���� ���� 4.���� or exit :");
				String menuItem=sc.nextLine();
				menuCheck(menuItem);
			}catch(NumberFormatException e){
				System.out.println("error~~���ڸ� �Է�");
			}catch(RuntimeException e){              //-->������ �����ӿ�ũ ó��
				System.out.println(e.getMessage());//
			}catch(ScoreValueException e){
				System.out.println("������ 0~100������");
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
		System.out.println("�޴� �ٽ� Ȯ���ϼ���");		
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
	//�Էµ� ������ 1���� ���� 40������ ���� 
	private void updateScore() {
		int index=inputInt("���° ����:");
		ArrayList<Integer> tmp=(ArrayList)scores;  //1
		if(tmp.size() >=index){
			tmp.set(index-1, inputInt("���� �Է�(0~100):"));   //2
		}else{
			throw new RuntimeException("���� ���� Ȯ�� "+tmp.size());
		}		
	}
	private void addScore() throws ScoreValueException {		
		int score=inputInt("���� �Է�(0~100):")	;
		if(score<0 || score>100)
			throw new ScoreValueException("0~100");//���� �۾����� ���� �߻�
		scores.add(score);		
	}	
	private void printAll() {
		System.out.println(scores);	
	}
	
}
