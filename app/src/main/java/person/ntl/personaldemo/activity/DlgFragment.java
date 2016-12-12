package person.ntl.personaldemo.activity;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import person.ntl.personaldemo.R;

/**
 * Created by jzzb on 2016/10/19.
 */
public class DlgFragment extends DialogFragment {

    EditText editText;
    Button closeBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Window window = getDialog().getWindow();
//        window.setLayout(300,300);
        View root = inflater.inflate(R.layout.dlg_fragment_layout, ((ViewGroup) window.findViewById(android.R.id.content)), false);
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//注意此处
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = 300;
        attributes.height = 300;
        window.setAttributes(attributes);
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        editText = (EditText) root.findViewById(R.id.dlg_fragment_et);
        closeBtn = (Button) root.findViewById(R.id.dlg_fragment_btn);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DlgFragment.this.dismiss();
            }
        });

        return root;
    }
}
