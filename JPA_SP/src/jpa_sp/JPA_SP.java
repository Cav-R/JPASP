/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Casper
 */
public class JPA_SP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_SPPU");

        Facade f = new Facade(emf);

        ProjectUser pu = f.createUser("Jenny", "Jenny@hot.dk");
        f.createUser("Benny", "Benny@hot.dk");
        System.out.println("Find User metode: " + f.findUser(1l).getUserName());
        
        for (ProjectUser user  : f.getallUser()) {
            System.out.println("GetallUser metode: " + user.getUserName()+ " - " + user.getEmail());
        }
    }

}
