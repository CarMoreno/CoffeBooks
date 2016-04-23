/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Editor;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Stateless
public class EditorFacade extends AbstractFacade<Editor> implements EditorFacadeLocal {

    @PersistenceContext(unitName = "CoffeeBooksPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EditorFacade() {
        super(Editor.class);
    }
    
}
