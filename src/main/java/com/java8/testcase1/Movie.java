package com.java8.testcase1;

import java.util.List;

/**
 * Created by ZhangYuZhong on 2017/8/1.
 */
public class Movie {
    private String movieName;
    private Double officeBox;
    private List<Actor> directorList;

    public Movie(String movieName, Double officeBox, List<Actor> directorList) {
        this.movieName = movieName;
        this.officeBox = officeBox;
        this.directorList = directorList;
    }

    public String getMovieName() {
        return movieName;
    }

    public Double getOfficeBox() {
        return officeBox;
    }

    public List<Actor> getDirectorList() {
        return directorList;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setOfficeBox(Double officeBox) {
        this.officeBox = officeBox;
    }

    public void setDirectorList(List<Actor> directorList) {
        this.directorList = directorList;
    }

    @Override
    public String toString() {
        return "{"
                + "\"movieName\":\"" + movieName + "\""
                + ", \"officeBox\":\"" + officeBox + "\""
                + ", \"directorList\":" + directorList
                + "}";
    }
}
