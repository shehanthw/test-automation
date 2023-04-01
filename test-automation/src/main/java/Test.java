import java.io.File;
import java.util.ArrayList;

public class Test {

    static ArrayList<String> fileList = new ArrayList<String>();

    public static void main(String[] args) {
        String absolutePath = System.getProperty("user.dir");

        System.out.println(absolutePath);
        String dirPath = "src/test/resources/reports/";
        File folder = new File(dirPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                fileList.add(dirPath+fileName);
            }
            String result = String.join(" \n ", fileList);
        }
    }
}
