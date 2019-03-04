/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.recipes.persistence;

import co.edu.uniandes.csw.recipes.entities.RecipeEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author CesarF
 */

@Stateless
public class RecipePersistence {
    private static final Logger LOGGER = Logger.getLogger(RecipePersistence.class.getName());
    
    @PersistenceContext(unitName = "recipesPU")
    protected EntityManager em;
    
  
    public RecipeEntity find(Long id) {
        return em.find(RecipeEntity.class, id);
    }
    //TODO método crear de recipe
     
    public RecipeEntity create(RecipeEntity recipeEntity) {
        em.persist(recipeEntity);
        
        return recipeEntity;
    
}
    public RecipeEntity findByName(String name) {
       
        TypedQuery query = em.createQuery("Select e From RecipeEntity e where e.name = :name", RecipeEntity.class);
       
        query = query.setParameter("name", name);
       
        List<RecipeEntity> sameName = query.getResultList();
        RecipeEntity result;
        if (sameName == null) {
            result = null;
        } else if (sameName.isEmpty()) {
            result = null;
        } else {
            result = sameName.get(0);
        }
        return result;
    }
    
     public RecipeEntity findByDescripción(String dscr) {
       
        TypedQuery query = em.createQuery("Select e From RecipeEntity e where e.name = :dscr", RecipeEntity.class);
       
        query = query.setParameter("name", dscr);
       
        List<RecipeEntity> sameName = query.getResultList();
        RecipeEntity result;
        if (sameName == null) {
            result = null;
        } else if (sameName.isEmpty()) {
            result = null;
        } else {
            result = sameName.get(0);
        }
        return result;
    }
    
    
    
}
    

