package nacoda.com.bootcampghifari;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nacoda.com.bootcampghifari.asynctask.WisataAsyncTask;
import nacoda.com.bootcampghifari.fonts.Fonts;
import nacoda.com.bootcampghifari.gson.GsonWisata;
import nacoda.com.bootcampghifari.utilities.NetworkUtils;

public class PariwisataActivity extends AppCompatActivity {

    @InjectView(R.id.tvTitlePariwisata)
    TextView tvTitlePariwisata;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.rvWisata)
    RecyclerView rvWisata;
    @InjectView(R.id.ivError)
    ImageView ivError;
    @InjectView(R.id.swipeRefreshWisata)
    SwipeRefreshLayout swipeRefreshWisata;
    GsonWisata gsonWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisata);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        swipeRefreshWisata.setColorSchemeResources(R.color.colorPrimary);

        Fonts.Montez(this, tvTitlePariwisata);
        setTitle("");

        swipeRefreshWisata.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        getData();

    }

    public void getData() {
        swipeRefreshWisata.setRefreshing(true);
        rvWisata.setVisibility(View.GONE);
        URL wisataURL = NetworkUtils.wisataUrl();
        new WisataAsyncTask(this, gsonWisata, rvWisata, ivError, swipeRefreshWisata).execute(wisataURL);
    }

}
