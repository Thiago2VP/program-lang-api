package br.com.thiago.programlangapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")
public class Linguagem {
    @Id
    private String id;
    public String title;
    public String image;
    public int rank;

    public Linguagem(){
        
    }

    public Linguagem(String title, String image, int rank) {
        this.title = title;
        this.image = image;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRank() {
        return rank;
    }
    
}
