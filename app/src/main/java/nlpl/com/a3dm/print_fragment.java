package nlpl.com.a3dm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/* TODO add file R/W support
    add file access permissions
 */
public class print_fragment extends Fragment {

    String dir = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dir = Environment.getExternalStorageDirectory().toString();
    }
//TODO get proper R/W code and custom file associations.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.print_fragment, container, false);
        TextView tv = rootview.findViewById(R.id.printinfo);
        tv.setText(dir);
        return rootview;
    }

}
