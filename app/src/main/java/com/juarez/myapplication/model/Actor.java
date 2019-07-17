package com.juarez.myapplication.model;

public class Actor {
    private int idActorControl;
    private int id;
    private int seriesId;
    private String name;
    private String role;
    private int sortOrder;
    private String image;
    private int imageAuthor;
    private String imageAdded;

    public Actor(int id, int seriesId, String name, String role, int sortOrder, String image, int imageAuthor, String imageAdded) {
        this.id = id;
        this.seriesId = seriesId;
        this.name = name;
        this.role = role;
        this.sortOrder = sortOrder;
        this.image = image;
        this.imageAuthor = imageAuthor;
        this.imageAdded = imageAdded;
    }

    public int getIdActorControl() {
        return idActorControl;
    }

    public void setIdActorControl(int idActorControl) {
        this.idActorControl = idActorControl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getImageAuthor() {
        return imageAuthor;
    }

    public void setImageAuthor(int imageAuthor) {
        this.imageAuthor = imageAuthor;
    }

    public String getImageAdded() {
        return imageAdded;
    }

    public void setImageAdded(String imageAdded) {
        this.imageAdded = imageAdded;
    }
}
