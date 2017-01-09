package countryinfo.test.jpl.countryinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import countryinfo.test.jpl.countryinfo.model.Country;

public class DetailActivity extends AppCompatActivity {
    private Country country = new Country();
    private TextView population;
    private TextView region;
    private TextView capital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getIntent().getExtras()!=null){

            country = getIntent().getExtras().getParcelable("countryInfo");
        }

        population= (TextView) findViewById(R.id.textViewPopulationIndicator) ;
        region= (TextView) findViewById(R.id.textViewRegionIndicator) ;
        capital= (TextView) findViewById(R.id.textViewCapitalCityIndicator) ;
        population.setText(country.getPopulation()+"");
        region.setText(country.getRegion());
        capital.setText(country.getCapital());
    }
}
