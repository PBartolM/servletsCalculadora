package com.example.examen.modelo;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Set;

public class GestorOperador {

    RandomAccessFile stream;


    public GestorOperador() {
        creaFichero("/home/tomcat/fichero.dat");
    }

    private void creaFichero(String nombreFichero) {
        try {
            boolean exists = (new File(nombreFichero)).exists();
            stream = new RandomAccessFile(nombreFichero, "rw");
            if ( ! exists) {
                creaUsuarioPorDefecto();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el fichero: " + nombreFichero);
            System.exit(0);
        }
    }

    private void creaUsuarioPorDefecto() {

        Operador nuevoOp1 = new Operador (1,"+", "Suma", 24.0);
        nuevoOp1.escribeEnFichero(stream);
        Operador nuevoOp2 = new Operador(2,"-","Resta",19.0);
        nuevoOp2.escribeEnFichero(stream);
        Operador nuevoOp3 = new Operador(3,"*","Producto",25.0);
        nuevoOp3.escribeEnFichero(stream);
        Operador nuevoOp4 = new Operador(4,"/","División",27.0);
        nuevoOp4.escribeEnFichero(stream);
    }


    public void cierraGestor() {
        try {
            stream.close();
        } catch (IOException e) {
            System.out.println("No se ha podido cerrar el fichero");
        }
    }

    private void posicionaFichero(long posicion) {
        try {
            stream.seek(posicion);
        } catch (IOException e) {
            System.out.println("Error posicionando el puntero al inicio del fichero");
            System.exit(0);
        }
    }

    public String[] listaDeOperaciones() {
        Operador operador = new Operador();
        Set<String> conjuntoOperaciones = new HashSet<String>();
        try{
            while(this.stream.getFilePointer() < this.stream.length()){
                operador.leeDeFichero(this.stream);
                conjuntoOperaciones.add(operador.getDescrip());
            }
            stream.seek(0);
            return conjuntoOperaciones.toArray(new String[conjuntoOperaciones.size()]);
        }
        catch (EOFException e) {
            throw new RuntimeException("ERROR LOCALIZANDO EL FICHERO.");
        }
        catch (IOException e) {
            throw new RuntimeException("ERROR CREANDO EL FICHERO.");
        }

    }

    private String[] hashArray(HashSet<String> users) {
        String[] lista = new String[users.size()];
        int i = 0;
        for (String val : users) lista[i++] = val;
        return lista;
    }


    public String calculaRdo(String oper, String op1, String op2) {

        char cad;
        cad = oper.charAt(0);
        Double ope1 = Double.parseDouble(op1);
        Double ope2 = Double.parseDouble(op2);
        Double res=0.0;
    //    Los comentarios que te pongo a continuación son para realizar las operaciones dentro del switch
    //     Para Convertir un String a Double puedes usar Double.parseDouble(op1) , por ejemplo
    //     Para convertir de Double a String puedes usar Double.toString(ope1) , por ejemplo

        switch (cad){
            case '+':
                res=ope1+ope2;
                break;
            case '-':
                res=ope1-ope2;
                break;
            case '*':
                res=ope1*ope2;
                break;
            case '/':
                res=ope1/ope2;
                break;
        }
        String rdo= Double.toString(res);

        return rdo;
    }

    public String MostrarOperacion (String oper) {
        String res="";
        char cad = oper.charAt(0);
        switch (cad){
            case '+':
                res="Suma";
                break;
            case '-':
                res="Resta";
                break;
            case '*':
                res="Multiplicacion";
                break;
            case '/':
                res="Division";
                break;
        }
        return res;
    }

}