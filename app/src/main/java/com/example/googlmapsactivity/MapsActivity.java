package com.example.googlmapsactivity;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ArrayList<LatLng> lst = new ArrayList<>();
        lst.add(new LatLng(51.518302, 35.294871));

        ArrayList<String> lstStr = new ArrayList<>();
        lstStr.add("Точка");
        for(int i = 0; i<lst.size(); i++)
        {
            mMap.addMarker(new MarkerOptions().position(lst.get(i)).title(lstStr.get(i)));
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lst.get(0), 11f));
    }
}
