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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class test_frag extends Fragment {

    gcode_helper Gcode = new gcode_helper();
    Spinner temp_spinn;
    int temperature_val = 0;

    //Heater switch
    Switch sw;

    //now the buttons.
    ImageButton xm, xp, ym, yp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_test, container, false);

        //set handlers for the buttons.
        xm = rootView.findViewById(R.id.x_minus);
        xp = rootView.findViewById(R.id.x_plus);
        ym = rootView.findViewById(R.id.y_minus);
        yp = rootView.findViewById(R.id.y_plus);

        //spinner.
        temp_spinn = rootView.findViewById(R.id.temp_spinner);

        //Switch.
        sw = rootView.findViewById(R.id.switch1);

        //add a listener for the spinner
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(rootView.getContext(), "Set heater on!" + Integer.toString(temperature_val), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(rootView.getContext(), "Set heater off!" + Integer.toString(temperature_val), Toast.LENGTH_SHORT).show();
            }
        });
        //add a listener for the switch
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

        //TODO: add event handler for the buttons.
        return rootView;
    }

    public void setTemp(int x, View v)
    {
        Toast.makeText(v.getContext(), String.valueOf(x), Toast.LENGTH_SHORT).show();
        //TODO add temperature control.
    }

}
