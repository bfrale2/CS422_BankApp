package edu.uic.group19.a422ndbank.MainApp.Settings;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;

import edu.uic.group19.a422ndbank.R;

public class AboutPopup {

    private Context context;

    public AboutPopup(Context context) {
        this.context = context;
    }

    public void show() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.popup_about);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button cancel = dialog.findViewById(R.id.about_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
