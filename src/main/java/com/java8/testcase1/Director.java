package com.java8.testcase1;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Created by ZhangYuZhong on 2017/8/1.
 */
public class Director {
    private String name;
    private String country;
    private List<Movie> movies;

    public Director(String name, String country) {
        this.name = name;
        this.country = country;
    }
    public Integer getMovieSize(){
        if (Objects.nonNull(this.getMovies())){
            return getMovies().size();
        }
        return 0;
    }
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    public BigDecimal getTotalBoxOffice(){
        BigDecimal tatal = movies.stream().map(x->x.getOfficeBox()).reduce((x,y)->(x.add(y))).get();
        return tatal;
    }
    @Override
    public String toString() {
        return "{"+"\n"
                + "\"name\":\"" + name + "\""+"\n"
                + ", \"country\":\"" + country + "\""+"\n"
                + ", \"movies\":" + movies+"\n"
                + "}";
    }

    /*@Override
    public boolean equals(Object o) {
        System.out.println("equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (name != null ? !name.equals(director.name) : director.name != null) return false;
        return country != null ? country.equals(director.country) : director.country == null;
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }*/
}
