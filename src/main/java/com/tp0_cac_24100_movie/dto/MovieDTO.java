package com.tp0_cac_24100_movie.dto;

import java.util.Date;

public class MovieDTO {
    private Long id;
    private String title;
    private String poster;
    private String backdrop;
    private Date release_date;
    private Long runtime;
    private String overview;
    private String status;
    private Long budget;
    private Long revenue;
    private String language;

    public MovieDTO(){}

    public MovieDTO(Long id, String title, String poster, String backdrop, Date release_date, Long runtime,
            String overview, String status, Long budget, Long revenue, String language) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.backdrop = backdrop;
        this.release_date = release_date;
        this.runtime = runtime;
        this.overview = overview;
        this.status = status;
        this.budget = budget;
        this.revenue = revenue;
        this.language = language;
    }

    public MovieDTO(String title, String poster, String backdrop, Date release_date, Long runtime,
            String overview, String status, Long budget, Long revenue, String language) {
        this.title = title;
        this.poster = poster;
        this.backdrop = backdrop;
        this.release_date = release_date;
        this.runtime = runtime;
        this.overview = overview;
        this.status = status;
        this.budget = budget;
        this.revenue = revenue;
        this.language = language;
    }

    // GETTERs and SETTERs
    //#region
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Long getRuntime() {
        return runtime;
    }

    public void setRuntime(Long runtime) {
        this.runtime = runtime;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    //#endregion
}
