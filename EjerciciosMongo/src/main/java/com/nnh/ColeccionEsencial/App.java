package com.nnh.ColeccionEsencial;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

public class App {
    public static void main(String[] args) {
        MongoClient mc = new MongoClient();
        MongoDatabase mdb = mc.getDatabase("Agrupaciones_Musicales");
        MongoCollection mco = mdb.getCollection("partituras");
        Scanner sc = new Scanner(System.in);

        //  Inserción
        Insercion.inserta(mco);
        System.out.print("Presione enter para continuar a las actualizaciones");
        sc.nextLine();

        //  Actualización
        Actualizacion.actualiza(mco);
        System.out.println("Presione enter para continuar");
        sc.nextLine();

        Actualizacion.actualizaMuchos(mco);
        System.out.println("Presione enter para continuar a las eliminaciones");
        sc.nextLine();

        //  Eliminación
        Eliminacion.eliminaUno(mco);
        System.out.print("Presione enter para continuar");
        sc.nextLine();

        System.out.println("Se borrarán los siguientes documentos( con número de reproducciones > 1000)");
        List<Document> docs = (List<Document>) mco.find(gt("numero de reproducciones", 1000))
                .projection(fields(
                        include("autor", "titulo", "numero de reproducciones")))
                .into(new ArrayList<>());
        // Muestra compleja
        Muestra.mostrarComplejo(docs);

        Eliminacion.eliminaMuchos(mco);
        System.out.print("Presione enter para finalizar el programa");
        sc.nextLine();
        System.out.println("\n\t- Fin del programa -");


        mc.close();
    }
}