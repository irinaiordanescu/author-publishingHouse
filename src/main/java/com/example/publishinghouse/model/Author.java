package com.example.publishinghouse.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "idAuthor")
    private int idAuthor;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "bookVersion")
    private int bookVersion;

    @Column(name = "category")
    private String category;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="author_publishingH", joinColumns = @JoinColumn(name = "idAuthor"), inverseJoinColumns = @JoinColumn(name = "idPublishingHouse"))
    @Fetch(FetchMode.JOIN)
    private Set<PublishingHouse> publishingHs = new HashSet<>();

    public Author() {
    }

    public Author(int idAuthor, String firstName, String lastName, int bookVersion, String category) {
        this.idAuthor = idAuthor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookVersion = bookVersion;
        this.category = category;
    }

    public int getId() {
        return idAuthor;
    }

    public void setId(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBookVersion() {
        return bookVersion;
    }

    public void setBookVersion(int bookVersion) {
        this.bookVersion = bookVersion;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<PublishingHouse> getPublishingHs() { return publishingHs; }

    public void setPublishingHs(Set<PublishingHouse> publishingHs) {
        this.publishingHs = publishingHs;
    }

    public void addPublishingHouse(PublishingHouse ph) {
        this.publishingHs.add(ph);
    }
}
