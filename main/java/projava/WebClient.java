package projava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// http://example.comに80番ﾎﾟｰﾄに接続して文字列を3行送信
// 取得した文字列を18行分表示

public class WebClient {
	public static void main(String[] args) throws IOException{	// IOExeption例外
		var domain = "example.com";								// 接続先のdomain
		try(var soc = new Socket(domain, 80);					// Socketｵﾌﾞｼﾞｪｸﾄ生成
			var pw = new PrintWriter(soc.getOutputStream());	
				//** 文字ｴﾝｺｰﾃﾞｨﾝｸﾞ変換のPrintWriterでOutputStream()ｵﾌﾞｼﾞｪｸﾄを変換
			var isr = new InputStreamReader(soc.getInputStream()); 
				//** InputStreamReader()でInputStream()ｵﾌﾞｼﾞｪｸﾄを変換
			var  bur = new BufferedReader(isr)){				//** BufferedReaderｵﾌﾞｼﾞｪｸﾄを生成
				pw.println("GET /index.html HTTP/1.1");			//** HTTPﾒｿｯﾄﾞ HTTPver1.1の/index.htmlをGETしている
				pw.println("Host: " + domain);					//** domain名指定
				pw.println();									//** 空行でrequest終了
				pw.flush();                                    //**　requestのsubmit
				bur.lines().limit(18).forEach(System.out::println);	// 取得した文字列をlinesﾒｿｯﾄﾞでStreamを取得してprintln
		}
	}
}
