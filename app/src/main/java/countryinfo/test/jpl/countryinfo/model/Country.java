package countryinfo.test.jpl.countryinfo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by joseleitao on 14/12/2016.
 */

public class Country implements Parcelable{
    @SerializedName("name")
    private String name;
    @SerializedName("region")
    private String region;
    @SerializedName("population")
    private int population;
    @SerializedName("capital")
    private String capital;

    public Country(){

    }

    public Country(String name, String region, String capital, int population){
        this.setName(name);
        this.setRegion(region);
        this.setCapital(capital);
        this.setPopulation(population);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    protected Country(Parcel in) {
        name = in.readString();
        region = in.readString();
        population = in.readInt();
        capital = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(region);
        dest.writeInt(population);
        dest.writeString(capital);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}
