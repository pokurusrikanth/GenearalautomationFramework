package framework;



import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class FileUtils {

	
	public static void upload_files(String input,String opn,String srcfile) {
		Pattern capture=new Pattern(input);
		Pattern open=new Pattern(opn);
		Screen sc=new Screen();
		try {
			sc.wait(input,20);
			sc.type(input,srcfile );
			sc.click(open);
		} catch (FindFailed e) {
			
		}
	}

	public void creating_Folder_Path(String folderpath) {
		File file = new File(folderpath);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	public void delete_All_Files_In_Folder(String folderpath) {
		File file = new File(folderpath);
		File[] fileslist = file.listFiles();
		try {
			for (File eachfile : fileslist) {
				eachfile.delete();
			}
		} catch (Exception exp) {
			System.out.println("file" + file.getName() + "file not deleted");
		}

	}

	
	public void creat_New_File(String folderpath) {
		File file = new File(folderpath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static boolean is_File_Exists(String path) {
		File file = new File(path);
		return file.exists();
	}

	public void delete_File(String path) {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
