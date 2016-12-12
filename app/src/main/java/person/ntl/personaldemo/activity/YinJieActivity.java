package person.ntl.personaldemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.Random;

import person.ntl.personaldemo.R;

public class YinJieActivity extends Activity implements View.OnClickListener {

    RelativeLayout rl;

    TextView textView;
    View view1;
    View view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_jie);
        rl = (RelativeLayout) findViewById(R.id.rl);
        textView = (TextView) findViewById(R.id.text1);
        view1 = findViewById(R.id.text2);
        view2 = findViewById(R.id.text3);

        rl.setOnClickListener(this);
    }

    public void change(View view) {

        view1.setVisibility(View.GONE);
        view2.setVisibility(View.GONE);
        Random random = new Random();
        int i = random.nextInt(3);
        int y = random.nextInt(7);
        y = y+1;

        textView.setText(""+y);
        if (i == 0){
            if (y == 1 || y == 2){
                view2.setVisibility(View.VISIBLE);
            }else {

                view1.setVisibility(View.VISIBLE);
            }
        }else if (i == 1){

        }else if (i == 2){
            view2.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onClick(View v) {
        change(null);
    }
}
