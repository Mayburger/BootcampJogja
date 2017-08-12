package nacoda.com.bootcampghifari.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mayburger on 8/10/2017.
 */

public class Fonts {

    public static void RobotoRegularInputLayout(Context context, TextInputLayout tilData) {
        Typeface Roboto = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_regular.ttf");
        tilData.setTypeface(Roboto);
    }

    public static void RobotoLight(Context context, TextView tvData) {
        Typeface Roboto = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_light.ttf");
        tvData.setTypeface(Roboto);
    }

    public static void Montez(Context context, TextView tvData) {
        Typeface Roboto = Typeface.createFromAsset(context.getAssets(), "fonts/montez.ttf");
        tvData.setTypeface(Roboto);
    }

    public static void RobotoRegularButton(Context context, Button btnData) {
        Typeface RobotoRegularButton = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_regular.ttf");
        btnData.setTypeface(RobotoRegularButton);
    }

    public static void RobotoRegular(Context context, TextView tvData) {
        Typeface RobotoRegular = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_regular.ttf");
        tvData.setTypeface(RobotoRegular);
    }
}
