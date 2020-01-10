package com.example.app_deepanshu.api;

import android.text.Editable;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.app_deepanshu.Choice;
import com.example.app_deepanshu.Display_teach;
import com.example.app_deepanshu.Key_Verify;
import com.example.app_deepanshu.Module;
import com.example.app_deepanshu.Notes;
import com.example.app_deepanshu.Question;
import com.example.app_deepanshu.ReportModel;
import com.example.app_deepanshu.Schemes_Model;
import com.example.app_deepanshu.Subject;
import com.example.app_deepanshu.Subject_Model_Teach;
import com.example.app_deepanshu.Topic;
import com.example.app_deepanshu.models.DefaultResponse;
import com.example.app_deepanshu.stu_login;

import java.math.BigInteger;
import java.util.List;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "http://quiz-restapi.herokuapp.com/?format=json";
    @FormUrlEncoded

    // Student Register

    @POST("/account/student/create")
    Call<DefaultResponse> createUser(
            @Field("aadhar") String aadhar,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("father_name") String father_name,
            @Field("father_aadhar") String father_aadhar,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state
    );
    // Student Login
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<stu_login> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    //Parents Register
    @FormUrlEncoded
    @POST("/account/parent/create")
    Call<DefaultResponse> createParent(
            @Field("aadhar") String aadhar,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state
    );

    //parents login
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<stu_login> parentLogin(
            @Field("username") String username,
            @Field("password") String password
    );

//School Register
    @FormUrlEncoded
    @POST("/account/school/create")
    Call<DefaultResponse> createSchool(
            @Field("key") String key,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state,
            @Field("board") String board
    );
    //School Login

    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<stu_login> schoolLogin(
            @Field("username") String username,
            @Field("password") String password
    );
    //Teacher Verify
    @GET("/account/{key}/school")
    Call<Key_Verify> verifyTeacher(
            @Path("key") String key
    );

    @FormUrlEncoded
    @POST("/account/teacher/create")
    Call<DefaultResponse> createTeacher(
            @Field("aadhar") String aadhar,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state,
            @Field("school_id") Integer school_id
    );
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<stu_login> teacherLogin(
            @Field("username") String username,
            @Field("password") String password
    );


    @FormUrlEncoded
    @POST("/edu/TeacherDetailCreate")
    Call<DefaultResponse> addTeacherDetail(
            @Field("stream") String stream,
            @Field("batch") String batch,
            @Field("teacher") String teacher,
            @Field("clas") String clas,
            @Field("subject") String subject
    );
    @GET("/edu/TeacherDetail")
    Call<List<Subject_Model_Teach>> getSubject();

    @FormUrlEncoded
    @POST("/edu/SchoolActivityCreate")
    Call<DefaultResponse> addActivity(
            @Field("notice") String notice,
            @Field("venue") String venue,
            @Field("teacher") String teacher,
            @Field("student") String student,
            @Field("school") String school
    );

    @FormUrlEncoded
    @POST("/edu/StudentAddCreate")
    Call<DefaultResponse> addStudent(
            @Field("stream") String stream,
            @Field("batch") String batch,
            @Field("name") String name,
            @Field("father_name") String father_name,
            @Field("aadhar") String aadhar,
            @Field("clas") String clas
    );

    @FormUrlEncoded
    @POST("/edu/ReportCardCreate")
    Call<DefaultResponse> addReport(
            @Field("name") String name,
            @Field("aadhar") int aadhar,
            @Field("clas") String clas,
            @Field("subject") String subject,
            @Field("teacher_name") String teacher_name,
            @Field("validity") String validity,
            @Field("total_classes") int total_classes,
            @Field("attended_classes") int attended_classes,
            @Field("exam_name") String exam_name,
            @Field("marks") int marks,
            @Field("homework_number") Integer homework_number,
            @Field("learning") boolean learning,
            @Field("behaviour") String behaviour,
            @Field("sports") String sports,
            @Field("extra_act") String extra_act,
            @Field("moral_edu") String moral_edu,
            @Field("concentration") String concentration,
            @Field("suggestions") String suggestions
    );

    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @GET("module")
    Call<List<Module>> getModules(@Query("search") int id);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @GET("/")
    Call<List<com.example.app_deepanshu.Subject>> getSubjects();
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @GET("topic")
    Call<List<Topic>> getTopics(@Query("search") int id);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @GET("question")
    Call<List<Question>> getQuestions(@Query("search") int id);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @GET("choice")
    Call<List<Choice>> getChoices(@Query("search") int id);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @GET("edu")
    Call<List<Notes>> getNotes(@Query("search") int id);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @POST("SubjectCreate")
    Call<Subject> postSubject(@Body Subject subject);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @POST("module/ModuleCreate")
    Call<Module> postModule(@Body Module module);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @POST("topic/TopicCreate")
    Call<Topic> postTopic(@Body Topic topic);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @POST("question/QuestionCreate")
    Call<Question> postQuestion(@Body Question question);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @POST("choice/ChoiceCreate")
    Call<Choice> postChoice(@Body Choice choice);
    @Headers("Authorization:token 45b0683fedb943c85ccb38d05a73a605940d23e0")
    @Multipart
    @POST("edu/NoteCreate")
    Call<Notes> uploadNotes(@Part MultipartBody.Part file,
                            @Part("module") Integer module);

    @GET("account/teacher")
    Call<List<Display_teach>> getTeachers();

    @GET("/edu/ReportCardList")
    Call<List<ReportModel>> getReport();

    @GET("/scheme")
    Call<List<Schemes_Model>> getSchemes();





}
