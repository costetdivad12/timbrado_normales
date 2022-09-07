package iebem.edu.mx.timbre_normales.model;

import java.util.ArrayList;

public class XmlModel {
    private String Cadena_original; 
    private String fecha_exp;
    private int idAlumno;
    private String firma;


    public String getFirma() {
        return this.firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }


    public int getIdAlumno() {
        return this.idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }



    public String getFecha_exp() {
        return this.fecha_exp;
    }

    public void setFecha_exp(String fecha_exp) {
        this.fecha_exp = fecha_exp;
    }




    public String getCadena_original() {
        return this.Cadena_original;
    }

    public void setCadena_original(String Cadena_original) {
        this.Cadena_original = Cadena_original;
    }

    
}
