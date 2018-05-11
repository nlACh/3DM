package nlpl.com.a3dm;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {link intro.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class intro extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rv = inflater.inflate(R.layout.fragment_intro, container, false);
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},getResources().getInteger(R.integer.STORAGE_READ_PERM));
        }
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, getResources().getInteger(R.integer.STORAGE_WRITE_PERM));
        }
        chkLocalStorage(rv);
        return rv;

    }

    // TODO: Rename method, add check for local storage
    public void chkLocalStorage(View v)
    {
        String path_to_dir = Environment.getExternalStorageDirectory().toString() + getResources().getString(R.string.local_path);
        File localDir = new File(path_to_dir);
        if (!localDir.exists())
        {
            localDir.mkdir();
        }
    }

}
