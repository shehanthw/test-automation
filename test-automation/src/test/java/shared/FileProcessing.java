package shared;

import java.io.File;
import java.util.ArrayList;

public class FileProcessing {

//    empty array for storing the string of report list
    ArrayList<String> fileList = new ArrayList<String>();

    public void getAllFiles(String dirPath) {
//        get absolute path up-to your project folder
        String absolutePath = System.getProperty("user.dir");

        File folder = new File(dirPath);
        File[] files = folder.listFiles();
        if (files != null) {

//            loop through all files in the directory and get file name with extensions
            for (File file : files) {
                String fileName = file.getName();
//                adding each file names to the empty array declared above
                fileList.add(dirPath+fileName);
            }
        }
    }

//   filesToString function returns a string of report list which can be used to upload multiple reports via ULP
    public String filesToString() {
        String result = String.join(" \n ", fileList);
        return result;
    }

}
