package com.nnh.ColeccionExtra;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.nnh.ColeccionEsencial.Muestra;
import com.nnh.ColeccionEsencial.Partitura;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class App {
    public static void main(String[] args) {

        ConnectionString connectionString = new ConnectionString("mongodb://localhost/Agrupaciones_musicales");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        try (MongoClient mongoClient =  MongoClients.create(clientSettings)){
            MongoDatabase mdb = mongoClient.getDatabase("Agrupaciones_Musicales");
            MongoCollection<Banda> bandas = mdb.getCollection("bandas", Banda.class);

            MongoCursor<Banda> mc = bandas.find().iterator();

            List<Partitura> partituras = new ArrayList<>();
            List<Banda> grupos = new ArrayList<>();

            while(mc.hasNext()) {
                System.out.println(mc.next());
            }

            partituras = CreacionDatos.creaPartituras(partituras);
            grupos = CreacionDatos.creaBandas(partituras);

            for (Partitura p : partituras) {
                System.out.println(p);
            }

            //Muestra.mostrar(bandas);

            bandas.insertMany(grupos);
            /*
            ChangeStreamIterable<Banda> cs = bandas.watch();
            cs.forEach((Consumer< ChangeStreamDocument<Banda>>)System.out::println);
            */

        }
    }
}
