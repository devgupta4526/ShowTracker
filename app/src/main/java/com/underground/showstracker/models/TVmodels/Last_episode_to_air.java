package com.underground.showstracker.models.TVmodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Last_episode_to_air implements Parcelable {

    @SerializedName("air_date")
    @Expose
    public String air_date;

    @SerializedName("episode_number")
    @Expose
    public int episode_number;

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("season_number")
    @Expose
    public String season_number;

    protected Last_episode_to_air(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Last_episode_to_air> CREATOR = new Creator<Last_episode_to_air>() {
        @Override
        public Last_episode_to_air createFromParcel(Parcel in) {
            return new Last_episode_to_air(in);
        }

        @Override
        public Last_episode_to_air[] newArray(int size) {
            return new Last_episode_to_air[size];
        }
    };
}
