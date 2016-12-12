package person.ntl.personaldemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import person.ntl.personaldemo.R;

public class DialogFragmentActivity extends Activity {

    Button dlgFragmentBtn;

    DlgFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        dialogFragment = new DlgFragment();
        dlgFragmentBtn = (Button) findViewById(R.id.dlgFragmentBtn);
        dlgFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFragment.show(getFragmentManager(),"");
            }
        });
    }

}
