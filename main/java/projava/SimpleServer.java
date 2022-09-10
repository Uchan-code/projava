package projava;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// needs
// SimpleServerにてSimpleClientから出力された情報を取得表示したい

public class SimpleServer {

	public static void main(String[] Args) 		//	mainﾒｿｯﾄﾞ cmdLine引数を受け取ったり受け取らなかったりする。
			throws IOException {				//	例外：IOExceptionを無視する
												//	※i/oの例外、入出力ﾌｧｲﾙが存在しないとでる。
		var server = new ServerSocket(1600);	//**	serverの立上げ、java.net.ServerSocketのimport要※()内はﾎﾟｰﾄ番号
		System.out.println("Waiting...");

		try(Socket soc = server.accept();){			//**	socketの型宣言、accept()で生成されたSocketｵﾌﾞｼﾞｪｸﾄ
													//**	※ServerSocket()とaccept()は実際のﾎﾟｰﾄ番号の指定に対して(錠)、ｸﾗｲｱﾝﾄからの待ち受け(鍵穴)
			System.out.println("connect form" + soc.getInetAddress());
			InputStream input = soc.getInputStream();	//	InputStreamﾒｿｯﾄﾞ、必要なﾌｧｲﾙを順次読み込む
			System.out.println(input.read());			
		}
	}
}


//	try ( resorces※closeが必要なｵﾌﾞｼﾞｪｸﾄ ){ 処理 }
//	Socketﾎﾟｰﾄ指定で誤りがあるとoutput.closeが呼び出されなくなってしまうためtry-with-resorces文を活用