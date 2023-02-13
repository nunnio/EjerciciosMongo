package com.nnh.ColeccionExtra;


import com.nnh.ColeccionEsencial.Partitura;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreacionDatos {
    public static List<Partitura> creaPartituras(List<Partitura>partituras){
        Calendar cal = Calendar.getInstance();
        partituras = new ArrayList<>();

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
        Partitura p6 = new Partitura(6L, "Alberto López", "Luchar hasta el final", 1200, cal.getTime());
        cal.set(2022, 12, 14);
        Partitura p7 = new Partitura(7L, "Alberto López", "El paraíso del Ian", 900, cal.getTime());
        cal.set(2011, 3, 2);
        Partitura p8 = new Partitura(8L, "hola", "siono", 12, cal.getTime());

        Document doc;
        for(Partitura p : partituras) {
            doc = new Document("_id", p.getId())
                    .append("autor", p.getAutor())
                    .append("titulo", p.getTitulo())
                    .append("numero de reproducciones", p.getnEscuchas())
                    .append("fecha de publicacion", p.getFechaPubli());
            partituras.add(p);
        }
        return partituras;
    }
    public static List<Banda> creaBandas(List<Partitura>partituras){


        List<Banda> grupos = new ArrayList<>();
        Banda b1 = new Banda();
        Banda b2 = new Banda();
        Banda b3 = new Banda();
        Banda b4 = new Banda();

        b1.setNombre("Vibrando");
        b1.setnDirector("Vicente Vicedo");
        b1.setnIntegrantes(72);
        b1.setPartituras(partituras);

        b2.setNombre("RRR Social Banda");
        b2.setnDirector("S. S. Rajamouli");
        b2.setnIntegrantes(91);
        b2.setPartituras(partituras);

        b3.setNombre("Banda sindical");
        b3.setnDirector("Julián Marco");
        b3.setnIntegrantes(22);
        b3.setPartituras(partituras);

        b4.setNombre("Big Band Bond");
        b4.setnDirector("Jake Blond");
        b4.setnIntegrantes(70);
        b4.setPartituras(partituras);

        grupos.add(b1);
        grupos.add(b2);
        grupos.add(b3);
        grupos.add(b4);

        return grupos;
    }
}
