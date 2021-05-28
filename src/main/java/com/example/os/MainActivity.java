package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private GpsTracker gpsTracker;
    private MapReverseGeoCoder reverseGeoCoder;
    String Sido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //    getHashKey();

        //    MapView mapView = new MapView(this);

        //    RelativeLayout mapviewContainer = (RelativeLayout) findViewById(R.id.MapView);
        //    mapviewContainer.addView(mapView);


        StrictMode.enableDefaults();

        TextView textView1 = (TextView) findViewById(R.id.textView);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);

        //TextView status1 = (TextView) findViewById(R.id.result);
        //Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        TextView time[] = new TextView[14];
        TextView tmp[] = new TextView[14];
        ImageView sky_img[] = new ImageView[14];
        TextView hm[] = new TextView[14];
        TextView rp[] = new TextView[14];
        TextView rm[] = new TextView[14];
        TextView ws[] = new TextView[14];
        TextView anit[] = new TextView[4];
        TextView anih[] = new TextView[4];

        time[0] = (TextView) findViewById(R.id.Time1);
        time[1] = (TextView) findViewById(R.id.Time2);
        time[2] = (TextView) findViewById(R.id.Time3);
        time[3] = (TextView) findViewById(R.id.Time4);
        time[4] = (TextView) findViewById(R.id.Time5);
        time[5] = (TextView) findViewById(R.id.Time6);
        time[6] = (TextView) findViewById(R.id.Time7);
        time[7] = (TextView) findViewById(R.id.Time8);
        time[8] = (TextView) findViewById(R.id.Time9);
        time[9] = (TextView) findViewById(R.id.Time10);
        time[10] = (TextView) findViewById(R.id.Time11);
        time[11] = (TextView) findViewById(R.id.Time12);
        time[12] = (TextView) findViewById(R.id.Time13);
        time[13] = (TextView) findViewById(R.id.Time14);
        tmp[0] = (TextView) findViewById(R.id.tmp1);
        tmp[1] = (TextView) findViewById(R.id.tmp2);
        tmp[2] = (TextView) findViewById(R.id.tmp3);
        tmp[3] = (TextView) findViewById(R.id.tmp4);
        tmp[4] = (TextView) findViewById(R.id.tmp5);
        tmp[5] = (TextView) findViewById(R.id.tmp6);
        tmp[6] = (TextView) findViewById(R.id.tmp7);
        tmp[7] = (TextView) findViewById(R.id.tmp8);
        tmp[8] = (TextView) findViewById(R.id.tmp9);
        tmp[9] = (TextView) findViewById(R.id.tmp10);
        tmp[10] = (TextView) findViewById(R.id.tmp11);
        tmp[11] = (TextView) findViewById(R.id.tmp12);
        tmp[12] = (TextView) findViewById(R.id.tmp13);
        tmp[13] = (TextView) findViewById(R.id.tmp14);
        sky_img[0] = (ImageView) findViewById(R.id.SKY1);
        sky_img[1] = (ImageView) findViewById(R.id.SKY2);
        sky_img[2] = (ImageView) findViewById(R.id.SKY3);
        sky_img[3] = (ImageView) findViewById(R.id.SKY4);
        sky_img[4] = (ImageView) findViewById(R.id.SKY5);
        sky_img[5] = (ImageView) findViewById(R.id.SKY6);
        sky_img[6] = (ImageView) findViewById(R.id.SKY7);
        sky_img[7] = (ImageView) findViewById(R.id.SKY8);
        sky_img[8] = (ImageView) findViewById(R.id.SKY9);
        sky_img[9] = (ImageView) findViewById(R.id.SKY10);
        sky_img[10] = (ImageView) findViewById(R.id.SKY11);
        sky_img[11] = (ImageView) findViewById(R.id.SKY12);
        sky_img[12] = (ImageView) findViewById(R.id.SKY13);
        sky_img[13] = (ImageView) findViewById(R.id.SKY14);
        hm[0] = (TextView) findViewById(R.id.hm1);
        hm[1] = (TextView) findViewById(R.id.hm2);
        hm[2] = (TextView) findViewById(R.id.hm3);
        hm[3] = (TextView) findViewById(R.id.hm4);
        hm[4] = (TextView) findViewById(R.id.hm5);
        hm[5] = (TextView) findViewById(R.id.hm6);
        hm[6] = (TextView) findViewById(R.id.hm7);
        hm[7] = (TextView) findViewById(R.id.hm8);
        hm[8] = (TextView) findViewById(R.id.hm9);
        hm[9] = (TextView) findViewById(R.id.hm10);
        hm[10] = (TextView) findViewById(R.id.hm11);
        hm[11] = (TextView) findViewById(R.id.hm12);
        hm[12] = (TextView) findViewById(R.id.hm13);
        hm[13] = (TextView) findViewById(R.id.hm14);
        rp[0] = (TextView) findViewById(R.id.RP1);
        rp[1] = (TextView) findViewById(R.id.RP2);
        rp[2] = (TextView) findViewById(R.id.RP3);
        rp[3] = (TextView) findViewById(R.id.RP4);
        rp[4] = (TextView) findViewById(R.id.RP5);
        rp[5] = (TextView) findViewById(R.id.RP6);
        rp[6] = (TextView) findViewById(R.id.RP7);
        rp[7] = (TextView) findViewById(R.id.RP8);
        rp[8] = (TextView) findViewById(R.id.RP9);
        rp[9] = (TextView) findViewById(R.id.RP10);
        rp[10] = (TextView) findViewById(R.id.RP11);
        rp[11] = (TextView) findViewById(R.id.RP12);
        rp[12] = (TextView) findViewById(R.id.RP13);
        rp[13] = (TextView) findViewById(R.id.RP14);
        rm[0] = (TextView) findViewById(R.id.RM1);
        rm[1] = (TextView) findViewById(R.id.RM2);
        rm[2] = (TextView) findViewById(R.id.RM3);
        rm[3] = (TextView) findViewById(R.id.RM4);
        rm[4] = (TextView) findViewById(R.id.RM5);
        rm[5] = (TextView) findViewById(R.id.RM6);
        rm[6] = (TextView) findViewById(R.id.RM7);
        rm[7] = (TextView) findViewById(R.id.RM8);
        rm[8] = (TextView) findViewById(R.id.RM9);
        rm[9] = (TextView) findViewById(R.id.RM10);
        rm[10] = (TextView) findViewById(R.id.RM11);
        rm[11] = (TextView) findViewById(R.id.RM12);
        rm[12] = (TextView) findViewById(R.id.RM13);
        rm[13] = (TextView) findViewById(R.id.RM14);
        ws[0] = (TextView) findViewById(R.id.WS1);
        ws[1] = (TextView) findViewById(R.id.WS2);
        ws[2] = (TextView) findViewById(R.id.WS3);
        ws[3] = (TextView) findViewById(R.id.WS4);
        ws[4] = (TextView) findViewById(R.id.WS5);
        ws[5] = (TextView) findViewById(R.id.WS6);
        ws[6] = (TextView) findViewById(R.id.WS7);
        ws[7] = (TextView) findViewById(R.id.WS8);
        ws[8] = (TextView) findViewById(R.id.WS9);
        ws[9] = (TextView) findViewById(R.id.WS10);
        ws[10] = (TextView) findViewById(R.id.WS11);
        ws[11] = (TextView) findViewById(R.id.WS12);
        ws[12] = (TextView) findViewById(R.id.WS13);
        ws[13] = (TextView) findViewById(R.id.WS14);
        anit[0] = (TextView) findViewById(R.id.dogt);
        anit[1] = (TextView) findViewById(R.id.catt);
        anit[2] = (TextView) findViewById(R.id.rabt);
        anit[3] = (TextView) findViewById(R.id.alit);
        anih[0] = (TextView) findViewById(R.id.dogh);
        anih[1] = (TextView) findViewById(R.id.cath);
        anih[2] = (TextView) findViewById(R.id.rabh);
        anih[3] = (TextView) findViewById(R.id.alih);


        gpsTracker = new GpsTracker(MainActivity.this);

        int Date_int, Date_end;
        int Counting = 0;
        int Exception_Today, Exception_Hour;
        int latitude_int, longitude_int;
        int Temp;
        int NowCount = 1;

        double latitude = gpsTracker.getLatitude();
        double longitude = gpsTracker.getLongitude();


        boolean IsCategory = false, IsfcstValue = false, IsfcstDate = false, IsfcstTime = false;


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HHmm");
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MM");
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("dd");
        SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("HH");
        SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat("mm");

        String today = simpleDateFormat.format(System.currentTimeMillis());
        String realtime = simpleDateFormat2.format(System.currentTimeMillis());
        String Month = simpleDateFormat3.format(System.currentTimeMillis());
        String Day = simpleDateFormat4.format(System.currentTimeMillis());
        String Hour = simpleDateFormat5.format(System.currentTimeMillis());
        String Min = simpleDateFormat6.format(System.currentTimeMillis());

        String Temp_Cat = null, Temp_Val = null, Temp_Date = null, Temp_Time = null;
        String Time = "0200";
        String NowTime, today_1 = today;
        String Location = null;

        String[] Rain_Rate = new String[14];
        String[] Rain_Type = new String[14];
        String[] Humadity = new String[14];
        String[] SKY = new String[14];
        String[] Temp_3 = new String[14];
        String[] Wind_Speed = new String[14];
        String[] fcstDate = new String[14];
        String[] fcstTime = new String[14];
        String[] R06 = new String[14];
        String[] Pms = new String[6];


        Date_int = Integer.parseInt(String.valueOf(today));
        Date_end = Date_int + 3;
        latitude_int = (int) Math.round(latitude);
        longitude_int = (int) Math.round(longitude);

        Exception_Today = Integer.parseInt(today);
        Exception_Hour = Integer.parseInt(realtime);
        Temp = Exception_Hour;

        if(Exception_Hour >= 0 && Exception_Hour <= 205){
            Exception_Today = Exception_Today - 1;
            today = Integer.toString(Exception_Today);
            Time = "2000";
        }

        if(Time == "2000") {
            NowTime = "0000";
        } else {
            int Temp2 = Temp % 300;
            Temp = Temp - Temp2;
            if(Temp < 999) NowTime = "0" + Integer.toString(Temp);
            else NowTime = Integer.toString(Temp);
        }

        /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GPSActivity.class);
                startActivity(intent);
            }
        });
        */


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpsTracker = new GpsTracker(MainActivity.this);
                double latitude = gpsTracker.getLatitude();
                double longitude = gpsTracker.getLongitude();

                //Toast.makeText(MainActivity.this, "현재위치 \n위도 " + latitude + "\n경도 " + longitude, Toast.LENGTH_LONG).show();
                reverseGeoCoder.startFindingAddress();
                //Toast.makeText(MainActivity.this, "")
            }
        });

        // GPS TEST

        // private void Get
        reverseGeoCoder = new MapReverseGeoCoder("b745f2abe75d96c02303a87d13413663", MapPoint.mapPointWithGeoCoord(latitude, longitude), new MapReverseGeoCoder.ReverseGeoCodingResultListener() {
            String address1;
            @Override
            public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder mapReverseGeoCoder, String s) {
                //Toast.makeText(MainActivity.this, Address, Toast.LENGTH_SHORT).show();
                String[] split = s.split(" ");
                final String mySido = split[0];
                final String myGunGu = split[1];
                address1 = s;

                //Toast.makeText(MainActivity.this, mySido, Toast.LENGTH_SHORT).show();
                textView1.setText(mySido  + " " + myGunGu);
                Sido = textView1.getText().toString();
            }

            @Override
            public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder mapReverseGeoCoder) {
                Toast.makeText(MainActivity.this, "위치 정보 확인 불가, 네트워크를 확인해 주세요", Toast.LENGTH_SHORT).show();
            }

        }, MainActivity.this);

        reverseGeoCoder.startFindingAddress();

        try {

            URL url = new URL("http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?"
                    + "serviceKey=p46H1V3Abg3ygD36c7sOWEmw8Tn9Am9SDuYngAkwpdqxxaMT6%2BeNOt0KpqEw7pGSYB71xZ3nSTcsD6MXxM4D0w%3D%3D"
                    + "&pageNo=1&numOfRows=255&dataType=XML&base_date="
                    + today
                    + "&base_time="
                    + Time
                    + "&nx="
                    + latitude_int
                    + "&ny="
                    + longitude_int
            );

            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();    // 파싱 시작

            while (parserEvent != XmlPullParser.END_DOCUMENT) {  // 문서 끝까지 파싱할 때
                switch (parserEvent) {
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("category")) {
                            IsCategory = true;
                        }
                        if (parser.getName().equals("fcstValue")) {
                            IsfcstValue = true;
                        }
                        if (parser.getName().equals("fcstDate")) {
                            IsfcstDate = true;
                        }
                        if (parser.getName().equals("fcstTime")) {
                            IsfcstTime = true;
                        }
                        if (parser.getName().equals("message")) {
                            //    status1.setText(status1.getText() + " Error");
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if (IsCategory) {
                            Temp_Cat = parser.getText();
                            IsCategory = false;
                        }
                        if (IsfcstValue) {
                            Temp_Val = parser.getText();
                            IsfcstValue = false;
                        }
                        if (IsfcstDate) {
                            Temp_Date = parser.getText();
                            IsfcstDate = false;
                        }
                        if (IsfcstTime) {
                            Temp_Time = parser.getText();
                            IsfcstTime = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {

                            if (Temp_Cat.equals("POP")) {
                                Rain_Rate[Counting] = Temp_Val;
                                fcstDate[Counting] = Temp_Date;
                                fcstTime[Counting] = Temp_Time;
                            }
                            if (Temp_Cat.equals("PTY")) {
                                Rain_Type[Counting] = Temp_Val;
                            }
                            if (Temp_Cat.equals("REH")) {
                                Humadity[Counting] = Temp_Val;
                            }
                            if (Temp_Cat.equals("SKY")) {
                                SKY[Counting] = Temp_Val;
                            }
                            if (Temp_Cat.equals("T3H")) {
                                Temp_3[Counting] = Temp_Val;
                            }
                            if (Temp_Cat.equals("R06")) {
                                R06[Counting] = Temp_Val;
                            }
                            if (Temp_Cat.equals("WSD")) {
                                Wind_Speed[Counting] = Temp_Val;
                                if (Temp_Date.equals(today_1) && Temp_Time.equals(NowTime))
                                    NowCount = Counting;
                                Counting = Counting + 1;
                            }

                            // status1.setText(status1.getText() + "Temp_Cat = " + Temp_Cat + "\nTemp_Val = " + Temp_Val + "\nCounting = " + Counting + "\n");
                        }
                        break;
                    // 여기서 예보코드가 Temp_Cat에, 예보값이 Temp_Val에 저장됨
                    // 예보코드에 따라 여러 날씨 값들이 차례대로 배열에 저장됨
                    // 마지막으로 풍속이 나온다면 다음 배열로 이동
                }
                if (Counting == 14) {
                    break;
                }
                parserEvent = parser.next();
            }
        }
        catch (Exception e) {
        }


    /*
        for (int i = 0; i < 14; i++) {
            status1.setText(status1.getText() + "강수확률 = " + Rain_Rate[i] + "\n비 종류 = " + Rain_Type[i] + "\n습도 = " + Humadity[i] + "\n하늘상태 = " + SKY[i] + "\n3시간기온 = " + Temp_3[i] + "\n풍속 = " + Wind_Speed[i] + "\n");
        }
    */
        // 배열 데이터 확인

        textView2.setText(Month + "월 " + Day + "일 " + Hour + "시 " + Min + "분");
        textView3.setText(Temp_3[NowCount] + "℃");

        Temp = Integer.parseInt(Temp_3[NowCount]);

        if(Temp <= -20) textView4.setText("한파입니다!." + "\n" + "애완동물과 산책은 금물입니다.");
        else if(Temp <= 0) textView4.setText("날씨가 추워요." + "\n" + "우리 강아지가 추워해요!");
        else if(Temp <= 10) textView4.setText("방심하면 안돼요." + "\n" + "겉옷 챙겨 입으세요!");
        else if(Temp <= 20) textView4.setText("선선한 날씨에요." + "\n" + "우리 야옹이가 너무 좋아하겠어요!");
        else if(Temp <= 30) textView4.setText("더운 날씨에요." + "\n" + "반팔을 추천합니다.");
        else textView4.setText("너무 더운 날씨에요." + "\n" + "산책시엔 꼭 서늘한 곳에서 휴식하세요!");

        for(int i=0; i<14; i++){
            time[i].setText(fcstTime[i]);
            tmp[i].setText(Temp_3[i] + "°C");
            if(SKY[i].equals("1")) sky_img[i].setImageResource(R.drawable.sunnying);
            else if(SKY[i].equals("3")) sky_img[i].setImageResource(R.drawable.sc);
            else if(SKY[i].equals("4")) sky_img[i].setImageResource(R.drawable.cloudying);
            else sky_img[i].setImageResource(R.drawable.error);
            hm[i].setText(Humadity[i] + "%");
            rp[i].setText(Rain_Rate[i] + "%");
            if(R06[i] == null) rm[i].setText(" ");
            else rm[i].setText(R06[i] + "mm");
            ws[i].setText(Wind_Speed[i] + "m/s");
        }

        if(Integer.parseInt(Temp_3[NowCount]) < -20) for(int i = 0; i < 4; i++) anit[i].setText("매우 나쁨");
        else if(Integer.parseInt(Temp_3[NowCount]) < -1) for(int i = 0; i < 4; i++) anit[i].setText("나쁨");
        else if(Integer.parseInt(Temp_3[NowCount]) < 10){
            anit[0].setText("서늘함");
            anit[1].setText("서늘함");
            anit[2].setText("산책에 최적");
            anit[3].setText("나쁨");
        }
        else if(Integer.parseInt(Temp_3[NowCount]) < 17) {
            anit[0].setText("산책에 최적");
            anit[1].setText("산책에 최적");
            anit[2].setText("실내 최적");
            anit[3].setText("나쁨");

        }
        else if(Integer.parseInt(Temp_3[NowCount]) < 22) {
            anit[0].setText("실내 최적");
            anit[1].setText("실내 최적");
            anit[2].setText("최적한계온도");
            anit[3].setText("서늘함");
        }
        else if(Integer.parseInt(Temp_3[NowCount]) < 25) {
            anit[0].setText("최적한계온도");
            anit[1].setText("최적한계온도");
            anit[2].setText("더움");
            anit[3].setText("실내 최적");
        }
        else if(Integer.parseInt(Temp_3[NowCount]) < 28) {
            anit[0].setText("더움");
            anit[1].setText("더움");
            anit[2].setText("매우 더움");
            anit[3].setText("최적한계온도");
        }
        else if(Integer.parseInt(Temp_3[NowCount]) < 31) {
            anit[0].setText("상당히 더움");
            anit[1].setText("상당히 더움");
            anit[2].setText("위험온도 : 호흡곤란");
            anit[3].setText("더움");
        }
        else {
            anit[0].setText("매우 더움");
            anit[1].setText("매우 더움");
            anit[2].setText("즉시 온도조절 필요");
            anit[3].setText("매우 더움");
        }

        if(Integer.parseInt(Humadity[NowCount]) < 20){
            anih[0].setText("건조함");
            anih[1].setText("건조함");
            anih[2].setText("습도조절 필요");
            anih[3].setText("위험습도, 조절 필요");
        }
        else if(Integer.parseInt(Humadity[NowCount]) < 40) {
            anih[0].setText("약간 건조함");
            anih[1].setText("약간 건조함");
            anih[2].setText("건조함");
            anih[3].setText("매우 건조함");
        }
        else if(Integer.parseInt(Humadity[NowCount]) < 60) {
            anih[0].setText("최적 습도");
            anih[1].setText("최적 습도");
            anih[2].setText("최적 습도");
            anih[3].setText("매우 건조함");
        }
        else if(Integer.parseInt(Humadity[NowCount]) < 80) {
            anih[0].setText("약간 습함");
            anih[1].setText("약간 습함");
            anih[2].setText("습함");
            anih[3].setText("약간 건조함");
        } else {
            anih[0].setText("매우 습함");
            anih[1].setText("매우 습함");
            anih[2].setText("습도조절 필요");
            anih[3].setText("최적 습도");
        }


    }

    /*
    private void getHashKey() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash key", something);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("name not found", e.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    //해쉬 키
    */

}

