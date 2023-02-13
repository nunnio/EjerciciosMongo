package com.nnh.ColeccionEsencial;

import com.mongodb.client.MongoCollection;
import org.bson.Document;


public class Actualizacion {
    public static void actualiza(MongoCollection mco){
        Document filtro = new Document("titulo", "Nissan dorma");
        Document cambio = new Document("$set", new Document("autor", "Nano, Nunoi"));
        Document filtro2 = new Document("numero de reproducciones", 1000);
        Document cambio2 = new Document("$set", new Document("titulo", "Lacribossa"));

        System.out.println("Actualizando los siguientes documentos:");
        Muestra.mostrar(mco, filtro);
        Muestra.mostrar(mco, filtro2);

        mco.updateOne(filtro, cambio);
        mco.updateOne(filtro2, cambio2);

        System.out.println("- Documentos actualizados -\nResultado:");
        Muestra.mostrar(mco, filtro);
        Muestra.mostrar(mco, filtro2);

    }

    public static void actualizaMuchos(MongoCollection mco){
        Document filtro = new Document("autor", "Alberto López");
        Document cambio = new Document("$inc", new Document("numero de reproducciones", 100));

        System.out.println("Actualizando los documentos:");
        Muestra.mostrar(mco, filtro);

        mco.updateMany(filtro, cambio);

        System.out.println("- Documentos actualizados -\nResultado:");
        Muestra.mostrar(mco, filtro);
    }
}
