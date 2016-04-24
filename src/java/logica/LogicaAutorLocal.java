/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Autor;
import java.util.List;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Local
public interface LogicaAutorLocal {
   public void registrarAutor(Autor miAutor) throws Exception; 
   public void modificarAutor(Autor miAutor) throws Exception;
   public void eliminarAutor(Autor miAutor) throws Exception;
   public List<Autor> consultarTodos() throws Exception;
}
