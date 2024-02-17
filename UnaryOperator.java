package chapter03;

public class UnaryOperator {

	public static void main(String[] args) {
		
		int num1 = 30;
		
		System.out.println(num1++); // 30출력 ->(num1->31)  
		System.out.println(++num1); // (num1->32) -> 32출력  
		System.out.println(num1--); // 32출력 ->(num1->31)  
		System.out.println(--num1); // (num1->31) -> 31출력
		
		System.out.println(num1++ + ++num1); // 30+((30+1)+1)=62  
		
	}

}
