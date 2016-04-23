/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Libro;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Local
public interface LogicaLibroLocal {
    public void registrarLibro(Libro miLibro) throws Exception;
    public List<Libro> consultarTodos() throws Exception;
    public void modificarLibro(Libro miLibro) throws Exception;
    public void eliminarLibro(Libro miLibro) throws Exception;
}
