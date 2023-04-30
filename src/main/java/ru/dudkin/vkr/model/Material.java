package ru.dudkin.vkr.model;

import javax.persistence.*;

@Entity
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_Subtitle_Text_Refer")
    private String numberSubtitleTextRefer;

    @Column(name = "main_Txt")
    private String mainTxt;

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "Sub_Theme_id")
    private SubTheme subThemes;

    public Material(String numberSubtitleTextRefer, String mainTxt) {
        this.numberSubtitleTextRefer = numberSubtitleTextRefer;
        this.mainTxt = mainTxt;
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
