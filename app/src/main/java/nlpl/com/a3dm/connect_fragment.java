package nlpl.com.a3dm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class connect_fragment extends Fragment {

    private Spinner sp_conn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_connect, container, false);
        //populate the spinner...
        sp_conn = rootView.findViewById(R.id.spinner_conn);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.dev, android.R.layout.simple_dropdown_item_1line);
        sp_conn.setAdapter(adapter);
        return rootView;
    }

}
