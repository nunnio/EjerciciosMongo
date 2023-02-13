package com.nnh.ColeccionEsencial;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Eliminacion {
    public static void eliminaUno(MongoCollection mco){
        Document doc = new Document("titulo", "El paraíso del Ian");
        System.out.println("Se borrará el siguiente documento:\n");
        Muestra.mostrar(mco, doc);
        mco.deleteOne(doc);
        System.out.println("Documento borrado \n");
    }
    public static void eliminaMuchos(MongoCollection mco){
        Document filtro = new Document("$gt", 1000);
        Document doc = new Document("numero de reproducciones", filtro);
        mco.deleteMany(doc);
        System.out.println("Documentos borrados \n");
    }
}
