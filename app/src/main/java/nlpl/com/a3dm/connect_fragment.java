package nlpl.com.a3dm;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Set;


public class connect_fragment extends Fragment {

    private Spinner sp_conn;
    private BluetoothAdapter ba; //BLUETOOTH
    private Set pairedDevices; //BLUETOOTH
    private RadioGroup rg;
    private RadioButton rb;
    private Button bn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_connect, container, false);
        //radio group
        rg = rootView.findViewById(R.id.radioGroup);
        bn = rootView.findViewById(R.id.use);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId();
                //rb = rootView.findViewById(id);
                spinnerInflater(rootView, id);
            }
        });
        //populate the spinner...
        sp_conn = rootView.findViewById(R.id.spinner_conn);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(), R.array.dev, android.R.layout.simple_dropdown_item_1line);
        sp_conn.setAdapter(adapter);
        return rootView;
    }

    public void spinnerInflater(View v, int id)
    {
        /**TODO-- add BT functionality
        TODO-- add USB support
        */

        if(id == R.id.BT)
        {
            Toast.makeText(v.getContext(), "BT selected", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(v.getContext(), "USB selected", Toast.LENGTH_SHORT).show();
        }
    }

}
