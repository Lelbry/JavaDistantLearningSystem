package ru.dudkin.vkr.model;


import javax.persistence.*;

@Entity
@Table(name = "Illustration")
public class Illustration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Link", columnDefinition = "TEXT")
    private String link;

    @Column(name = "Subtitle_Text_Refer")
    private String subtitleTextRefer;

    public Illustration() {
    }

    public Illustration(String link, String subtitleTextRefer) {
        this.link = link;
        this.subtitleTextRefer = subtitleTextRefer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSubtitleTextRefer() {
        return subtitleTextRefer;
    }

    public void setSubtitleTextRefer(String subtitleTextRefer) {
        this.subtitleTextRefer = subtitleTextRefer;
    }
}
