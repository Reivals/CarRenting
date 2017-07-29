package pdf;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Open {
	
	public static void openPdfFile(String path)
	{
		Desktop desktop = Desktop.getDesktop();
		File file = new File(path);
		try {
			desktop.open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
