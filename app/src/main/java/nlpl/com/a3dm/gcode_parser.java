package nlpl.com.a3dm;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class gcode_parser extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //TODO: add onStart process
        return START_STICKY;
    }
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

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }
}
