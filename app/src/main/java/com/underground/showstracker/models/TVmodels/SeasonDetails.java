package com.underground.showstracker.models.TVmodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.underground.showstracker.models.ProductionCompany;

import java.util.List;

public class SeasonDetails implements Parcelable {

    @SerializedName("_id")
    @Expose
    public String  _id;

    @SerializedName("air_date")
    @Expose
    public String airDate;

    @SerializedName("episodes")
    @Expose
    public List<Episodes> episodes = null;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("poster_path")
    @Expose
    public String posterPath;

    @SerializedName("season_number")
    @Expose
    public Integer seasonNumber;

    //constructor


    public SeasonDetails(String _id, String airDate, List<Episodes> episodes, String name, String overview, Integer id, String posterPath, Integer seasonNumber) {
        this._id = _id;
        this.airDate = airDate;
        this.episodes = episodes;
        this.name = name;
        this.overview = overview;
        this.id = id;
        this.posterPath = posterPath;
        this.seasonNumber = seasonNumber;
    }

    //getters and setters


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public List<Episodes> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episodes> episodes) {
        this.episodes = episodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    protected SeasonDetails(Parcel in) {
        _id = in.readString();
        airDate = in.readString();
        episodes = in.createTypedArrayList(Episodes.CREATOR);
        name = in.readString();
        overview = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        posterPath = in.readString();
        if (in.readByte() == 0) {
            seasonNumber = null;
        } else {
            seasonNumber = in.readInt();
        }

    }


    public static final Creator<SeasonDetails> CREATOR = new Creator<SeasonDetails>() {
        @Override
        public SeasonDetails createFromParcel(Parcel in) {
            return new SeasonDetails(in);
        }

        @Override
        public SeasonDetails[] newArray(int size) {
            return new SeasonDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(_id);
        parcel.writeString(airDate);
        parcel.writeTypedList(episodes);
        parcel.writeString(name);
        parcel.writeString(overview);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(posterPath);
        if (seasonNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(seasonNumber);
        }
    }

    @Override
    public String toString() {
        return "SeasonDetails{" +
                "_id='" + _id + '\'' +
                ", airDate='" + airDate + '\'' +
                ", episodes=" + episodes +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", id=" + id +
                ", posterPath='" + posterPath + '\'' +
                ", seasonNumber=" + seasonNumber +
                '}';
    }
}
