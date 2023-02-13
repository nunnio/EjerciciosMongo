package com.nnh.ColeccionEsencial;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Muestra {
    public static void mostrar(MongoCollection mco, Document filtro){
        List<Partitura> partituras = new ArrayList<>();
        FindIterable fit = mco.find(filtro);
        MongoCursor cursor = fit.iterator();
        Document doc = new Document();
        while (cursor.hasNext()){
            doc = (Document) cursor.next();
            Partitura p = new Partitura();
            p.setId(doc.getLong("_id"));
            p.setAutor(doc.getString("autor"));
            p.setTitulo(doc.getString("titulo"));
            p.setnEscuchas(doc.getInteger("numero de reproducciones"));
            p.setFechaPubli(doc.getDate("fecha de publicacion"));
            partituras.add(p);
        }
        for(Partitura p: partituras){
            System.out.println(p);
        }
    }
    public static void mostrarComplejo(List<Document> docs){

        //Document document;
        Consumer<Document> mostrarCada = document -> System.out.println(document.toJson());
        docs.forEach(mostrarCada);
    }
}