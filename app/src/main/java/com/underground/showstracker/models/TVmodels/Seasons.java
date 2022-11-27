package com.underground.showstracker.models.TVmodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.underground.showstracker.models.Genre;
import com.underground.showstracker.models.ProductionCompany;

import java.util.List;

public class Seasons implements Parcelable {



    @SerializedName("air_date")
    @Expose
    public String airDate;

    @SerializedName("id")
    @Expose
    public Integer  id;

    @SerializedName("episode_count")
    @Expose
    public Integer episodeCount;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("poster_path")
    @Expose
    public String posterPath;


    @SerializedName("season_number")
    @Expose
    public Integer seasonNumber;

    public Seasons(String airDate, int id, int episodeCount, String name, String overview, String posterPath, int seasonNumber) {
        this.airDate = airDate;
        this.id = id;
        this.episodeCount = episodeCount;
        this.name = name;
        this.overview = overview;
        this.posterPath = posterPath;
        this.seasonNumber = seasonNumber;
    }

    protected Seasons(Parcel in) {
        airDate = in.readString();
        if (in.readByte() == 0) {
            episodeCount = null;
        } else {
            episodeCount = in.readInt();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        overview = in.readString();
        posterPath = in.readString();
        if (in.readByte() == 0) {
            seasonNumber = null;
        } else {
            seasonNumber = in.readInt();
        }
    }





    //getters and setter
    public String getAirDate() {
        return airDate;
    }

    public int getId() {
        return id;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(airDate);
        parcel.writeString(name);
        parcel.writeString(posterPath);
        parcel.writeString(overview);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        if (episodeCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(episodeCount);
        }
        if (seasonNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(seasonNumber);
        }

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Seasons> CREATOR = new Creator<Seasons>() {
        @Override
        public Seasons createFromParcel(Parcel in) {
            return new Seasons(in);
        }

        @Override
        public Seasons[] newArray(int size) {
            return new Seasons[size];
        }
    };

    @Override
    public String toString() {
        return "Seasons{" +
                "airDate='" + airDate + '\'' +
                ", id=" + id +
                ", episodeCount=" + episodeCount +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", seasonNumber=" + seasonNumber +
                '}';
    }
}
