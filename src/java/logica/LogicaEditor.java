/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Editor;
import persistencia.EditorFacadeLocal;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Stateless
public class LogicaEditor implements LogicaEditorLocal {

    @EJB
    private EditorFacadeLocal editorDAO;
    @Override
    public void registrarEditor(Editor miEditor) throws Exception {
        if(miEditor == null){
            throw new Exception("Campos vacíos");
        }
        else{
            if(miEditor.getNombre().equals("")){
                throw new Exception("El campo nombre es obligatorio");
            }
            if(miEditor.getPais().equals("")){
                throw new Exception("EL campo pais es obligatorio");
            }
            if(miEditor.getCiudad().equals("")){
                throw new Exception("El campo ciudad es obligatorio");
            }
            if(miEditor.getDomicilio().equals("")){
                throw new Exception("EL campo domicilio es obligatorio");
            }
            if(miEditor.getEstado().equals("")){
                throw new Exception("El campo estado es obligatorio");
            }
            if(miEditor.getWebsite().equals("")){
                throw new Exception("El campo de sitio web es obligatorio");
            }
            if(miEditor.getIdEditor() == null){
                throw new Exception("El campo id del editor es obligatorio");
            }
            Editor objEditor = editorDAO.find(miEditor.getIdEditor());
            if(objEditor != null){
                throw new Exception("El editor que desea registrar ya existe");
            }
            else{
                editorDAO.create(miEditor);
            }
        }
    }

    @Override
    public void modificarEditor(Editor miEditor) throws Exception {
        if(miEditor == null){
            throw new Exception("Campos vacíos");
        }
        else{
            if(miEditor.getNombre().equals("")){
                throw new Exception("El campo nombre es obligatorio");
            }
            if(miEditor.getPais().equals("")){
                throw new Exception("EL campo pais es obligatorio");
            }
            if(miEditor.getCiudad().equals("")){
                throw new Exception("El campo ciudad es obligatorio");
            }
            if(miEditor.getDomicilio().equals("")){
                throw new Exception("EL campo domicilio es obligatorio");
            }
            if(miEditor.getEstado().equals("")){
                throw new Exception("El campo estado es obligatorio");
            }
            if(miEditor.getWebsite().equals("")){
                throw new Exception("El campo de sitio web es obligatorio");
            }
            if(miEditor.getIdEditor() == null){
                throw new Exception("El campo id del editor es obligatorio");
            }
            Editor objEditor = editorDAO.find(miEditor.getIdEditor());
            if(objEditor == null){
                throw new Exception("El editor que desea modificar no existe");
            }
            else{
                objEditor.setNombre(miEditor.getNombre());
                objEditor.setCiudad(miEditor.getCiudad());
                objEditor.setDomicilio(miEditor.getDomicilio());
                objEditor.setEstado(miEditor.getEstado());
                objEditor.setPais(miEditor.getPais());
                objEditor.setWebsite(miEditor.getWebsite());
                editorDAO.edit(objEditor);
            }
        }
    }

    @Override
    public void eliminarEditor(Editor miEditor) throws Exception {
        if(miEditor == null){
            throw new Exception("Campos vacíos");
        }
        else{
            if(miEditor.getNombre().equals("")){
                throw new Exception("El campo nombre es obligatorio");
            }
            if(miEditor.getPais().equals("")){
                throw new Exception("EL campo pais es obligatorio");
            }
            if(miEditor.getCiudad().equals("")){
                throw new Exception("El campo ciudad es obligatorio");
            }
            if(miEditor.getDomicilio().equals("")){
                throw new Exception("EL campo domicilio es obligatorio");
            }
            if(miEditor.getEstado().equals("")){
                throw new Exception("El campo estado es obligatorio");
            }
            if(miEditor.getWebsite().equals("")){
                throw new Exception("El campo de sitio web es obligatorio");
            }
            if(miEditor.getIdEditor() == null){
                throw new Exception("El campo id del editor es obligatorio");
            }
        }
        Editor objEditor = editorDAO.find(miEditor.getIdEditor());
        if(objEditor == null){
            throw new Exception("El Editor que desea eliminar no existe");
        }
        else{
            if(objEditor.getLibroList().size() > 0){
                throw new Exception("El editor tiene asociado libros existentes");
            }
            else{
                editorDAO.remove(miEditor);
            }
        }
    }

    @Override
    public List<Editor> consultarTodos() throws Exception {
        return editorDAO.findAll();
    }
    
}
