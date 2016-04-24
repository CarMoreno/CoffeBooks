/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Libro;
import persistencia.LibroFacadeLocal;


/**
 *
 * @author Carlos Andrés Moreno
 */
@Stateless
public class LogicaLibro implements LogicaLibroLocal {
    
    @EJB
    LibroFacadeLocal libroDAO;

    @Override
    public void registrarLibro(Libro miLibro) throws Exception {
        if(miLibro == null){
            throw new Exception("Campos Vacíos");
        }
        else{
            if(miLibro.getFechaPublicacion() == null){
                throw new Exception("El campo fecha es obligatorio");
            }
            if(miLibro.getIdLibro() == null){
                throw new Exception("El SVN del libro es obligatorio");
            }
            if(miLibro.getTitulo() == null){
                throw new Exception("El titulo del libro es obligatorio");
            }
            if(miLibro.getIdEditor() == null){
                throw new Exception("El editor del libro es obligatorio");
            }
        }
        
        Libro objLibro = libroDAO.find(miLibro.getIdLibro());
        if (objLibro != null){
            throw new Exception("EL libro ya existe");
        }
        else{
            libroDAO.create(miLibro);
        }
    }

    @Override
    public List<Libro> consultarTodos() throws Exception {
        return libroDAO.findAll();
    }

    @Override
    public void modificarLibro(Libro miLibro) throws Exception {
        if(miLibro == null){
            throw new Exception("Campos Vacíos");
        }
        else{
            if(miLibro.getFechaPublicacion() == null){
                throw new Exception("El campo fecha es obligatorio");
            }
            if(miLibro.getIdLibro() == null){
                throw new Exception("El SVN del libro es obligatorio");
            }
            if(miLibro.getTitulo() == null){
                throw new Exception("El titulo del libro es obligatorio");
            }
            if(miLibro.getIdEditor() == null){
                throw new Exception("El editor del libro es obligatorio");
            }
        }
        Libro objLibro = libroDAO.find(miLibro.getIdLibro());
        if(objLibro == null){
            throw new Exception("El libro que va a modificar no existe");
        }
        else{
            miLibro.setSinopsis(miLibro.getSinopsis());
            miLibro.setFechaPublicacion(miLibro.getFechaPublicacion());
            miLibro.setTitulo(miLibro.getTitulo());
            miLibro.setPortada(miLibro.getPortada());
            miLibro.setIdEditor(miLibro.getIdEditor());
            libroDAO.edit(miLibro);
        }
    }

    @Override
    public void eliminarLibro(Libro miLibro) throws Exception {
        if(miLibro == null){
            throw new Exception("Campos Vacíos");
        }
        else{
            if(miLibro.getFechaPublicacion() == null){
                throw new Exception("El campo fecha es obligatorio");
            }
            if(miLibro.getIdLibro() == null){
                throw new Exception("El SVN del libro es obligatorio");
            }
            if(miLibro.getTitulo() == null){
                throw new Exception("El titulo del libro es obligatorio");
            }
        }
        
        Libro objLibro = libroDAO.find(miLibro.getIdLibro());
        if (objLibro == null){
            throw new Exception("El libro que desea eliminar no existe");
        }
        else{
            if(objLibro.getAutorList().size() > 0){
                throw new Exception("El libro tiene autores asociados");
            }
            else{
                libroDAO.remove(miLibro);
            }
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
