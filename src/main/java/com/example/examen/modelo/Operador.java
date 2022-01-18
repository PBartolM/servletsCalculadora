package com.example.examen.modelo;


import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class Operador implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String op;
    private String descrip;
    private Double valor;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOp() {
        return op;
    }
    public void setOp(String op) {
        this.op = op;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }


    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Operador() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Operador(int id, String op, String descrip, Double valor) {
        super();
        this.id = id;
        this.op = op;
        this.descrip = descrip;
        this.valor = valor;
    }


    public void escribeEnFichero(RandomAccessFile stream) {
        try {
            stream.writeInt(id);
            stream.writeUTF(op);
            stream.writeUTF(descrip);
            stream.writeDouble(valor);

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero.");
            System.exit(0);
        }
    }

    public void leeDeFichero(RandomAccessFile stream) throws EOFException, IOException {
        id = stream.readInt();
        op = stream.readUTF();
        descrip = stream.readUTF();
        valor = stream.readDouble();
    }


    @Override
    public String toString() {
        String cadena="";
        cadena+="Operación: " + this.descrip + " [  " + this.op + " ]"+ "\n";
        cadena+="valor: " + this.valor ;
        return cadena;
    }
}