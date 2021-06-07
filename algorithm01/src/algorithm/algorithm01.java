package algorithm;

import java.util.HashMap;
import java.util.Map;
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
		for (int i = 0; i < number.length; i++) {
			number[i] = Character.getNumericValue(numbers.charAt(i));
		}
		System.out.println(solution(number, hand));
		scanner.close();
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		// 키패드, 좌표 설정
		Map<String, String> keypad = new HashMap<String, String>();
		int count = 1;
		for(int i=1;i<4;i++) {
			for(int j=1;j<4;j++) {
				keypad.put(Integer.toString(count),Integer.toString(i)+","+Integer.toString(j));
				count++;
			}
		}
		keypad.put("*","4,1");
		keypad.put("0", "4,2");
		keypad.put("#", "4,3");
		// 왼손 좌표 초기화
		String left = "*";
		String left_loc = keypad.get(left);	
		
		// 오른손 좌표 초기화
		String right = "#";
		String right_loc = keypad.get(right);		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				left = Integer.toString(numbers[i]);
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				right = Integer.toString(numbers[i]);
			} else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
					
					int left_res = (int)(Math.abs(Double.parseDouble(keypad.get(left).substring(0, 1)) - Double.parseDouble(keypad.get(Integer.toString(numbers[i])).substring(0, 1))) +
					Math.abs(Double.parseDouble(keypad.get(left).substring(2, 3)) - Double.parseDouble(keypad.get(Integer.toString(numbers[i])).substring(2, 3))));
					
					int right_res = (int)(Math.abs(Double.parseDouble(keypad.get(right).substring(0, 1)) - Double.parseDouble(keypad.get(Integer.toString(numbers[i])).substring(0, 1))) +
					Math.abs(Double.parseDouble(keypad.get(right).substring(2, 3)) - Double.parseDouble(keypad.get(Integer.toString(numbers[i])).substring(2, 3))));
					
					if(left_res < right_res) {
						answer += "L";
						left = Integer.toString(numbers[i]);
					}else if(left_res == right_res) {
						if(hand.equals("right")) {
							answer += "R";
							right = Integer.toString(numbers[i]);
						}else {
							answer += "L";
							left = Integer.toString(numbers[i]);
						}
					}else {
						answer += "R";
						right = Integer.toString(numbers[i]);
					}
			}
		} 
		return answer;
	}
}
