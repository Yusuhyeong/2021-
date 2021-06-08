package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Withpet extends AppCompatActivity {

    private EditText et_pKinds, et_pAge;
    RadioGroup PgGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //엑티비티 시작시 처음으로 실행되는거
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withpet);

        //아이디값 찾아주기
        et_pKinds = findViewById(R.id.et_pKinds);
        et_pAge = findViewById(R.id.et_pAge);
        PgGroup = (RadioGroup) findViewById(R.id.PgGroup);


        Button btn_register = findViewById(R.id.btn_pregister);
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //EditText에 현재 입력되어있는 값을 가져옴
                String petKinds = et_pKinds.getText().toString();
                String petAge = et_pAge.getText().toString();
                String petGender = PgGroup.getCheckedRadioButtonId()+"";


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(), "반려동물 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Withpet.this,MenuActivity.class);
                                startActivity(intent);
                            } else {//회원등록에 실패했을때
                                Toast.makeText(getApplicationContext(), "반려동물 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 volley를 이용해서 요청
                WithpetRequest WithpetRequest= new WithpetRequest(petAge,petGender,petKinds, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Withpet.this);
                queue.add(WithpetRequest);
            }
        });

    }
}