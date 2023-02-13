package com.nnh.ColeccionEsencial;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class BorraPartituras {
    public static void main(String[] args) {
        // Clase para borrar todas las partituras y volver a empezar de nuevo con la colección vacía.
        MongoClient mc = new MongoClient();
        MongoDatabase mdb = mc.getDatabase("Agrupaciones_Musicales");
        MongoCollection mco = mdb.getCollection("partituras");

        Document doc = new Document();
        mco.deleteMany(doc);
        System.out.println("Se han borrado todos los objetos con éxito.");
    }
}
