package ru.dudkin.vkr.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Sub_Theme")
public class SubTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name_SbThemes;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme_id;

    @OneToMany(mappedBy = "subTheme")
    private Set<Material> materials;

    public SubTheme(Long id, String name_SbThemes, Theme theme_id) {
        this.id = id;
        this.name_SbThemes = name_SbThemes;
        this.theme_id = theme_id;
    }

    public void copy(SubTheme subTheme){name_SbThemes = subTheme.getName_SbThemes();}

    public SubTheme() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_SbThemes() {
        return name_SbThemes;
    }

    public void setName_SbThemes(String name_SbThemes) {
        this.name_SbThemes = name_SbThemes;
    }

    public Theme getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(Theme theme_id) {
        this.theme_id = theme_id;
    }
}
