import java.util.*;

public class Pizza {
	public static void main(String[] args) {
		double area1 = 2 * 3.141592 * 20 * 20;
		double area2 = 3.141592 * 30 * 30;
		System.out.println("20cm ���� ����=" + area1);
		System.out.println("30cm ���� ����=" + area2);
		System.out.println((area1 > area2)? "20cm �ΰ�": "30cm �Ѱ�");
	}
}