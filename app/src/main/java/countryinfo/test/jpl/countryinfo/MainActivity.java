package countryinfo.test.jpl.countryinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import countryinfo.test.jpl.countryinfo.Adapter.CountriesAdapter;
import countryinfo.test.jpl.countryinfo.Client.RetrofitClient;
import countryinfo.test.jpl.countryinfo.Client.RetrofitInterface;
import countryinfo.test.jpl.countryinfo.Presenter.ListPresenter;
import countryinfo.test.jpl.countryinfo.model.Country;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListPresenter mListPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitInterface apiService = RetrofitClient.provideRetrofit().create(RetrofitInterface.class);
        mListPresenter = new ListPresenter(this, apiService);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerViewCountries);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mListPresenter.loadCountries();

    }

    public void displayCountryList(List<Country> countries) {

        recyclerView.setAdapter(new CountriesAdapter(countries, R.layout.country_list, getApplicationContext()));
    }

}
