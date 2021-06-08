package com.example.os;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

@Metadata(
        mv = {1, 1, 16},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'¨\u0006\b"},
        d2 = {"Lcom/cookandroid/OS/KakaoAPI;", "", "getSearchKeyword", "Lretrofit2/Call;", "Lcom/cookandroid/OS/ResultSearchKeyword;", "key", "", "query", "OS.app"}
)

public interface KakaoAPI {
    @GET("v2/local/search/keyword.json")
    @NotNull
    Call <ResultSearchKeyword> getSearchKeyword(@Header("Authorization") @NotNull String key, @Query("query") @NotNull String query,
                                                @Query("x") @NotNull String longitude, @Query("y") @NotNull String latitude);
}