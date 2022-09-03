package projava;

import java.util.List;

// ListのforEachを行おう
public class ForEachListSample {
	
	public static void main(String[] args) {
		var strages = List.of("apple", "banana", "grape");
		
		// for文の基本構造
		for(int i = 0; i < strages.size(); i++) {
			var strage = strages.get(i);
			
			System.out.println(strage);
		}
		
		// java 5より実装された拡張 for 文
		for(var strage: strages) {
			System.out.println(strage);
		}
		
		// objectにいくつも処理を重ねたい場合はStream APIの使用
		
	}
}
