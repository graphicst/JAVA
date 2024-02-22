package chapter03;

public class PostfixOperator {

	public static void main(String[] args) {
		
		int num1 = 5;
		int num2 = num1++ ; // 대입 연산 후 num1의 값을 1 증가시킴
		
		System.out.println("num1 의 값 : " + num1); // 5
		System.out.println("num2 의 값 : " + num2); // 6
		System.out.println("++num1 의 값 : " + num1++); // 7, 6 출력 후 num1의 값 1 증가
		
	}

}
