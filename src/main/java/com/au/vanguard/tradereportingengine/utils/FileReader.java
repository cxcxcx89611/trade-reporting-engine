package com.au.vanguard.tradereportingengine.utils;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> readFile(String filePath) throws Exception {
        List<String> fileStringList = new ArrayList<String>();
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileStringList.add(FileUtil.readAsString(file));
            }
        }
        return fileStringList;
    }
}
