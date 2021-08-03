package algorithm02;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class algorithm02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수식을 입력하시오 : ");
		String input = scanner.nextLine();
		input = input.replace(" ", "");
		System.out.println(solution(input));
	}
	public static long solution(String expression) {
		HashSet<String> set = new HashSet<String>();
		
		System.out.println(expression);
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='-' || expression.charAt(i)=='+' || expression.charAt(i)=='*') {
				 set.add(Character.toString(expression.charAt(i)));
			}
		}
        long answer = 123;
        return answer;
    }
}
