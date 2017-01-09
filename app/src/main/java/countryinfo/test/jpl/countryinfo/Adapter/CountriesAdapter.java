package countryinfo.test.jpl.countryinfo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import countryinfo.test.jpl.countryinfo.DetailActivity;
import countryinfo.test.jpl.countryinfo.R;
import countryinfo.test.jpl.countryinfo.model.Country;

/**
 * Created by joseleitao on 14/12/2016.
 */

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder> {

    private List<Country> countries;
    private int rowLayout;
    private Context context;

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        LinearLayout mLinearLayout;


        public CountryViewHolder(View v) {
            super(v);

            countryName = (TextView) v.findViewById(R.id.countryName);
            mLinearLayout = (LinearLayout) v.findViewById(R.id.listLinearLyout);

        }
    }

    public CountriesAdapter(List<Country> countries, int rowLayout, Context context) {
        this.countries = countries;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CountriesAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CountryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CountryViewHolder holder, final int position) {
        holder.countryName.setText(countries.get(position).getName());
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailActivity = new Intent(context, DetailActivity.class);
                detailActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                detailActivity.putExtra("countryInfo", countries.get(position));
                context.startActivity(detailActivity);

            }
        });

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


}
