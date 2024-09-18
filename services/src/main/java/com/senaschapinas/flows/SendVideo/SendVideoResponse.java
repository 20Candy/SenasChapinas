package com.senaschapinas.flows.SendVideo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendVideoResponse {

    @JsonProperty("id_video")
    private String id_video;

    @JsonProperty("sentence_lensegua")
    private String sentence_lensegua;

    @JsonProperty("traduction_esp")
    private String traduction_esp;

    public String getId_video() {
        return id_video;
    }

    public void setId_video(String id_video) {
        this.id_video = id_video;
    }

    public String getTraduction_lensegua() {
        return sentence_lensegua;
    }

    public void setTraduction_lensegua(String sentence_lensegua) {
        this.sentence_lensegua = sentence_lensegua;
    }

    public String getTraduction_esp() {
        return traduction_esp;
    }

    public void setTraduction_esp(String traduction_esp) {
        this.traduction_esp = traduction_esp;
    }
}
