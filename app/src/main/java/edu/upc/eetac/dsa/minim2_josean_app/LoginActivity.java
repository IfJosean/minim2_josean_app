package edu.upc.eetac.dsa.minim2_josean_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import edu.upc.eetac.dsa.minim2_josean_app.Controller.ApiAdapter;
import edu.upc.eetac.dsa.minim2_josean_app.Model.Model.Main.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Josean on 18/12/2017.
 */

public class LoginActivity extends Activity implements View.OnClickListener {

    private String username;
    private String password;
    protected static User user;
    protected static EditText usernameText;
    protected static EditText passwordText;
    private Button loginButton;
    protected Intent intent;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        intent = new Intent(getBaseContext(), MainActivity.class);
    }
    @Override
    public void onClick(View view) {
        if (usernameText.getText().length() != 0 && passwordText.getText().length() != 0) {
            username = usernameText.getText().toString();
            password = passwordText.getText().toString();
            getUserLogin(username,password);
        }
    }

    private void getUserLogin(String username, String password) {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(10);
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        Call<User> call = ApiAdapter.getApiService("http://10.0.2.2:8080/talesofeetac/db/").getUserLoginService(u);
        call.enqueue(new GetUserLoginCallback());
    }


    private class GetUserLoginCallback implements Callback<User> {
        @Override
        public void onResponse(Call<User> call, Response<User> response) {
            progressBar.setProgress(20);
            Toast.makeText(getBaseContext(), "We've got connection!", Toast.LENGTH_SHORT).show();
            User user = response.body();
            progressBar.setProgress(30);
            intent.putExtra("data", user);
        }

        @Override
        public void onFailure(Call<User> call, Throwable t) {

        }
    }

}
