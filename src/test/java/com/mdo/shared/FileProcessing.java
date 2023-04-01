package com.mdo.shared;

import java.io.File;
import java.util.ArrayList;

public class FileProcessing extends DirPathManager {

    ArrayList<String> fileList = new ArrayList<String>();

    public String filesToString() {
        File folder = new File(getReportsPath());
        File[] files = folder.listFiles();
        if (files != null) {
//            loop through all files in the directory and get file name with extensions
            for (File file : files) {
                String fileName = file.getName();
//                adding each file names to the empty array declared above
                fileList.add(getReportsPath()+fileName);
            }
        }
        String result = String.join(" \n ", fileList);
        return result;
    }

}
