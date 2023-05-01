package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "albums")
public class Albums {

    public Albums(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer album_id;

    @OneToMany(mappedBy = "albums", cascade = CascadeType.ALL)
    private List<Songs> songs;

    @Column(name="title")
    private String title;

    @Column(name="release_date")
    private Date release_date;

    @Column(name="stock")
    private Integer stock;

    @Column(name="artist")
    private String artist;

    @Column(name="price")
    private Double price;

    public Integer getAlbum_id()
    {
        return album_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getRelease_date()
    {
        return release_date;
    }

    public void setDate(Date release_date){
        this.release_date = release_date;
    }

    public Integer getStock()
    {
        return stock;
    }

    public void setStock(Integer stock)
    {
        this.stock = stock;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public List<Songs> getSongs()
    {
        return songs;
    }
    public Albums(String title, Date release_date, Integer stock,
                  String artist, Double price) {
        this.title = title;
        this.release_date = release_date;
        this.stock = stock;
        this.artist = artist;
        this.price = price;

    }
}