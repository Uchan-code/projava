package projava;

import java.io.IOException;

public class Maze {
	//**	迷路のmethod作成
	//*		recordで迷路の型定義
	//*		mapで迷路の2次元配列を定義
	//*		初期位置とgorlを定義
	public static void main(String[] args) throws IOException{
		record Position(int x, int y) {}
		int[][] map = {
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
				{1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
				{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
				{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
				{1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
				{1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		};
		
		var current = new Position(1,1);
		var goal	= new Position(10,7);
		
		// 永続処理のfor roop
		for(;;) {
			for(int y = 0; y < map.length; y++) {
				for(int x = 0; x < map[y].length; x++) {
					if(y == current.y() && x == current.x()) {
						//	初期値から動く毎に"o""O"を切り替えたい
						//	初期の座標計が偶数であるため偶数は"o"とする
						if((y + x) %2 == 0) {
							System.out.print("o");
						}else {
							System.out.print("O");
						}
					}else if(map[y][x] == 1){
						System.out.print("*");
					}else {
						System.out.print(".");
					}
				}
				// レイアウト用の改行
				System.out.println("");
			}
			
			if(current.equals(goal)) {	//record値の参照のためequalsﾒｿｯﾄﾞ　== current.x = goal.x && current.y == goal.y
				System.out.println("GOAL!!");
				//break;
			}
			
			//	入力ｷｰの取得method
			int ch = System.in.read();
			
			var next = switch(ch) {
				case 'a' -> new Position(current.x() - 1, current.y());
				case 'w' -> new Position(current.x(), current.y() - 1);
				case 's' -> new Position(current.x(), current.y() + 1);
				case 'd' -> new Position(current.x() + 1, current.y());
				default -> current;
			};
			
			// 現在位置の上書き処理
			if(map[next.y()][next.x()] == 0) {
				current = next;
			}
			
			System.in.read();
		}
	}
}
