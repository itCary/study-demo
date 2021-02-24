package online.goudan.utils;

import online.goudan.pojo.MacPojo;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @POST("cgi-bin/luci/;stok=3b35714e230fa4eb90d2e773bc349f3b/admin/wlan_macfilter?form=rules")
    @FormUrlEncoded
    Call<Response<MacPojo>> getMacList(@Field("data") String data);
}
