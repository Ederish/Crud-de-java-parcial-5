/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capalogica;

/**
 *
 * @author Ederi
 */
public class UsuariosDao {

    private String correos;
    private String claves;
    private String nombres;
    private String Apellidos;
    private int Niveles;
    /**
     * @return the correos
     */
    public String getCorreos() {
        return correos;
    }

    /**
     * @param correos the correos to set
     */
    public void setCorreos(String correos) {
        this.correos = correos;
    }

    /**
     * @return the claves
     */
    public String getClaves() {
        return claves;
    }

    /**
     * @param claves the claves to set
     */
    public void setClaves(String claves) {
        this.claves = claves;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the Niveles
     */
    public int getNiveles() {
        return Niveles;
    }

    /**
     * @param Niveles the Niveles to set
     */
    public void setNiveles(int Niveles) {
        this.Niveles = Niveles;
    }
}
