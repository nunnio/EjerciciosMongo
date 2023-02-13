package com.nnh.ColeccionEsencial;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Insercion {
    public static void inserta(MongoCollection mco) {
        Calendar cal = Calendar.getInstance();

        List<Partitura> partituras = new ArrayList<>();

        cal.set(1995, 0, 0);
        Partitura p1 = new Partitura(1L, "Philip Sparke", "Fantasy for euphonium", 421, cal.getTime());
        cal.set(2023, 1, 18);
        Partitura p2 = new Partitura(2L, "Javier Vicedo", "Squibidi dap dap yes yes dabeliu dabeliu", 727, cal.getTime());
        cal.set(2025, 5, 22);
        Partitura p3 = new Partitura(3L, "Perla, Nunai", "Nissan dorma", 333, cal.getTime());
        cal.set(2024, 7, 30);
        Partitura p4 = new Partitura(4L, "Pablo Valero, Manuel Ibáñez", "Laprimossa", 1000, cal.getTime());
        cal.set(2022, 11, 19);
        Partitura p5 = new Partitura(5L, "Alberto López", "Vamos a la casa", 1100, cal.getTime());
        cal.set(2018, 5, 0);
        Partitura p6 = new Partitura(6L, "Alberto López", "Luchar hasta el final", 1500, cal.getTime());
        cal.set(2022, 12, 14);
        Partitura p7 = new Partitura(7L, "Alberto López", "El paraíso del Ian", 800, cal.getTime());
        cal.set(2011, 3, 2);
        Partitura p8 = new Partitura(8L, "hola", "siono", 12, cal.getTime());

        partituras.add(p1);
        partituras.add(p2);
        partituras.add(p3);
        partituras.add(p4);
        partituras.add(p5);
        partituras.add(p6);
        partituras.add(p7);
        partituras.add(p8);

        Document doc;
        for(Partitura p : partituras) {
            doc = new Document("_id", p.getId())
                    .append("autor", p.getAutor())
                    .append("titulo", p.getTitulo())
                    .append("numero de reproducciones", p.getnEscuchas())
                    .append("fecha de publicacion", p.getFechaPubli());
            mco.insertOne(doc);
        }
        Document filtro = new Document();
        Muestra.mostrar(mco, filtro);
    }
}
