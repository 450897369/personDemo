package person.ntl.personaldemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import person.ntl.personaldemo.activity.DialogFragmentActivity;
import person.ntl.personaldemo.activity.HorizontalListViewActivity;
import person.ntl.personaldemo.activity.TestActivity;
import person.ntl.personaldemo.activity.WebViewActivity;
import person.ntl.personaldemo.activity.YinJieActivity;
import person.ntl.personaldemo.anim.Anim1Activity;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn1:

                break;
            case R.id.btn2:
                startActivity(new Intent(this, Anim1Activity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, YinJieActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this, DialogFragmentActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(this, HorizontalListViewActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(this, TestActivity.class));
                break;
        }
    }

    public void ccc(View view) {
    }

}
