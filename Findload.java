package com.example.os;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.location.Location;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(
        mv = {1, 1, 16},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005??\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.??\u0006\u0002\n\u0000??\u0006\r"},
        d2 = {"Lcom/cookandroid/OS/Findload;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/cookandroid/OS/databinding/ActivityMainBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "searchKeyword", "keyword", "", "Companion", "OS.app"}
        )

public class Findload extends AppCompatActivity implements MapView.CurrentLocationEventListener, MapReverseGeoCoder.ReverseGeoCodingResultListener {

    public static final String BASE_URL = "https://dapi.kakao.com/";
    // rest API key ??????,  KakaoAK ??????
    public static final String API_KEY = "KakaoAK f7df8b025473a676fcec52e19371291f";
    public static final Findload.Companion Companion = new Findload.Companion();
    private static final String LOG_TAG = "Findload";

    private MapView mMapView;
    private GpsTracker gpsTracker;
    private RadioGroup rGroup;
    private RadioButton radio_park, radio_cafe, radio_hosptial;
    private Button searchbutton, menu;
    private EditText edit;
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_findload);

        mMapView = findViewById(R.id.map_view);
        mMapView.setCurrentLocationEventListener(this);
        mMapView.removeAllPOIItems();

        gpsTracker = new GpsTracker(Findload.this);
        double latitude = gpsTracker.getLatitude();
        double longitude = gpsTracker.getLongitude();
        String str_latitude = Double.toString(latitude);
        String str_longitude = Double.toString(longitude);

        rGroup = (RadioGroup) findViewById(R.id.Rgroup);
        radio_park = (RadioButton)findViewById(R.id.radio_park);
        radio_cafe = (RadioButton)findViewById(R.id.radio_cafe);
        radio_hosptial = (RadioButton)findViewById(R.id.radio_hosptial);
        searchbutton = (Button)findViewById(R.id.search);
        menu = (Button)findViewById(R.id.menu);
        edit = (EditText)findViewById(R.id.edit);


        if (!checkLocationServicesStatus()) {

            showDialogForLocationServiceSetting();

        }else {

            checkRunTimePermission();
        }


        // ??????
        searchbutton.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String searchword = null;
                searchword = edit.getText().toString();
                searchKeyword(searchword, str_longitude , str_latitude, mMapView);
                return false;
            }
        });

        // ????????? ??????
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (rGroup.getCheckedRadioButtonId())
                {
                    case R.id.radio_park:
                        mMapView = (MapView) findViewById(R.id.map_view);
                        searchKeyword("??????", str_longitude , str_latitude, mMapView);
                        break;
                    case R.id.radio_cafe:
                        mMapView = (MapView) findViewById(R.id.map_view);
                        searchKeyword("????????????", str_longitude , str_latitude, mMapView);
                        break;
                    case R.id.radio_hosptial:
                        mMapView = (MapView) findViewById(R.id.map_view);
                        searchKeyword("????????????", str_longitude , str_latitude, mMapView);
                        break;
                    default:
                        mMapView = (MapView) findViewById(R.id.map_view);
                }
            }
        });

        // ?????? ?????? ??????
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getApplicationContext(), MenuActivity.class);
                Findload.this.startActivity(registerIntent);
            }
        });

    }



    private final void searchKeyword(String keyword, String x, String y, MapView mapview) {
        Retrofit retrofit = (new Builder()).baseUrl("https://dapi.kakao.com/").addConverterFactory((Factory) GsonConverterFactory.create()).build();
        KakaoAPI api = (KakaoAPI) retrofit.create(KakaoAPI.class);
        // rest API key ??????,  KakaoAK ??????
        Call call = api.getSearchKeyword("KakaoAK f7df8b025473a676fcec52e19371291f", keyword , x, y);
        call.enqueue((Callback) (new Callback() {
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                ResultSearchKeyword result = (ResultSearchKeyword) response.body();
                List documents = result.getDocuments();
                add_park_marker(mapview, documents);

                Intrinsics.checkParameterIsNotNull(call, "call");
                Intrinsics.checkParameterIsNotNull(response, "response");
            }

            public void onFailure(@NotNull Call call, @NotNull Throwable t) {
                Intrinsics.checkParameterIsNotNull(call, "call");
                Intrinsics.checkParameterIsNotNull(t, "t");
                Log.w("Findload", "?????? ??????: " + t.getMessage());
            }
        }));
    }

    private void add_park_marker(MapView mMapView, List document)
    {
        MapPOIItem marker = new MapPOIItem();
        Place Park_Place;
        double latitude;
        double longitude;

        mMapView.removeAllPOIItems();

        for(int i =0; i<document.size(); i++)
        {

            Park_Place = (Place) document.get(i);
            longitude = Double.parseDouble(Park_Place.getX());
            latitude = Double.parseDouble(Park_Place.getY());
            marker.setItemName(Park_Place.getPlace_name());
            marker.setTag(i);
            marker.setMapPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude));
            marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
            mMapView.addPOIItem(marker);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff);
        mMapView.setShowCurrentLocationMarker(true);
    }

    @Metadata(
            mv = {1, 1, 16},
            bv = {1, 0, 3},
            k = 1,
            d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002??\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T??\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T??\u0006\u0002\n\u0000??\u0006\u0006"},
            d2 = {"Lcom/cookandroid/OS/Findload$Companion;", "", "()V", "API_KEY", "", "BASE_URL", "OS.app"}
    )
    public static final class Companion {
        private Companion() {
        }

    }

    // ???????????? ????????? ???????????? ???????????? ??? ??????.
    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint currentLocation, float accuracyInMeters) {
        MapPoint.GeoCoordinate mapPointGeo = currentLocation.getMapPointGeoCoord();
        Log.i(LOG_TAG, String.format("MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)", mapPointGeo.latitude, mapPointGeo.longitude, accuracyInMeters));
    }

    //????????? ??????(Heading) ???????????? ???????????? ??? ??????.
    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    //????????? ?????? ????????? ????????? ?????? ????????????.
    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    //????????? ????????? ????????? ???????????? ?????? ????????? ?????? ????????????.
    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }

    //????????? ?????? ?????? ????????????.
    @Override
    public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder mapReverseGeoCoder, String s) {
        mapReverseGeoCoder.toString();
        onFinishReverseGeoCoding(s);
    }

    // Reverse Geo-Coding ????????? ????????? ????????? ?????? ????????????.
    @Override
    public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder mapReverseGeoCoder) {
        onFinishReverseGeoCoding("Fail");
    }

    private void onFinishReverseGeoCoding(String result) {
//        Toast.makeText(LocationDemoActivity.this, "Reverse Geo-coding : " + result, Toast.LENGTH_SHORT).show();
    }


    /*
     * ActivityCompat.requestPermissions??? ????????? ????????? ????????? ????????? ???????????? ??????????????????.
     */
    @Override
    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {

        if ( permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            boolean check_result = true;

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }


            if ( check_result ) {
                Log.d("@@@", "start");
                mMapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);
            }
            else {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {

                    Toast.makeText(Findload.this, "???????????? ?????????????????????. ?????? ?????? ???????????? ???????????? ??????????????????.", Toast.LENGTH_LONG).show();
                    finish();

                }else {

                    Toast.makeText(Findload.this, "???????????? ?????????????????????. ??????(??? ??????)?????? ???????????? ???????????? ?????????. ", Toast.LENGTH_LONG).show();

                }
            }

        }
    }

    void checkRunTimePermission(){

        int hasFineLocationPermission = ContextCompat.checkSelfPermission(Findload
                        .this,
                Manifest.permission.ACCESS_FINE_LOCATION);


        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED ) {

            mMapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading);


        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(Findload.this, REQUIRED_PERMISSIONS[0])) {


                Toast.makeText(Findload.this, "??? ?????? ??????????????? ?????? ?????? ????????? ???????????????.", Toast.LENGTH_LONG).show();

                ActivityCompat.requestPermissions(Findload.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);

            } else {

                ActivityCompat.requestPermissions(Findload.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }

        }

    }

    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Findload.this);
        builder.setTitle("?????? ????????? ????????????");
        builder.setMessage("?????? ???????????? ???????????? ?????? ???????????? ???????????????.\n"
                + "?????? ????????? ???????????????????");
        builder.setCancelable(true);
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case GPS_ENABLE_REQUEST_CODE:

                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {

                        Log.d("@@@", "onActivityResult : GPS ????????? ?????????");
                        checkRunTimePermission();
                        return;
                    }
                }

                break;
        }
    }

    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

}