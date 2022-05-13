package com.boots.entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "links")
public class Links {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence")
    @Column(name = "id")
    Long id;

    @Column(name = "path")
    String path;

    @Column(name = "token")
    String token;

    public Links() {

    }

    public Links(Long id, String path, String token) {
        this.id = id;
        this.path = path;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Links links = (Links) o;
        return Objects.equals(id, links.id) && Objects.equals(path, links.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path);
    }

    @Override
    public String toString() {
        return "Links{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
