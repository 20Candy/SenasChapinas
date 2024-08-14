package com.example.components.dictionary;

public class CardData {
    String title;
    int imgLenseguaResId;
    int imgCardResId;

    String categoria;

    public CardData(String title, int imgLenseguaResId, int imgCardResId, String categoria) {
        this.title = title;
        this.imgLenseguaResId = imgLenseguaResId;
        this.imgCardResId = imgCardResId;
        this.categoria = categoria;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgLenseguaResId() {
        return imgLenseguaResId;
    }

    public void setImgLenseguaResId(int imgLenseguaResId) {
        this.imgLenseguaResId = imgLenseguaResId;
    }

    public int getImgCardResId() {
        return imgCardResId;
    }

    public void setImgCardResId(int imgCardResId) {
        this.imgCardResId = imgCardResId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
