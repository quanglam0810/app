package activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ntd.shopping.R;

import util.CheckInternetConnection;
import util.Sever;

public class LogIn extends AppCompatActivity {
    EditText name;
    EditText password;
    TextView signin;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        name = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        signin = findViewById(R.id.signin);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
    }
    private void validate(final String usernames, String userpassword)
    {
        Log.d("user",usernames);
        Log.d("pass",userpassword);
        //final String Email = email.getText().toString().trim();
        if(usernames.length()>0&&userpassword.length()>0)
        {
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            String link = Sever.login+"?username="+usernames+"&&password="+userpassword;
            Log.d("s",link);
            StringRequest request = new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("res",response.toString());
                    if(response.equals("1"))
                    {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        MainActivity.islogin=true;
                        MainActivity.username=usernames.toString();
                    }
                    else{
                        CheckInternetConnection.ShowToast_Short(getApplicationContext(),"Sai tai khoan hoac mat khau");
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            queue.add(request);
        }
    }
}
