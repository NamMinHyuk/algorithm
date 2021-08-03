package algorithm03;

import java.util.ArrayList;
import java.util.List;

public class algorithm03 {
	public static void main(String[] args) {
		System.out.println(solution(
				"John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker",
				"Example"));
	}

	public static List<String> solution(String S, String C) {
		String back = "@" + C.toLowerCase() + ".com>, ";
		String[] name = S.split(",");
		for (int i = 0; i < name.length; i++) {
			name[i] = name[i].trim();
			String[] arr = name[i].split("-");
			String[] arr2 = arr[0].split(" ");
			
			name[i] += " <";
			for (int j = 0; j < arr2.length - 1; j++) {
				name[i] += arr2[j].substring(0, 1).toLowerCase();
			}
			name[i] += arr2[arr2.length - 1].toLowerCase();
			if(arr.length>1) {
				name[i] += arr[1].substring(0,2).toLowerCase();	
			}
			name[i] += back;
		}
		List<String> list = new ArrayList<String>();
		for (int k = 0; k < name.length; k++) {
			String[] arr3 = name[k].split("@");
			String[] arr4 = arr3[0].split("<");
			list.add(arr4[1]);
		}
		
		for(int i=0;i<list.size();i++) {
			int x = 2;
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).equals(list.get(j))){
					 list.set(j, list.get(j) + x);
					 x++;
				}
			}
		}
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < name.length; i++) {
			String[] arr5 = name[i].split("<");
			res.add(arr5[0] + "<" + list.get(i) + back);
			System.out.print(res.get(i));
		}
		
		return res;
	}
}
