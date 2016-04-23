/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Autor;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Stateless
public class AutorFacade extends AbstractFacade<Autor> implements AutorFacadeLocal {

    @PersistenceContext(unitName = "CoffeeBooksPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorFacade() {
        super(Autor.class);
    }
    
}
