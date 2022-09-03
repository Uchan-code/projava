package projava;

public class RecLoop {

	public static void main(String[] args) {
		loop(0);	//初期値numを渡す
	}
	
	static void loop(int i) {	//iとして変数を受け取る
		if(i >= 5) {
			return ;
		}else {
			System.out.println(i);
			loop( i + 1 );
		}
	}
}
