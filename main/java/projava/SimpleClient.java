package projava;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

//needs
//SimpleServerにてSimpleClientから出力された情報を取得表示したい

public class SimpleClient {
	public static void main(String[] Args)	//	mainﾒｿｯﾄﾞ、cmdLine引数を受け取ったり受け取らなかったり
	throws IOException {					//	IOexception(i/oに関する例外)を無視		
		
		try {	// ｻｰﾊﾞｰが見つからない時の例外処理TRY	
			try(	// Socketを閉じたいTRY
				var soc = new Socket("localhost",1600);	//**	localhost(このPC)の1600番指定
				OutputStream is = soc.getOutputStream();	//** OutputStreamの型宣言。OutputStreamで生成された出力ｵﾌﾞｼﾞｪｸﾄを格納
			){
				is.write(234);
			}
		}catch(ConnectException soc) {
			System.out.println("NOT DEFIND SERVER");
			return ;
		}
	}
}


//ﾁｬﾚﾝｼﾞ：SimpleClientのみ実行時の例外処理ConnectException