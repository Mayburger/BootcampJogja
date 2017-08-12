package nacoda.com.bootcampghifari.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mayburger on 8/10/2017.
 */

public class GsonWisata {

    @SerializedName("data")
    public List<Data> data;

    public class Data {
        @SerializedName("nama_pariwisata")
        public String nama_pariwisata;
        @SerializedName("alamat_wisata")
        public String alamat_wisata;
        @SerializedName("detail_pariwisata")
        public String detail_pariwisata;
        @SerializedName("gambar_pariwisata")
        public String gambar_pariwisata;
    }

}
