package in.cdac.pamr;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DatabaseUtils;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import in.cdac.pamr.daobeans.DaoBeans;
import in.cdac.pamr.databinding.ActivityLoginBinding;

/**
 * Created by Dell1 on 21/05/2017.
 */

public class LoginActivity extends AppCompatActivity {

    TextView label;
    Button loginBtn;
    TextInputLayout userWrap;
    TextInputLayout passwrap;
    TextInputEditText editUser;
    TextInputEditText editPas;
    String uName,pasword;
    DaoBeans dao;
    HashMap<String,String>map;

    SharedPreferences preferences;

    ActivityLoginBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBinding= ActivityLoginBinding.inflate(getLayoutInflater());

        label=(TextView)findViewById(R.id.labelLogin);
        loginBtn=(Button)findViewById(R.id.loginBtn);
        userWrap=(TextInputLayout)findViewById(R.id.useWrapper);
        passwrap=(TextInputLayout)findViewById(R.id.passWraper);
        editUser =(TextInputEditText)findViewById(R.id.user);
        editPas=(TextInputEditText)findViewById(R.id.pas);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                uName=userWrap.getEditText().getText().toString();
                pasword=passwrap.getEditText().getText().toString();

                try {
                    if(uName.length()==0) {
                        showUserNameError();
                    }
                    if(pasword.length()==0) {
                        showPassError();
                    }
                    if(uName !="" && pasword !="") {
                        Log.v("in login activity",uName+pasword);
                        new LoginTaskInBackground().execute(uName, pasword);
                    }
                    Toast.makeText(LoginActivity.this,"clicked loginbtn"+uName + pasword,Toast.LENGTH_LONG).show();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                finally {

                    showError();
                }


            }
        });


    }

    private void showError(){
        userWrap.setErrorEnabled(true);
        userWrap.setError("user name is invalid");
        passwrap.setErrorEnabled(true);
        passwrap.setError("password is invalid");




    }

    private void showUserNameError()
    {
        Toast.makeText(LoginActivity.this,"user field should not blank",Toast.LENGTH_LONG).show();
        //userWrap.setErrorEnabled(true);
        //userWrap.setError("user name should not blank");
    }
    private void showPassError()
    {
        Toast.makeText(LoginActivity.this,"password field should not blank",Toast.LENGTH_LONG).show();
        //passwrap.setErrorEnabled(true);
        //passwrap.setError("password field should not blank");
    }


    private void showData()
    {

        Intent in=new Intent(LoginActivity.this,HomeActivity.class);

       // in.putExtra("user",uName);

        startActivity(in);
        finish();


    }


    class LoginTaskInBackground extends AsyncTask<String,String,String>
    {

        Context c;
        String result="";
        ProgressDialog dialog=null;
        LoginTaskInBackground() throws Exception{
            dao=new DaoBeans();
            map=new HashMap<>();

        }

        LoginTaskInBackground(Context context, String str1,String str2)
        {
            this.c=context;
            str1=uName;
            str2=pasword;


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(LoginActivity.this);
            dialog.setTitle("Authenticating.......");
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.show();

        }

        @Override
        protected String doInBackground(String... params) {

            uName=params[0];
            pasword=params[1];

            try {
                map=dao.doLogin();
                String u=map.get("LOGIN_NAME");
                String p=map.get("PW");
       //         Log.e("in background",u+p);
                if(uName.equals(u) && pasword.equals(p))
                {
                    result="success";
         //           Log.e("inBack---",uName+pasword);
                }
                else {
                    result="fail";
                }


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


         //   Log.e("result======",result);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();
             preferences=getSharedPreferences("data",Context.MODE_PRIVATE);

            if((s!="")&&(s.equals("success")))
             {

                 editUser.setText("");
                 editPas.setText("");


                 SharedPreferences.Editor editor=preferences.edit();
                  editor.putString("user",uName);
                  editor.commit();



                  showData();
            }
              else {
                showUserNameError();
                showPassError();
                showError();
             }


        }
    }



}
