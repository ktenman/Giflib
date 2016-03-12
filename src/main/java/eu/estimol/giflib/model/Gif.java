package eu.estimol.giflib.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gif {
    private String name;
    private LocalDate dateUploaded;
    private String username;
    private boolean favorite;

    public Gif(String name, LocalDate dateUploaded, String username, boolean favorite) {
        this.name = name;
        this.dateUploaded = dateUploaded;
        this.username = username;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateUploaded() {
        return dateUploaded.format(DateTimeFormatter.ofPattern("dd. MMM yyyy"));
        //return dateUploaded;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "Gif{" +
                "name='" + name + '\'' +
                ", dateUploaded=" + dateUploaded +
                ", username='" + username + '\'' +
                ", favorite=" + favorite +
                '}';
    }
}
