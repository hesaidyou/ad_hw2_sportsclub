package com.example.liuyang.sportsclub_fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        email = (EditText)findViewById(R.id.email_text);
        password = (EditText)findViewById(R.id.password_text);

        Button button1 = (Button) findViewById(R.id.register_button);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //判断是否匹配
                if(email.getText().toString().length()!=0 && password.getText().toString().length()!=0){
                    String inputText = "注册成功";
                    Toast.makeText(RegisterActivity.this,inputText,Toast.LENGTH_SHORT).show();

                    Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);

                    //OBOM添加记录
                    User user = new User();
                    user.setEmail(email.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.save(new SaveListener<String>() {
                        @Override
                        public void done(String objectId,BmobException e) {
                            if(e==null){
                                Toast.makeText(RegisterActivity.this,"数据添加成功,返回objectId为：" + objectId,Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    String inputText= "请输入完整信息";
                    Toast.makeText(RegisterActivity.this,inputText,Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
