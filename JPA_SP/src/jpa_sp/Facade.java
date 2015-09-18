/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Casper
 */
public class Facade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ProjectUser createUser(String UserName, String email) {
        EntityManager em = getEntityManager();
        ProjectUser user;
        
        try {
            user = new ProjectUser();
            user.setUserName(UserName);
            user.setEmail(email);

            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return user;
    }

    public ProjectUser findUser(Long projectUserid) {
        EntityManager em = getEntityManager();
        ProjectUser user;

        try {
            user = new ProjectUser();
            user = em.find(ProjectUser.class, projectUserid);

        } finally {
            em.close();
        }
        return user;
    }

    public List<ProjectUser> getallUser() {
        EntityManager em = getEntityManager();
        List<ProjectUser> userList;

        try {
            userList = new ArrayList();
            Query q = em.createNamedQuery("ProjectUser.findAll");
            userList = q.getResultList();
        } finally {
            em.close();
        }
        return userList;

    }

}
