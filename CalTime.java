import java.util.Scanner;

public class CalTime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("�ʸ� �Է��Ͻÿ�:");
		int time = sc.nextInt();
		int sec = (time%60);	// ������ �����ڸ� �̿��Ѵ�. 
		int min = (time/60);	// ���� �������� �̿��Ѵ�. 

		System.out.println(time+"�ʴ� "+min+"�� "+sec +"���Դϴ�."); 
	}
}