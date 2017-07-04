package com.pethoalpar.sparkjavapicturedownloadandroidclient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import pethoalpar.com.alphttpclient.HttpCall;
import pethoalpar.com.alphttpclient.HttpRequest;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) this.findViewById(R.id.imageView);

        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpCall httpCall = new HttpCall();
                httpCall.setMethodtype(HttpCall.GET);
                httpCall.setReturnTye(HttpCall.BYTE_ARRAY);
                httpCall.setUrl("http://192.168.0.103:7676/pic/2");
                new HttpRequest(){
                    @Override
                    public void onResponseByteArray(byte[] response) {
                        if(response!=null){
                            Bitmap bitmap = BitmapFactory.decodeByteArray(response, 0, response.length);
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                }.execute(httpCall);
            }
        });
    }
}
