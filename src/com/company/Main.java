package com.company;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // provem l'accés a la taula alumnes fent ús del DAO de l'alumne
        AlumneDAO alumneDAO = new AlumneDAO();

        // creem 2 objectes de tipus alumne
        Alumne alumne4 = new Alumne("44444444D","Marc Coromines Lopez","Major 4, Tarragona","977444444");
        Alumne alumne5 = new Alumne("55555555D","Marta Camps Solís","Major 5, Tarragona","977555555");
        // Els guardem a la BD
        alumneDAO.save(alumne4);
        alumneDAO.save(alumne5);

        // Esborrem alumne 5. Passem la referència de l'objecte que volem esborrar
        alumneDAO.delete(alumne5);

        // Obtenim les dades d'un alumne passant el dni
        Alumne alu = alumneDAO.get("11111111A");
        if(alu!=null) System.out.println("El nom és: "+ alu.getNom()+" i el telefon "+alu.getTelefon());

        // Obtenim tots els alumnes i mostrem dni i non
        List<Alumne> alumnes = alumneDAO.getAll();
        System.out.println("Llista alumnes:");
        for(int i=0; i< alumnes.size(); i++) {
            System.out.println(" "+ alumnes.get(i).getDni()+" "+alumnes.get(i).getNom());
        }

        List<Expedient> notes;
        notes = alu.getNotes();
        for(int i=0;i<notes.size();i++) {
            System.out.print(notes.get(i).getCodiAssignatura());
            System.out.println(" :"+notes.get(i).getNota_ordinaria());
        }

        // esborrem alumne4 per no tenir conflictes amb PK repetides!
        alumneDAO.delete(alumne4);

        // Activitat
        // Crea una nova assignatura

        // LLista les assignatures que hi ha a la base de dades



        // esborra l'assignatura que has creat

    }
}
