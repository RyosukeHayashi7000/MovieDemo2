package com.example.moviedemo2.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDBResponse  implements Parcelable
    {

        @SerializedName("results")
        @Expose
        private List<Movie> movies = null;
        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("total_results")
        @Expose
        private Integer totalResults;
        @SerializedName("dates")
        @Expose
        private Dates dates;
        @SerializedName("total_pages")
        @Expose
        private Integer totalPages;
        public final static Parcelable.Creator<MovieDBResponse> CREATOR = new Creator<MovieDBResponse>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public MovieDBResponse createFromParcel(Parcel in) {
                return new MovieDBResponse(in);
            }

            public MovieDBResponse[] newArray(int size) {
                return (new MovieDBResponse[size]);
            }

        }
                ;

protected MovieDBResponse(Parcel in) {
        in.readList(this.movies, (com.example.moviedemo2.model.Movie.class.getClassLoader()));
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dates = ((Dates) in.readValue((Dates.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

public MovieDBResponse() {
    }

        public List<Movie> getMovies() {
        return movies;
    }

        public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

        public Integer getPage() {
        return page;
    }

        public void setPage(Integer page) {
        this.page = page;
    }

        public Integer getTotalResults() {
        return totalResults;
    }

        public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

        public Dates getDates() {
        return dates;
    }

        public void setDates(Dates dates) {
        this.dates = dates;
    }

        public Integer getTotalPages() {
        return totalPages;
    }

        public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

        public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(movies);
        dest.writeValue(page);
        dest.writeValue(totalResults);
        dest.writeValue(dates);
        dest.writeValue(totalPages);
    }

        public int describeContents() {
        return 0;
    }

    }
