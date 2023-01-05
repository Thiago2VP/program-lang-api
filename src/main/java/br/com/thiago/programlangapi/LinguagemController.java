package br.com.thiago.programlangapi;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
public class LinguagemController {

    //@Autowired
    //private LinguagemRepository repositorio;

    MongoDatabase conection = new ConectionDB().makeConection();

    /*
    Aqui era criada uma lista com conteudo para conteudo para fazer o json
    private List<Linguagem> linguagens = List.of(
        new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java.png", 2),
        new Linguagem("JavaScript", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript.png", 1),
        new Linguagem("PHP", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php.png", 3)
    );
    */
    
    @GetMapping(value = "/")
    public String processaLinguagem(){
        return "<body style=\"background-color:black;margin:0\"><h1 style=\"font-family:Arial;padding:2em\">Seja Bem Vindo</h1></body>";
    }
    
    /*
    @GetMapping(value = "/linguagens")
    public List<Linguagem> obterLinguagens(){
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }
    */
    
    /*
    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }
    */

    @GetMapping(value = "/linguagens")
    public String obterLinguagens(){
        MongoCollection<Document> collectionUsada = conection.getCollection("principaisLinguagens");
        FindIterable<Document> myDoc = collectionUsada.find();
        List<String> linguagens = new ArrayList<>();
        for (Document documento : myDoc) {
            linguagens.add(documento.toJson());
        }
        return linguagens.toString();
    }

    @PostMapping(value = "/linguagens")
    public String cadastrarLinguagem(@RequestBody Linguagem linguagem){
        MongoCollection<Document> collectionUsada = conection.getCollection("principaisLinguagens");
        Document documento = new Document();
        documento.put("title", linguagem.getTitle());
        documento.put("image", linguagem.getImage());
        documento.put("rank", linguagem.getRank());
        collectionUsada.insertOne(documento);
        String resultado = "Registrado: " + linguagem.getTitle();
        return resultado;
    }
}
