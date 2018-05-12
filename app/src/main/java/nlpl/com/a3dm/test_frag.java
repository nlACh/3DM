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


public class test_frag extends Fragment {

    Spinner temperature;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        temperature = rootView.findViewById(R.id.temp_spinner);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, R.id.temp_spinner);
        temperature.setAdapter(arrayAdapter);
        return rootView;
    }

}
