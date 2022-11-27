package com.underground.showstracker.models.TVmodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Episodes implements Parcelable {


    @SerializedName("air_date")
    @Expose
    public String airDate;

    @SerializedName("episode_number")
    @Expose
    public Integer episodeNumber;

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("production_code")
    @Expose
    public String productionCode;


    @SerializedName("season_number")
    @Expose
    public Integer seasonNumber;

    @SerializedName("still_path")
    @Expose
    public String stillPath;

    @SerializedName("vote_average")
    @Expose
    public Integer voteAverage;


    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;

    public Episodes(String airDate, Integer episodeNumber, Integer id, String name, String overview, String productionCode, Integer seasonNumber, String stillPath, Integer voteAverage, Integer voteCount) {
        this.airDate = airDate;
        this.episodeNumber = episodeNumber;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.productionCode = productionCode;
        this.seasonNumber = seasonNumber;
        this.stillPath = stillPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    protected Episodes(Parcel in) {

        airDate = in.readString();
        if (in.readByte() == 0) {
            episodeNumber= null;
        } else {
            episodeNumber= in.readInt();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        overview = in.readString();
        productionCode = in.readString();
        if (in.readByte() == 0) {
            seasonNumber = null;
        } else {
            seasonNumber = in.readInt();
        }
        stillPath = in.readString();

        if (in.readByte() == 0) {
            voteAverage = null;
        } else {
            voteAverage = in.readInt();
        }
        if (in.readByte() == 0) {
            voteCount = null;
        } else {
            voteCount = in.readInt();
        }


    }

    //getters and setters


    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getProductionCode() {
        return productionCode;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getStillPath() {
        return stillPath;
    }

    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
    }

    public Number getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public static final Creator<Episodes> CREATOR = new Creator<Episodes>() {
        @Override
        public Episodes createFromParcel(Parcel in) {
            return new Episodes(in);
        }

        @Override
        public Episodes[] newArray(int size) {
            return new Episodes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(airDate);
        if (episodeNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(episodeNumber);
        }
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(name);
        parcel.writeString(overview);
        parcel.writeString(productionCode);
        if (seasonNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(seasonNumber);
        }
        parcel.writeString(stillPath);
        if (voteAverage == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(voteAverage);
        }
        if (voteCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(voteCount);
        }

    }

    @Override
    public String toString() {
        return "Episodes{" +
                "airDate='" + airDate + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", productionCode='" + productionCode + '\'' +
                ", seasonNumber=" + seasonNumber +
                ", stillPath='" + stillPath + '\'' +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                '}';
    }
}
