package com.underground.showstracker.models.TVmodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.underground.showstracker.models.Genre;

import java.util.List;

public class TV implements Parcelable {

    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;

    @SerializedName("created_by")
    @Expose
    public String created_by;

    @SerializedName("episode_run_time")
    @Expose
    public int[] episode_run_time;

    @SerializedName("first_air_date")
    @Expose
    public String first_air_date;

    @SerializedName("genres")
    @Expose
    public List<Genre> genre = null;

    @SerializedName("homepage")
    @Expose
    public String homepage;

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("in_production")
    @Expose
    public String in_production;

    @SerializedName("languages")
    @Expose
    public String[] languages;

    @SerializedName("last_air_date")
    @Expose
    public String last_air_date;

    @SerializedName("last_episode_to_air")
    @Expose
    public String last_episode_to_air;





    protected TV(Parcel in) {
    }

    public static final Creator<TV> CREATOR = new Creator<TV>() {
        @Override
        public TV createFromParcel(Parcel in) {
            return new TV(in);
        }

        @Override
        public TV[] newArray(int size) {
            return new TV[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
