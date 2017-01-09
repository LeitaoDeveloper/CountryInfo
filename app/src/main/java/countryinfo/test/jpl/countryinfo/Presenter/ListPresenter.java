package countryinfo.test.jpl.countryinfo.Presenter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import countryinfo.test.jpl.countryinfo.Adapter.CountriesAdapter;
import countryinfo.test.jpl.countryinfo.Client.RetrofitClient;
import countryinfo.test.jpl.countryinfo.Client.RetrofitInterface;
import countryinfo.test.jpl.countryinfo.MainActivity;
import countryinfo.test.jpl.countryinfo.R;
import countryinfo.test.jpl.countryinfo.model.Country;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by joseleitao on 14/12/2016.
 */

public class ListPresenter {

    MainActivity mView;
    RetrofitInterface mRestCountries;

    public ListPresenter(MainActivity activity, RetrofitInterface restCountries) {

        mView = activity;
        mRestCountries = restCountries;

    }

    public void loadCountries(){

        Call<ArrayList<Country>> call = mRestCountries.getAllCountries();
        call.enqueue(new Callback<ArrayList<Country>>() {
            @Override
            public void onResponse(Call<ArrayList<Country>>call, Response<ArrayList<Country>> response) {
                List<Country> countries = response.body();
                mView.displayCountryList(countries);
            }

            @Override
            public void onFailure(Call<ArrayList<Country>>call, Throwable t) {
                // Log error here since request failed
                Log.e("erro", t.toString());
            }
        });

    }
}
