package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.app.model.Produto;
import com.example.app.model.QuestionarioPergunta;
import com.example.app.model.ResultCommunicVM;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button OkHttpGet;
    Button OkHttpDelete;
    Button OkHttpPost;
    Button OkHttpUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        configuraBotao();
    }
    ResultCommunicVM<QuestionarioPergunta> entity;
    private void configuraBotao() {
        OkHttpGet = findViewById(R.id.main_button_get);
        OkHttpDelete = findViewById(R.id.main_button_delete);
        OkHttpPost = findViewById(R.id.main_button_post);
        OkHttpUpdate = findViewById(R.id.main_button_update);


        OkHttpGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlGet = "http://201.72.232.228/clientmobileapiteste/api/v1/Usuario/Perguntas/jose/";


                OkHttpClient client = new OkHttpClient(); // restante do código
                Request.Builder builder = new Request.Builder();
                builder.url(urlGet);
                builder.get();
                //builder.post();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(mediaType, "json");

                Request request = builder.build();
                try {
                    Response response = client.newCall(request).execute();
                    String jsonResposta = response.body().string();

                    Gson gson = new Gson();
                    entity = gson.fromJson(jsonResposta, ResultCommunicVM.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        OkHttpDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        OkHttpPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        OkHttpUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}