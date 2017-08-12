package nacoda.com.bootcampghifari.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URL;

import nacoda.com.bootcampghifari.adapters.WisataAdapter;
import nacoda.com.bootcampghifari.gson.GsonWisata;
import nacoda.com.bootcampghifari.utilities.NetworkUtils;

/**
 * Created by Mayburger on 7/27/2017.
 */

public class WisataAsyncTask extends AsyncTask<URL, Void, String> {

    private Context context;
    private GsonWisata gsonWisata;
    private RecyclerView rvWisata;
    private ImageView ivError;
    private SwipeRefreshLayout swipeRefreshWisata;

    public WisataAsyncTask(Context context, GsonWisata gsonWisata, RecyclerView rvWisata, ImageView ivError, SwipeRefreshLayout swipeRefreshWisata) {
        this.context = context;
        this.gsonWisata = gsonWisata;
        this.rvWisata = rvWisata;
        this.ivError = ivError;
        this.swipeRefreshWisata = swipeRefreshWisata;
    }


    @Override
    protected String doInBackground(URL... params) {
        URL searchUrl = params[0];
        String wisataResult = null;
        try {
            wisataResult = NetworkUtils.getResponseFromHttpUrl(searchUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wisataResult;
    }

    @Override
    protected void onPostExecute(String s) {

        if (s != null) {

            onSuccess();

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            gsonWisata = gson.fromJson(s, GsonWisata.class);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            WisataAdapter adapter = new WisataAdapter(context, gsonWisata.data);
            rvWisata.setLayoutManager(linearLayoutManager);
            rvWisata.setAdapter(adapter);

        } else {
            onError();
        }

    }

    private void onError() {
        ivError.setVisibility(View.VISIBLE);
        swipeRefreshWisata.setRefreshing(false);
    }

    private void onSuccess() {
        rvWisata.setVisibility(View.VISIBLE);
        ivError.setVisibility(View.GONE);
        swipeRefreshWisata.setRefreshing(false);
    }
}
