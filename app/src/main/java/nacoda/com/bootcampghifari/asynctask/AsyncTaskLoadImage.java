package nacoda.com.bootcampghifari.asynctask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class AsyncTaskLoadImage extends AsyncTask<String, String, Bitmap> {
    private final static String TAG = "AsyncTaskLoadImage";
    private ImageView imageView;
    private Context context;

    public AsyncTaskLoadImage(ImageView imageView, Context context) {
        this.imageView = imageView;
        this.context = context;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(params[0]);
            bitmap = BitmapFactory.decodeStream((InputStream) url.getContent());
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        BitmapDrawable ob = new BitmapDrawable(context.getResources(), bitmap);
        imageView.setBackgroundDrawable(ob);
    }
}