package nlpl.com.a3dm;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/* TODO add file R/W support
    add file access permissions
 */
public class print_fragment extends Fragment {

    Spinner sp;
    String dir = null;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> arr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dir = Environment.getExternalStorageDirectory().toString() + getResources().getString(R.string.local_path);
        File localStorage = new File(dir);
        File[] files = localStorage.listFiles();
        if(files.length>0){
            for(int i=0; i<files.length; i++)
                list.add(files[i].getName());
        }
    }

    //TODO get proper R/W code and custom file associations.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.print_fragment, container, false);
        sp = rootview.findViewById(R.id.spinner2);
        arr = new ArrayAdapter<String>(rootview.getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        sp.setAdapter(arr);
        return rootview;
    }

}
