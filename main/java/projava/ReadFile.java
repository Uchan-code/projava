package projava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class ReadFile {
	public static void main(String[] args) throws IOException{
		
		try {
			// 例外が発生する可能性のある処理
			var p = Path.of("text.txra");
			String s = Files.readString(p);
			System.out.println(s);
		}catch(NoSuchFileException e){	// 例外変数
			// 例外が発生したときの処理
			System.out.println("ファイルが見つかりません :" + e.getFile());
		}
	}
}
