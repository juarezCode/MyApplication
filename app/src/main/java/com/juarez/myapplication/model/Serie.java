package com.juarez.myapplication.model;

import java.io.Serializable;

public class Serie {

    private int id;
    private String seriesName;
    private String [] aliases;
    private String banner;
    private String seriesId;
    private String status;
    private String firstAired;
    private String network;
    private String networkId;
    private String runtime;
    private String [] genre;

    private String overview;
    private int lastUpdated;
    private String airsDayOfWeek;
    private String airsTime;
    private String rating;
    private String imdbId;
    private String zap2itId;
    private String added;
    private int addedBy;
    private double siteRating;
    private int siteRatingCount;
    private String slug;

    public Serie(int id, String seriesName, String[] aliases, String banner, String seriesId, String status, String firstAired, String network, String networkId, String runtime, String[] genre, String overview, int lastUpdated, String airsDayOfWeek, String airsTime, String rating, String imdbId, String zap2itId, String added, int addedBy, double siteRating, int siteRatingCount, String slug) {
        this.id = id;
        this.seriesName = seriesName;
        this.aliases = aliases;
        this.banner = banner;
        this.seriesId = seriesId;
        this.status = status;
        this.firstAired = firstAired;
        this.network = network;
        this.networkId = networkId;
        this.runtime = runtime;
        this.genre = genre;
        this.overview = overview;
        this.lastUpdated = lastUpdated;
        this.airsDayOfWeek = airsDayOfWeek;
        this.airsTime = airsTime;
        this.rating = rating;
        this.imdbId = imdbId;
        this.zap2itId = zap2itId;
        this.added = added;
        this.addedBy = addedBy;
        this.siteRating = siteRating;
        this.siteRatingCount = siteRatingCount;
        this.slug = slug;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getAirsDayOfWeek() {
        return airsDayOfWeek;
    }

    public void setAirsDayOfWeek(String airsDayOfWeek) {
        this.airsDayOfWeek = airsDayOfWeek;
    }

    public String getAirsTime() {
        return airsTime;
    }

    public void setAirsTime(String airsTime) {
        this.airsTime = airsTime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getZap2itId() {
        return zap2itId;
    }

    public void setZap2itId(String zap2itId) {
        this.zap2itId = zap2itId;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public int getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(int addedBy) {
        this.addedBy = addedBy;
    }

    public double getSiteRating() {
        return siteRating;
    }

    public void setSiteRating(double siteRating) {
        this.siteRating = siteRating;
    }

    public int getSiteRatingCount() {
        return siteRatingCount;
    }

    public void setSiteRatingCount(int siteRatingCount) {
        this.siteRatingCount = siteRatingCount;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
