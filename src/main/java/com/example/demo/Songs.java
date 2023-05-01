package com.example.demo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name = "songs")
public class Songs {

    public  Songs(){}

    @ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name="album_id")
    private Albums albums;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer song_id;

    @Column(name="track")
    private Integer track;

    @Column(name="name")
    private String name;

   /* @Column(name="album_id")
    private Integer album_id;
    public Integer getSongAlbum_id()
    {
        return album_id;
    }*/

    public Integer getSong_id(){
        return song_id;
    }

    public Integer getTrack(){
        return track;
    }

    public String getName()
    {
        return name;
    }



    public String getAlbum() {
        return albums.getArtist();
    }

    public Songs(Integer track, String name, Integer album_id)
    {
        this.track = track;
        this.name = name;
       /* this.album_id = album_id;*/
    }

}
