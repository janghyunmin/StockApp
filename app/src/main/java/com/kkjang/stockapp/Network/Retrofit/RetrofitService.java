package com.kkjang.stockapp.Network.Retrofit;

import com.kkjang.stockapp.Dao.BaseDAO;
import com.kkjang.stockapp.Dao.GetAlramDAO;
import com.kkjang.stockapp.Dao.GetCategoryLikeFavDAO;
import com.kkjang.stockapp.Dao.GetCheckFreeDAO;
import com.kkjang.stockapp.Dao.GetContentsViewDAO;
import com.kkjang.stockapp.Dao.GetContentsViewType2DAO;
import com.kkjang.stockapp.Dao.GetLikeDAO;
import com.kkjang.stockapp.Dao.GetLikeDetailDAO;
import com.kkjang.stockapp.Dao.GetNickNameDAO;
import com.kkjang.stockapp.Dao.GetPushDetailDAO;
import com.kkjang.stockapp.Dao.GetPushListDAO;
import com.kkjang.stockapp.Dao.GetSearchMainDAO;
import com.kkjang.stockapp.Dao.ResultMarketConditionsDAO;
import com.kkjang.stockapp.Dao.SetCategoryLikeDAO;
import com.kkjang.stockapp.Dao.SetLikeDAO;
import com.kkjang.stockapp.Dao.SpotUpDAO;
import com.kkjang.stockapp.Dao.SpotUpDAOCategory2;
import com.kkjang.stockapp.Dao.SpotUpDAOCategory3;
import com.kkjang.stockapp.Dao.VersionDAO;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {

    @FormUrlEncoded
    @POST("/api/get_version.php")
    Call<VersionDAO> getVersion(@Field("type") String page);

    @FormUrlEncoded
    @POST("/api/set_profile.php")
    Call<BaseDAO> setProfile(@Field("mb_id") String mb_id,
                             @Field("nick_name") String nick_name);

    @FormUrlEncoded
    @POST("/api/get_profile.php")
    Call<GetNickNameDAO> getProfile(@Field("mb_id") String mb_id);


    @FormUrlEncoded
    @POST("/api/set_alarm.php")
    Call<BaseDAO> setAlram(@Field("mb_id") String mb_id,
                           @Field("al_all") String al_all,
                           @Field("mb_1") String mb_1,
                           @Field("mb_2") String mb_2,
                           @Field("mb_3") String mb_3);

    @FormUrlEncoded
    @POST("/api/set_user.php")
    Call<BaseDAO> setUser(@Field("mb_id") String mb_id,
                          @Field("mb_4") String mb_4,
                          @Field("token") String token);

    @FormUrlEncoded
    @POST("/api/set_free_update.php")
    Call<BaseDAO> setFreeUpdate(@Field("mb_id") String mb_id,
                                @Field("mb_name") String mb_name,
                                @Field("mb_hp") String mb_hp);

    @FormUrlEncoded
    @POST("/api/get_free_data.php")
    Call<BaseDAO> getFreeUpdate(@Field("mb_id") String mb_id);


    @FormUrlEncoded
    @POST("/api/set_inquiry.php")
    Call<BaseDAO> setInquiry(@Field("mb_id") String mb_id,
                             @Field("wr_name") String wr_name,
                             @Field("wr_email") String wr_email,
                             @Field("wr_content") String wr_content);

    @FormUrlEncoded
    @POST("/api/get_alarm.php")
    Call<GetAlramDAO> getAlram(@Field("mb_id") String mb_id);

    @FormUrlEncoded
    @POST("/api/get_search_main.php")
    Call<GetSearchMainDAO> getSearchMain(@Field("mb_id") String mb_id,
                                         @Field("stx") String stx);

    //    @GET("/api/info/appdata")
//    Call<AppDataResponseModel> getApplicationData();
//
    @FormUrlEncoded
    @POST("/api/get_contents.php")
    Call<ResultMarketConditionsDAO> getMainContentList(@Field("page") int page,
                                                       @Field("mb_id") String mb_id,
                                                       @Field("board_type") String board_type);

    @FormUrlEncoded
    @POST("/api/get_contents_view.php")
    Call<GetContentsViewDAO> getContentsView(@Field("mb_id") String mb_id,
                                             @Field("board_type") String board_type,
                                             @Field("wr_id") String wri_id);

    @FormUrlEncoded
    @POST("/api/get_contents_view.php")
    Call<GetContentsViewType2DAO> getContentsViewType2(@Field("mb_id") String mb_id,
                                                       @Field("board_type") String board_type,
                                                       @Field("wr_id") String wri_id);

    @FormUrlEncoded
    @POST("/api/get_category01.php")
    Call<SpotUpDAO> getCategory01(@Field("mb_id") String mb_id);

    @FormUrlEncoded
    @POST("/api/get_category02.php")
    Call<SpotUpDAOCategory2> getCategory02(@Field("ca_id") String ca_id,
                                           @Field("code") String code);

    @FormUrlEncoded
    @POST("/api/get_category03.php")
    Call<SpotUpDAOCategory3> getCategory03(@Field("mb_id") String mb_id,
                                           @Field("ca_id2") String ca_id,
                                           @Field("code") String code);

    @FormUrlEncoded
    @POST("/api/set_like.php")
    Call<SetLikeDAO> setLike(@Field("mb_id") String mb_id,
                             @Field("wr_id") String wr_id,
                             @Field("bo_table") String bo_table);

    @FormUrlEncoded
    @POST("/api/get_like.php")
    Call<GetLikeDAO> getLike(@Field("mb_id") String mb_id);

    @FormUrlEncoded
    @POST("/api/get_check_free.php")
    Call<GetCheckFreeDAO> getCheckFree(@Field("mb_id") String mb_id);


    @FormUrlEncoded
    @POST("/api/set_category_like.php")
    Call<SetCategoryLikeDAO> setCategolyLike(@Field("mb_id") String mb_id,
                                             @Field("ca_id2") String ca_id2,
                                             @Field("ca_id3") String ca_id3);

    @FormUrlEncoded
    @POST("/api/get_lately_category.php")
    Call<SpotUpDAOCategory2> getLatelyCategory(@Field("mb_id") String mb_id);


    @FormUrlEncoded
    @POST("/api/get_like_detail.php")
    Call<GetLikeDetailDAO> getLikeDetail(@Field("wr_id") String wr_id,
                                         @Field("bo_table") String bo_table);

    @FormUrlEncoded
    @POST("/api/get_category_like.php")
    Call<GetCategoryLikeFavDAO> getCategoryLike(@Field("mb_id") String mb_id);


    @FormUrlEncoded
    @POST("/api/get_push_list.php")
    Call<GetPushListDAO> getPushList(@Field("mb_id") String mb_id,
                                     @Field("bo_table") String bo_table);

    @FormUrlEncoded
    @POST("/api/get_push_detail.php")
    Call<GetPushDetailDAO> getPushDetail(@Field("pu_id") String pu_id,
                                         @Field("bo_table") String bo_table);

    @FormUrlEncoded
    @POST("/api/get_push_delete.php")
    Call<BaseDAO> getPushDelete(@Field("mb_id") String mb_id,
                                @Field("pu_id") String pu_id,
                                @Field("bo_table") String bo_table);

}
