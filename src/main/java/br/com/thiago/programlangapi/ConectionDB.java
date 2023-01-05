package br.com.thiago.programlangapi;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConectionDB {

    public MongoDatabase makeConection(){
    
        ConnectionString connectionString = new ConnectionString("mongodb+srv://jastick-manager:i6rLt2xTNMhlpEQs@cluster-java-sticker.6fkw268.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .serverApi(ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build())
            .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("stickersDB");

        return database;
    }
}
