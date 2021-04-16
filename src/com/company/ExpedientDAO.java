package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpedientDAO {
    private Connection con = null;

    /**
     * getNotesAlumne: retorna llista de les notes assignades a un alumne
     * @param dni de l'alumne del que vull recuperar les notes de les assignatures matriculades
     * @return ArrayList amb objectes de tipus Expedient
     */
    public List<Expedient> getNotesAlumne(String dni) {
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT codi,nota_ordinaria,nota_extraordinaria FROM expedients where dni= ?";

        List<Expedient> expedients = new ArrayList<Expedient>();

        try {
            con = Connexio.connectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, dni);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                Expedient expedient = new Expedient();
                expedient.setCodiAssignatura(rs.getInt(1));
                expedient.setNota_ordinaria(rs.getDouble(2));
                expedient.setNota_extraordinaria(rs.getDouble(3));

                expedients.add(expedient);
            }
            sentencia.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en obtenir llista notes alumne "+dni);
            e.printStackTrace();
        }

        return expedients;
    }

    /**
     * getNotesAssignatura: Donat el codi d'una assignatura retorna la llista amb els expedients
     * dels alumnes que la cursem (dni + nota)
     * @param codi de l'assignatura
     * @return ArrayList amb objectes de tipus Expedient
     */
    public List<Expedient> getNotesAssignatura(int codi) {

        return null;
    }

    public boolean canviarNota(String dni, int codiAssignatura,int convocatoria,double nota) {

        return false;
    }
}
