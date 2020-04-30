package com.caowei;

import java.io.File;

/**
 * 
 * 在指定的目录查找文件
 *
 */
public class FileDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findFile(new File("D:\\java"),".jpg");
	}
	private static void findFile(File target,String ext) {
		if(target == null)return;
		if(target.isDirectory()) {
			File[] files = target.listFiles();
			if(files != null) {
				for(File f:files) {
					findFile(f,ext); //递归调用
				}
			}
		}else {
			String name = target.getName().toLowerCase();
//			System.out.println(name);
			if(name.endsWith(ext)){
				System.out.println(target.getAbsolutePath());
			}
		}
	}

}
