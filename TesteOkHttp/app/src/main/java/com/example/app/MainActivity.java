package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.app.model.Produto;
import com.example.app.model.QuestionarioPergunta;
import com.example.app.model.ResultCommunicVM;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

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

                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .build();

                Request.Builder builder = new Request.Builder();
                builder.url(urlGet);
                builder.get();
                //builder.post();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(mediaType, "json");

                Request request = builder.build();
                client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String jsonResposta = response.body().string();
                    Gson gson = new Gson();
                    entity = gson.fromJson(jsonResposta, ResultCommunicVM.class);
                }});

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