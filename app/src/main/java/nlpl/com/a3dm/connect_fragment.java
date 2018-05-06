package nlpl.com.a3dm;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;


public class connect_fragment extends Fragment {

    private Spinner sp_conn;
    private BluetoothAdapter ba; //BLUETOOTH
    private Set<BluetoothDevice> pairedDevices; //BLUETOOTH
    private RadioGroup rg;
    private RadioButton rb;
    private Button bn;
    private BluetoothDevice bd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //check if bluetooth is working or not
        ba = BluetoothAdapter.getDefaultAdapter();
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
                spinnerInflater(rootView, id);
            }
        });

        return rootView;
    }

    public void spinnerInflater(View v, int id)
    {
        /**TODO-- add BT functionality
        TODO-- add USB support
        */
        sp_conn = v.findViewById(R.id.spinner_conn);
        if(id == R.id.BT)
        {
            if (ba == null){
                Toast.makeText(v.getContext(), "Bluetooth not supported!", Toast.LENGTH_LONG).show();
            }

            if (ba.isEnabled())
            {
                populateBT(v);
            }
            else {
                Intent bt_ON = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(bt_ON, 1);
            }
        }
        else {
            Toast.makeText(v.getContext(), "USB selected", Toast.LENGTH_SHORT).show();
        }
    }

    public void populateBT(View v)
    {
        pairedDevices = ba.getBondedDevices();
        ArrayList<String> list = new ArrayList<String>();
        if (pairedDevices.size()>0)
        {
            for (BluetoothDevice bd:pairedDevices)
                list.add(bd.getAddress()+'\t'+bd.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_dropdown_item, list);
        sp_conn.setAdapter(adapter);
    }

}
