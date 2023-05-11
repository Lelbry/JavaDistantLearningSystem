package ru.dudkin.vkr.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Theme")
public class Theme {
    //Id в Бд прописать тип serial
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Theme() {
    }

    public Set<SubTheme> getSubThemes() {
        return subThemes;
    }

    public void setSubThemes(Set<SubTheme> subThemes) {
        this.subThemes = subThemes;
    }

    public Theme(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "theme")
    @JsonManagedReference
    private Set<SubTheme> subThemes;

    public void copy(Theme theme){
        name = theme.getName();
    }
}
