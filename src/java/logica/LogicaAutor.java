/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Autor;
import persistencia.AutorFacade;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Stateless
public class LogicaAutor implements LogicaAutorLocal {

    @EJB
    AutorFacade autorDAO;
    @Override
    public void registrarAutor(Autor miAutor) throws Exception {
        if(miAutor == null){
            throw new Exception("Campos Vacíos");
        }
        else{
            if(miAutor.getNombre().equals("")){
                throw new Exception("El campo nombre es obligatorio");
            }
            if(miAutor.getApellido().equals("")){
                throw new Exception("El campo apellido es obligatorio");
            }
            if(miAutor.getEmail().equals("")){
                throw new Exception("El campo email es obligatorio");
            }
            if(miAutor.getIdAutor() == null){
                throw new Exception("El campo documento es obligatorio");
            }
        }
        Autor objAutor = autorDAO.find(miAutor.getIdAutor());
        if(objAutor != null){
            throw new Exception("El autor que desea registrar, ya existe");
        }
        else{
            autorDAO.create(miAutor);
        }
    }

    @Override
    public void modificarAutor(Autor miAutor) throws Exception {
        if(miAutor == null){
            throw new Exception("Campos Vacíos");
        }
        else{
            if(miAutor.getNombre().equals("")){
                throw new Exception("El campo nombre es obligatorio");
            }
            if(miAutor.getApellido().equals("")){
                throw new Exception("El campo apellido es obligatorio");
            }
            if(miAutor.getEmail().equals("")){
                throw new Exception("El campo email es obligatorio");
            }
            if(miAutor.getIdAutor() == null){
                throw new Exception("El campo documento es obligatorio");
            }
        }
        Autor objAutor = autorDAO.find(miAutor.getIdAutor());
        if(objAutor == null){
            throw new Exception("El autor que desea modificar no existe");
        }else{
            objAutor.setNombre(miAutor.getNombre());
            objAutor.setApellido(miAutor.getApellido());
            objAutor.setEmail(miAutor.getEmail());
            objAutor.setIdAutor(miAutor.getIdAutor());//Cedula
        }
    }

    @Override
    public void eliminarAutor(Autor miAutor) throws Exception {
        if(miAutor == null){
            throw new Exception("Campos Vacíos");
        }
        else{
            if(miAutor.getNombre().equals("")){
                throw new Exception("El campo nombre es obligatorio");
            }
            if(miAutor.getApellido().equals("")){
                throw new Exception("El campo apellido es obligatorio");
            }
            if(miAutor.getEmail().equals("")){
                throw new Exception("El campo email es obligatorio");
            }
            if(miAutor.getIdAutor() == null){
                throw new Exception("El campo documento es obligatorio");
            }
        }
        Autor objAutor = autorDAO.find(miAutor.getIdAutor());
        if(objAutor == null){
            throw new Exception("El autor que desea eliminar no existe");
        }
        else{
            if(objAutor.getLibroList().size() > 0){
                throw new Exception("El autor tiene libros asociados");
            }
            else{
                autorDAO.remove(miAutor);
            }
            
        }
    }

    @Override
    public List<Autor> consultarTodos() throws Exception {
        return autorDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
