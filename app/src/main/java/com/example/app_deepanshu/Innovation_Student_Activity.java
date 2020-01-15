package com.example.app_deepanshu;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Innovation_Student_Activity extends AppCompatActivity {

    private long lastClickTime = 0;
    private Button btnsave;
    Button add,upload;
    String mediaPath;
    TextView str1;
    ProgressBar progressBar;
    private EditText naam,classs,section,school,district,
    state,prob_title,prob_desc,sol_title,sol_desc,technology;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovation__student_);


        naam =findViewById(R.id.named);
        classs=findViewById(R.id.classd);
        section=findViewById(R.id.section);
        school=findViewById(R.id.school);
        district=findViewById(R.id.district);
        state=findViewById(R.id.state);
        prob_title=findViewById(R.id.prb_tit);
        prob_desc=findViewById(R.id.prb_desc);
        sol_title=findViewById(R.id.sol_title);
        sol_desc=findViewById(R.id.sol_desc);
        btnsave=(Button)findViewById(R.id.button_submit);
        technology=(EditText)findViewById(R.id.tech);

        add = findViewById(R.id.add);
        upload = findViewById(R.id.upload);
        str1 = findViewById(R.id.str);
        progressBar = findViewById(R.id.progress);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (SystemClock.elapsedRealtime() - lastClickTime < 1000){
                    return;
                }

                lastClickTime = SystemClock.elapsedRealtime();
                progressBar.setVisibility(View.VISIBLE);

                // Map is used to multipart the file using okhttp3.RequestBody
                File file = new File(mediaPath);

                // Parsing any Media type file
                RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
                MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("doc", file.getName(), requestBody);

                Call<DefaultResponse> call= RetrofitClient.getInstance()
                        .getApi()
                        .add_Innov(naam.getText().toString()
                                ,classs.getText().toString()
                                ,section.getText().toString()
                                ,school.getText().toString(),
                                district.getText().toString()
                                ,state.getText().toString()
                                ,prob_title.getText().toString()
                                ,prob_desc.getText().toString()
                                ,sol_title.getText().toString()
                                ,sol_desc.getText().toString()
                                ,technology.getText().toString()
                        , fileToUpload
                        );
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse dr = response.body();
                        Toast.makeText(Innovation_Student_Activity.this,response.message(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                        Toast.makeText(Innovation_Student_Activity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {

                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Files.FileColumns.DATA};

                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                mediaPath = cursor.getString(columnIndex);
                str1.setText(mediaPath);
                // Set the Image in ImageView for Previewing the Media
                cursor.close();

            }

        }

        catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }
}
