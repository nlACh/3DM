package nlpl.com.a3dm;

import android.util.Log;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class gcode_parser {

    //TODO: Add parser code to handle gcode files.
    public int main(String path) throws IOException
    {
            FileReader fr;
            File dir = new File(path);
            if (dir.exists()){
                fr = new FileReader(dir);
                return 1;
            }
            else
                return 0; //TODO: asynchronize
    }
}
