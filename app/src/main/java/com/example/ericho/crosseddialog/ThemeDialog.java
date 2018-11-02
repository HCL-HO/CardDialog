package com.example.ericho.crosseddialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class ThemeDialog extends Dialog {

    private CardView container;
    private ThemeDialogInteractor interactor;
    private Context context;
    private ImageView cancelBtn;


    public ThemeDialog(@NonNull Context context, int layoutRes, ThemeDialogInteractor interactor) {
        this(context);
        this.interactor = interactor;
        this.context = context;
        setContentView(R.layout.theme_common_dialog);
        container = (CardView) findViewById(R.id.theme_dialog_container);
        initCancelBtn();
        addCustomView(layoutRes);
        interactor.setup(ThemeDialog.this);
    }

    private ThemeDialog(@NonNull Context context) {
        super(context, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
        getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.theme_dark_transparent)));
    }

    private void initCancelBtn() {
        cancelBtn = (ImageView) findViewById(R.id.theme_dialog_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interactor.onCancel(ThemeDialog.this);
            }
        });
    }

    private void addCustomView(int customView) {
        View content = LayoutInflater.from(context).inflate(
                customView, null);
        container.addView(content);
    }

    public ImageView getDefaultCancelBtn() {
        return cancelBtn;
    }

    public CardView getContainer() {
        return container;
    }

    public interface ThemeDialogInteractor {
        void setup(ThemeDialog dialog);

        void onCancel(ThemeDialog dialog);
    }

}
