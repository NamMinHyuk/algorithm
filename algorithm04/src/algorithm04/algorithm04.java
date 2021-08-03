package algorithm04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class algorithm04 {

	public static void main(String[] args) throws IOException {
		System.out.println(solution("123"));
	}
	public static String solution(String S) throws IOException {
		File file = new File("src/algorithm04/input01.txt");
		FileReader filereader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(filereader);
		List<String> list = new ArrayList<String>();
		String line = "";
		
		while((line = buffer.readLine()) != null) {
			list.add(line);
		}
		
		buffer.close();
		list.remove(0);
		list.remove(list.size()-1);
		List<String> year = new ArrayList<String>();
		List<String> month = new ArrayList<String>();
		List<String> date = new ArrayList<String>();
		int empty = 0;
		for(int i=0;i<list.size();i++) {
			String[] arr = list.get(i).split("  ");
			String tmp = arr[1].trim();
			System.out.println(tmp);
			for(int j=0;j<tmp.length();j++) {
				if(tmp.charAt(j)== 'w') {
					String[] day = tmp.split(" ");
					year.add(day[3]);
					month.add(day[2]);
					date.add(day[1]);
					empty++;
				}
			}
		}
		int max = 0;
		int idx = 0;
		for(int i=0;i<year.size();i++) {
			if(max < Integer.parseInt(year.get(i))){
				max = Integer.parseInt(year.get(i));
				idx = i;
			}else if(max == Integer.parseInt(year.get(i))){
				Date day = new Date(date.get(i)+month.get(i)+date.get(i));
				System.out.println(day.getMonth());
			}
		}
		String res = "";
		if(empty > 0) {
			res = date.get(idx) + " " + month.get(idx) + " " + year.get(idx);
		}else {
			res = "NO FILES";
		}
		
		return res;
	}
}
