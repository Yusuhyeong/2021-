package com.example.os;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class WithpetRequest extends StringRequest {

    final static private String URL = "http://hek416.dothome.co.kr/Pet.php";
    private Map<String, String> map;

    public WithpetRequest(String petKinds, String petAge, String petGender, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("petKinds", petKinds);
        map.put("petAge", petAge);
        map.put("petGender", petGender);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

