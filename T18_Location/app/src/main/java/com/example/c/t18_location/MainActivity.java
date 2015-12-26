package com.example.c.t18_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String str = "";

    Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providers = manager.getAllProviders();

        final TextView textView = (TextView) findViewById(R.id.textView);


        for (int i = 0; i < providers.size(); i++) {
            str += "provider " + providers.get(i) + " state : " +
                    manager.isProviderEnabled(providers.get(i)) + "\n";
        }

        textView.setText(str);


        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String s = "lat : " + location.getLatitude() +
                        " log : " + location.getLongitude() +
                        " alt : " + location.getAltitude() + "\n";

                textView.append(s);

                List<Address> list = null;
                try {
                    list = geocoder.getFromLocation( location.getLatitude(),
                            location.getLongitude(), 10);
                    Address address = list.get(0);
                    textView.append(address.getAddressLine(0));
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);


        geocoder = new Geocoder(this);
        ImageButton btnGeoCoding = (ImageButton)findViewById(R.id.btnGeocoding);
        btnGeoCoding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strAddress = ((EditText)findViewById(R.id.editAddress)).getText().toString();
                try {
                    List<Address> list = geocoder.getFromLocationName(strAddress, 10);
                    Address address = list.get(0);

                    ((EditText)findViewById(R.id.editLongitutde)).setText(""+address.getLongitude());
                    ((EditText)findViewById(R.id.editLatitude)).setText(""+address.getLatitude());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ImageButton btnReverseGeocoding = (ImageButton)findViewById(R.id.btnReverseGeocoding);
        btnReverseGeocoding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strLat = ((EditText)findViewById(R.id.editLatitude)).getText().toString();
                String strLog = ((EditText)findViewById(R.id.editLongitutde)).getText().toString();

                try {
                    List<Address> list = geocoder.getFromLocation( Double.parseDouble(strLat),
                            Double.parseDouble(strLog), 10);
                    Address address = list.get(0);

                    ((EditText)findViewById(R.id.editAddress)).setText(address.getAddressLine(0));
                    textView.setText(address.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //manager.removeUpdates(listener);
    }
}
