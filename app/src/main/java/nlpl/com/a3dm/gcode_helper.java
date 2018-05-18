package nlpl.com.a3dm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class gcode_helper extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //TODO: add proper execution
        return START_STICKY;
    }

    //Definition for Gcode commands
    //Only linear moves used G1 and homing G28
    public StringBuilder g_(int x)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('G');
        switch (x)
        {
            case 0: sb.append(0);
                break;

            case 1: sb.append(1);
                break;

            case 28: sb.append(28);
                break;

            case 29: sb.append(29);
                break;

            default:
        }
        return sb;
    }

    //for commands like M119 M84.
    public StringBuilder m_(int x, int t)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('M');
        switch (x)
        {
            case 84: sb.append(84);
                break;

            case 104: sb.append(104);
                      sb.append(" S");
                      sb.append(t);
                break;

            case 119: sb.append(119);
                break;

            default:
        }
        return sb;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
