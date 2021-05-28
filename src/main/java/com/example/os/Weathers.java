package com.example.os;

public class Weathers {
    private String Rain_Rate;
    private String Rain_Type;
    private String Humidity;
    private String SKY;
    private String Temp_3;
    private String Wind_Speed;
    private String Temp_Low;
    private String Temp_High;

    public String getRain_Rate(){
        return Rain_Rate;
    }

    public String getRain_Type(){
        return Rain_Type;
    }

    public String getHumidity(){
        return Humidity;
    }

    public String getSKY(){
        return SKY;
    }

    public String getTemp_3(){
        return Temp_3;
    }

    public String getWind_Speed(){
        return Wind_Speed;
    }

    public String getTemp_Low(){
        return Temp_Low;
    }

    public String getTemp_High(){
        return Temp_High;
    }

    public void setRain_Rate(String Rate){
        Rain_Rate = Rate;
    }

    public void setRain_Type(String Type){
        Rain_Type = Type;
    }

    public void setHumidity(String Hum){
        Humidity = Hum;
    }

    public void setSKY(String S){
        SKY = S;
    }

    public void setTemp_3(String Temp){
        Temp_3 = Temp;
    }

    public void setWind_Speed(String Speed){
        Wind_Speed = Speed;
    }

    public void setTemp_Low(String Temp){
        Temp_Low = Temp;
    }

    public void setTemp_High(String Temp){
        Temp_High = Temp;
    }
}