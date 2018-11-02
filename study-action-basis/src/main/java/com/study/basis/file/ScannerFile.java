package com.study.basis.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ScannerFile {
	private List<String> allFile = new ArrayList<String>(10);
	public List<String> getAllFile(String path){
		
        File f = new File(path) ;
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                String directoryPath = file.getPath();
                getAllFile(directoryPath);
            }else {
                String filePath = file.getPath();
                if (!filePath.endsWith(".md")){
                    continue;
                }
                allFile.add(filePath) ;
            }
        }
        return allFile ;
    }
}
