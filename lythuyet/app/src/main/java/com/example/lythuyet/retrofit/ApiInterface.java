package com.example.lythuyet.retrofit;

        import com.example.lythuyet.model.FoodData;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;

public interface ApiInterface {

    @GET("fooddata.json")
    Call<List<FoodData>> getAllData();


    // lets make our model class of json data.

}
