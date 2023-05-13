package ru.dudkin.vkr.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_Subtitle_Text_Refer")
    private String numberSubtitleTextRefer;

    @Column(name = "main_Text", columnDefinition = "TEXT", nullable = false)
    private String mainTxt;

    public Long getId() {
        return id;
    }


    public Material(String numberSubtitleTextRefer, String mainTxt) {
        this.numberSubtitleTextRefer = numberSubtitleTextRefer;
        this.mainTxt = mainTxt;
    }

    public Material() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberSubtitleTextRefer() {
        return numberSubtitleTextRefer;
    }

    public void setNumberSubtitleTextRefer(String numberSubtitleTextRefer) {
        this.numberSubtitleTextRefer = numberSubtitleTextRefer;
    }

    public String getMainTxt() {
        return mainTxt;
    }

    public void setMainTxt(String mainTxt) {
        this.mainTxt = mainTxt;
    }

}
