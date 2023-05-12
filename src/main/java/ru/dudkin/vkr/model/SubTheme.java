package ru.dudkin.vkr.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JoinColumn(name = "theme")
    @JsonBackReference
    private Theme theme;

    @OneToMany(mappedBy = "subTheme")
    @JsonManagedReference
    private Set<Material> materials;

    public SubTheme(String name_SbThemes, Theme theme) {
        this.name_SbThemes = name_SbThemes;
        this.theme = theme;
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

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
