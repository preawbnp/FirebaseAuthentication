package com.example.preawbnp.firebaselogin;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class ViewLocation extends AppCompatActivity {
    private Button getLocation;
    private static final int REQUEST_CODE_PERMMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    private int counter = 1;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_location);

        getLocation = (Button)findViewById(R.id.getLocation);

        try {
            if(ActivityCompat.checkSelfPermission(this, mPermission) != PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{mPermission}, REQUEST_CODE_PERMMISSION);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocation(View v){
        gps = new GPSTracker(ViewLocation.this);
        gps.getLocation();

        if(gps.isCanGetLocation()){
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            Toast.makeText(getApplicationContext(), counter + "\nCurrent location is \nLatitude : " + latitude + "\nLongitude : " + longitude, Toast.LENGTH_LONG).show();
        } else  {
            gps.showSettingsAlert();
            Toast.makeText(getApplicationContext(), "Error " , Toast.LENGTH_LONG).show();
        }
        counter++;
    }
}
