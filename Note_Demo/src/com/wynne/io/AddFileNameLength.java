package com.wynne.io;
import java.io.File;

public class AddFileNameLength {
	public static void main(String[] args) {
		String filepath="C:/Users/LIWY/Desktop/CT-Revamp/Test/CSB2BEDIGroovyDevelopment/demo/WSIGTN/QA/in/";
		//1�?获�?�文件文件夹所在目录中的所有文件夹
		File directory = new File(filepath);

		//1�?获�?�文件文件夹所在目录中的所有文件夹
		File[] fileList  = directory.listFiles();
		//2�?对所有文件夹进行循环处�?�
		for(int i=0;i<fileList .length;i++){
			//得到文件
			File file=fileList[i];
			//得到文件的文件�??
			String filename=file.getName();
			//System.out.println(filename);	
			//根�?�自己的需�?对文件新的文件�??进行处�?�
			int index=0;
			if(filepath.contains("in")){
				System.out.println("in");
				index=filename.lastIndexOf('.');
			}
			else{
				index=filename.length()-9;
			}
			String font=filename.substring(0,index);
			String back=filename.substring(index, filename.length());
			System.out.println(font+"\t"+back);
			if(index<22){
				//System.out.println("excute!");
				int sub=22-index;
				for(int j=0;j<sub;j++){
					font=font+"A";
				}
			}
			//新的文件�??的命�??规则和路径
			String newfilename=filepath+"\\"+font+back;
			//这里使用的renameTo（）函数中传入的�?�数�?是完整的路径�?能�?新命�??�?功，�?�则是�?行的
			Boolean flag=file.renameTo(new File(newfilename));
		}
		//System.out.println(flag);
	}

}

