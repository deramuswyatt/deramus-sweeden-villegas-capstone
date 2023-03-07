package com.codeup.deramussweedenvillegascapstone.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 75)
    private String street_add;

    @Column(nullable = false, length = 25)
    private String city;

    @Column(nullable = false, length = 50)
    private String state;

    @Column(nullable = false, length = 100)
    private int zip;

    @Column(nullable = false)
    private String image_url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "property")
    private List<Note> notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="property_category",
            joinColumns = {@JoinColumn(name="property_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )
    private List<Category> categories;

    public Property(long id, String street_add, String city, String state, int zip, String image_url, List<Note> notes, User user, List<Category> categories) {
        this.id = id;
        this.street_add = street_add;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.image_url = image_url;
        this.notes = notes;
        this.user = user;
        this.categories = categories;
    }

    public Property(String street_add, String city, String state, int zip, String image_url, List<Note> notes, User user, List<Category> categories) {
        this.street_add = street_add;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.image_url = image_url;
        this.notes = notes;
        this.user = user;
        this.categories = categories;
    }

    public Property() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet_add() {
        return street_add;
    }

    public void setStreet_add(String street_add) {
        this.street_add = street_add;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}



