package countryinfo.test.jpl.countryinfo.Client;

import java.util.ArrayList;

import countryinfo.test.jpl.countryinfo.model.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by joseleitao on 14/12/2016.
 */

public interface RetrofitInterface {
    @GET("all")
    Call<ArrayList<Country>> getAllCountries();
}
