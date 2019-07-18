package com.juarez.myapplication.model;

public class Chapter {
    private  int idMyControl;
    private  int id;
    private int airedSeason;
    private int airedSeasonID;
    private int airedEpisodeNumber;
    private String episodeName;
    private String firstAired;
    private String [] guestStars;
    private String director;
    private String [] directors;
    private String [] writers;
    private String overview;

    private String productionCode;
    private String showUrl;
    private int lastUpdated;
    private String dvdDiscid;
    private int dvdSeason;
    private int dvdEpisodeNumber;
    private String dvdChapter;
    private int absoluteNumber;
    private String filename;
    private int seriesId;
    private int lastUpdatedBy;
    private String airsAfterSeason;
    private String airsBeforeSeason;
    private String airsBeforeEpisode;
    private int thumbAuthor;
    private String thumbAdded;
    private String thumbWidth;
    private String thumbHeight;
    private String imdbId;
    private double siteRating;
    private int siteRatingCount;

    public Chapter(int id, int airedSeason, int airedSeasonID, int airedEpisodeNumber, String episodeName, String firstAired, String[] guestStars, String director, String[] directors, String[] writers, String overview, String productionCode, String showUrl, int lastUpdated, String dvdDiscid, int dvdSeason, int dvdEpisodeNumber, String dvdChapter, int absoluteNumber, String filename, int seriesId, int lastUpdatedBy, String airsAfterSeason, String airsBeforeSeason, String airsBeforeEpisode, int thumbAuthor, String thumbAdded, String thumbWidth, String thumbHeight, String imdbId, double siteRating, int siteRatingCount) {
        this.id = id;
        this.airedSeason = airedSeason;
        this.airedSeasonID = airedSeasonID;
        this.airedEpisodeNumber = airedEpisodeNumber;
        this.episodeName = episodeName;
        this.firstAired = firstAired;
        this.guestStars = guestStars;
        this.director = director;
        this.directors = directors;
        this.writers = writers;
        this.overview = overview;
        this.productionCode = productionCode;
        this.showUrl = showUrl;
        this.lastUpdated = lastUpdated;
        this.dvdDiscid = dvdDiscid;
        this.dvdSeason = dvdSeason;
        this.dvdEpisodeNumber = dvdEpisodeNumber;
        this.dvdChapter = dvdChapter;
        this.absoluteNumber = absoluteNumber;
        this.filename = filename;
        this.seriesId = seriesId;
        this.lastUpdatedBy = lastUpdatedBy;
        this.airsAfterSeason = airsAfterSeason;
        this.airsBeforeSeason = airsBeforeSeason;
        this.airsBeforeEpisode = airsBeforeEpisode;
        this.thumbAuthor = thumbAuthor;
        this.thumbAdded = thumbAdded;
        this.thumbWidth = thumbWidth;
        this.thumbHeight = thumbHeight;
        this.imdbId = imdbId;
        this.siteRating = siteRating;
        this.siteRatingCount = siteRatingCount;
    }

    public int getIdMyControl() {
        return idMyControl;
    }

    public void setIdMyControl(int idMyControl) {
        this.idMyControl = idMyControl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAiredSeason() {
        return airedSeason;
    }

    public void setAiredSeason(int airedSeason) {
        this.airedSeason = airedSeason;
    }

    public int getAiredSeasonID() {
        return airedSeasonID;
    }

    public void setAiredSeasonID(int airedSeasonID) {
        this.airedSeasonID = airedSeasonID;
    }

    public int getAiredEpisodeNumber() {
        return airedEpisodeNumber;
    }

    public void setAiredEpisodeNumber(int airedEpisodeNumber) {
        this.airedEpisodeNumber = airedEpisodeNumber;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public String[] getGuestStars() {
        return guestStars;
    }

    public void setGuestStars(String[] guestStars) {
        this.guestStars = guestStars;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String[] getWriters() {
        return writers;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
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

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDvdDiscid() {
        return dvdDiscid;
    }

    public void setDvdDiscid(String dvdDiscid) {
        this.dvdDiscid = dvdDiscid;
    }

    public int getDvdSeason() {
        return dvdSeason;
    }

    public void setDvdSeason(int dvdSeason) {
        this.dvdSeason = dvdSeason;
    }

    public int getDvdEpisodeNumber() {
        return dvdEpisodeNumber;
    }

    public void setDvdEpisodeNumber(int dvdEpisodeNumber) {
        this.dvdEpisodeNumber = dvdEpisodeNumber;
    }

    public String getDvdChapter() {
        return dvdChapter;
    }

    public void setDvdChapter(String dvdChapter) {
        this.dvdChapter = dvdChapter;
    }

    public int getAbsoluteNumber() {
        return absoluteNumber;
    }

    public void setAbsoluteNumber(int absoluteNumber) {
        this.absoluteNumber = absoluteNumber;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getAirsAfterSeason() {
        return airsAfterSeason;
    }

    public void setAirsAfterSeason(String airsAfterSeason) {
        this.airsAfterSeason = airsAfterSeason;
    }

    public String getAirsBeforeSeason() {
        return airsBeforeSeason;
    }

    public void setAirsBeforeSeason(String airsBeforeSeason) {
        this.airsBeforeSeason = airsBeforeSeason;
    }

    public String getAirsBeforeEpisode() {
        return airsBeforeEpisode;
    }

    public void setAirsBeforeEpisode(String airsBeforeEpisode) {
        this.airsBeforeEpisode = airsBeforeEpisode;
    }

    public int getThumbAuthor() {
        return thumbAuthor;
    }

    public void setThumbAuthor(int thumbAuthor) {
        this.thumbAuthor = thumbAuthor;
    }

    public String getThumbAdded() {
        return thumbAdded;
    }

    public void setThumbAdded(String thumbAdded) {
        this.thumbAdded = thumbAdded;
    }

    public String getThumbWidth() {
        return thumbWidth;
    }

    public void setThumbWidth(String thumbWidth) {
        this.thumbWidth = thumbWidth;
    }

    public String getThumbHeight() {
        return thumbHeight;
    }

    public void setThumbHeight(String thumbHeight) {
        this.thumbHeight = thumbHeight;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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
}

