package frameworks.utils;

import java.io.File;

public class FileManager {
    public static void createPath(String path){
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
    }
}
