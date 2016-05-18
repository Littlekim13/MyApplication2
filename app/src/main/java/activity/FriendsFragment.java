package activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.piyaphorn.myapplication.R;


public class FriendsFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.fragment_friends);
        addMapFragment();*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();

        // latitude and longitude
        /*double latitude = 14.620945;
        double longitude = 104.423778;*/

        // create marker
        MarkerOptions marker = new MarkerOptions().position(new LatLng(14.620945, 104.423778)).title("โรงพยาบาลอำเภอขุนหาญ");
        MarkerOptions marker1 = new MarkerOptions().position(new LatLng(15.11544363118582, 104.32016372680664)).title("โรงพยาบาลจังหวัดศรีสะเกษ");
        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(13.608361, 100.551528)).title("โรงพยาบาลกรุงเทพพระประแดง");
        MarkerOptions marker3 = new MarkerOptions().position(new LatLng(13.7484071, 100.5835079)).title("Bangkok Hospital");
        MarkerOptions marker4 = new MarkerOptions().position(new LatLng(13.798222, 100.476772)).title("โรงพยาบาลอนันท์พัฒนา สอง");
        MarkerOptions marker5 = new MarkerOptions().position(new LatLng(12.944417, 100.887778)).title("โรงพยาบาลพัทยาอินเตอร์");
        MarkerOptions marker6 = new MarkerOptions().position(new LatLng(14.796195, 104.468972)).title("โรงพยาบาลอำเภอศรีรัตนะ");
        MarkerOptions marker7 = new MarkerOptions().position(new LatLng(19.911945, 99.829139)).title("โรงพยาบาลโอเวอร์บรู๊ค");
        MarkerOptions marker8 = new MarkerOptions().position(new LatLng(13.7659, 100.5269)).title("โรงพยาบาลรามาธิบดี");
        MarkerOptions marker9 = new MarkerOptions().position(new LatLng(13.89438889, 100.56175)).title("โรงพยาบาลมงกุฎวัฒนะ");
        MarkerOptions marker10 = new MarkerOptions().position(new LatLng(14.884586, 103.497904)).title("โรงพยาบาลรวมแพทย์ (หมออนันต์)");
        MarkerOptions marker11 = new MarkerOptions().position(new LatLng(13.78062, 100.50886)).title("โรงพยาบาลวชิรพยาบาล");
        MarkerOptions marker12 = new MarkerOptions().position(new LatLng(8.073935014, 98.863831099)).title("โรงพยาบาลกระบี่");
        MarkerOptions marker13 = new MarkerOptions().position(new LatLng(13.87854, 100.57684)).title("โรงพยาบาลจุฬาภรณ์");
        MarkerOptions marker14 = new MarkerOptions().position(new LatLng(13.975306895, 99.630975224)).title("โรงพยาบาลท่าม่วง");
        MarkerOptions marker15 = new MarkerOptions().position(new LatLng(16.756858459, 102.63077804)).title("โรงพยาบาลอุบลรัตน์");
        MarkerOptions marker16 = new MarkerOptions().position(new LatLng(12.80472856, 102.11526962)).title("โรงพยาบาลเขาคิชฌกูฏ");
        MarkerOptions marker17 = new MarkerOptions().position(new LatLng(13.502195978
                , 101.00205216                            )).title("โรงพยาบาลบางปะกง");

        // Changing marker icon
       /* marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker4.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker5.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker6.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker7.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker8.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker9.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        marker10.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));*/

        // adding marker
        googleMap.addMarker(marker);
        googleMap.addMarker(marker1);
        googleMap.addMarker(marker2);
        googleMap.addMarker(marker3);
        googleMap.addMarker(marker4);
        googleMap.addMarker(marker5);
        googleMap.addMarker(marker6);
        googleMap.addMarker(marker7);
        googleMap.addMarker(marker8);
        googleMap.addMarker(marker9);
        googleMap.addMarker(marker10);
        googleMap.addMarker(marker11);
        googleMap.addMarker(marker12);
        googleMap.addMarker(marker13);
        googleMap.addMarker(marker14);
        googleMap.addMarker(marker15);
        googleMap.addMarker(marker16);
        googleMap.addMarker(marker17);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(13.736717, 100.523186)).zoom(6).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
