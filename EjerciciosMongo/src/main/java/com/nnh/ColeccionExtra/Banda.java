package com.nnh.ColeccionExtra;


import com.nnh.ColeccionEsencial.Partitura;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.List;

public class Banda {
    @BsonId
    public ObjectId id;
    public String nombre;
    public String nDirector;
    public int nIntegrantes;
    public List<Partitura> partituras;

    public Banda() {
    }

    public Banda(ObjectId id, String nombre, String nDirector, int nIntegrantes, List<Partitura> partituras) {
        this.id = id;
        this.nombre = nombre;
        this.nDirector = nDirector;
        this.nIntegrantes = nIntegrantes;
        this.partituras = partituras;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnDirector() {
        return nDirector;
    }

    public void setnDirector(String nDirector) {
        this.nDirector = nDirector;
    }

    public int getnIntegrantes() {
        return nIntegrantes;
    }

    public void setnIntegrantes(int nIntegrantes) {
        this.nIntegrantes = nIntegrantes;
    }

    public List<Partitura> getPartituras() {
        return partituras;
    }

    public void setPartituras(List<Partitura> partituras) {
        this.partituras = partituras;
    }

    @Override
    public String toString() {
        return "Banda{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nDirector='" + nDirector + '\'' +
                ", nIntegrantes=" + nIntegrantes +
                ", partituras=" + partituras +
                '}';
    }
}