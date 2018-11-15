package com.example.liuyang.sportsclub_fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bmob.initialize(this,"751b431966e46e0b43e21b7e530fe3f6");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        email = (EditText)findViewById(R.id.login_email_text);
        password = (EditText)findViewById(R.id.login_password_text);

        Button button1 = (Button) findViewById(R.id.login_button);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(email.getText().toString().length()!=0 && password.getText().toString().length()!=0){
                    BmobQuery<User> query = new BmobQuery<User>();
                    query.addWhereEqualTo("email",email.getText().toString());

                    query.findObjects(new FindListener<User>() {

                        @Override
                        public void done(List<User> list, BmobException e) {
                            if(e==null){
                                for(User user:list){
                                    if(user.getPassword().equals(password.getText().toString())){
                                        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                        Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }else{
                                Toast.makeText(LoginActivity.this,"网络错误："+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(LoginActivity.this,"请输入用户名和密码",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button button2 = (Button) findViewById(R.id.login_register_button);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}
