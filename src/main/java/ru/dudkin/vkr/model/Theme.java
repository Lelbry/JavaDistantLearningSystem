package ru.dudkin.vkr.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Theme() {
    }

    public Theme(Long id, String name) {
        this.id = id;
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
    private Set<SubTheme> subThemes;

    public void copy(Theme theme){
        name = theme.getName();
    }
}
