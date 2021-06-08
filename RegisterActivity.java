package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //엑티비티 시작시 처음으로 실행되는거
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //아이디값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        //et_age = (RadioGroup)findViewById(R.id.genderGroup);
        //et_age = findViewById(et_age.getCheckedRadioButtonId());
        RadioGroup et_age = (RadioGroup) findViewById(R.id.genderGroup);


        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //EditText에 현재 입력되어있는 값을 가져옴
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userEmail = et_name.getText().toString();
                //String userGender = et_age.getText().toString();
                Integer genderGroupID = et_age.getCheckedRadioButtonId();
                RadioButton radio = (RadioButton) findViewById(genderGroupID);
                String userGender = radio.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(), "회원등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                                startActivity(intent);
                            } else {//회원등록에 실패했을때
                                Toast.makeText(getApplicationContext(), "회원등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 volley를 이용해서 요청
                RegisterRequest registerRequest = new RegisterRequest(userID,userPass,userEmail, userGender, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });

    }

}