package nlpl.com.a3dm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class test_frag extends Fragment {

    Spinner temp_spinn;
    int temperature_val = 0;

    //Heater switch
    Switch sw;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        temp_spinn = rootView.findViewById(R.id.temp_spinner);
        sw = rootView.findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(rootView.getContext(), "Set heater on!" + Integer.toString(temperature_val), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(rootView.getContext(), "Set heater off!" + Integer.toString(temperature_val), Toast.LENGTH_SHORT).show();
            }
        });
        temp_spinn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String res = temp_spinn.getSelectedItem().toString();
                TextView tv = rootView.findViewById(R.id.textView6);
                tv.setText(res);
                temperature_val = Integer.parseInt(res);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                temperature_val = 0;
            }
        });
        return rootView;
    }

    public void setTemp(int x, View v)
    {
        Toast.makeText(v.getContext(), String.valueOf(x), Toast.LENGTH_SHORT).show();
    }

}
