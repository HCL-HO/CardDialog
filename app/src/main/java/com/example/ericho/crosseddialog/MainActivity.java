package com.example.ericho.crosseddialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ThemeDialog dialog = new ThemeDialog(this, R.layout.activity_main, new ThemeDialog.ThemeDialogInteractor() {
            @Override
            public void setup(ThemeDialog dialog) {
                ((TextView)dialog.findViewById(R.id.goDialog)).setText("This is a dialog");
            }

            @Override
            public void onCancel(ThemeDialog dialog) {
                dialog.dismiss();
            }
        });

        findViewById(R.id.goDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
}
