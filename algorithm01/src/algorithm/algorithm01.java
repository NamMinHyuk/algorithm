package algorithm;

import java.util.Scanner;

public class algorithm01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("번호를 입력하시오 : ");
		String numbers = scanner.nextLine();
		System.out.print("어느손 잡이인지 입력하시오(right,left) : ");
		String hand = scanner.nextLine();
		numbers = numbers.replace(" ", "");
		int[] number = new int[numbers.length()];
		for(int i=0;i<number.length;i++) {
			number[i] = Character.getNumericValue(numbers.charAt(i));
		}
		System.out.println(solution(number,hand));
		scanner.close();
	}
	public static String solution(int[] numbers, String hand) {
		String[][] keypad = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}};
		String left = "1";
		String right = "3";
		for(int i=0;i<keypad.length;i++) {
			for(int j=0;j<keypad[i].length;j++) {
				//System.out.printf(keypad[i][j] + " , ");
			}
		}
		String answer = "";
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				left = Integer.toString(numbers[i]);
			}else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				right = Integer.toString(numbers[i]);
			}else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
				if((numbers[i] - Integer.parseInt(left)) > (numbers[i] - Integer.parseInt(right))) {
					answer += "R";
					right = Integer.toString(numbers[i]);
				}else if((numbers[i] - Integer.parseInt(left)) == (numbers[i] - Integer.parseInt(right))) {
					if(hand == "right") {
						answer += "R";
						right = Integer.toString(numbers[i]);
					}else {
						answer += "L";
						left = Integer.toString(numbers[i]);
					}
				}else {
					answer += "L";
					left = Integer.toString(numbers[i]);
				}
			}
		}
		return answer;
	}
}
