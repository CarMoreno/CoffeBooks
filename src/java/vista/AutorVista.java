/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.LogicaAutorLocal;
import modelo.Autor;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Named(value = "autorVista")
@RequestScoped
public class AutorVista {

    private InputText nombre;
    private InputText apellido;
    private InputText email;
    private InputText id;
    private CommandButton limpiar;
    private CommandButton registrar;
    private CommandButton modificar;
    private CommandButton eliminar;
    private Autor selectedAutores;
    private List<Autor> listaAutores;
    @EJB
    private LogicaAutorLocal logicaAutor;
    
    
    public AutorVista() {}
    
    public Autor getSelectedAutores() {
        return selectedAutores;
    }

    public void setSelectedAutores(Autor selectedAutores) {
        this.selectedAutores = selectedAutores;
    }
    
    public InputText getNombre() {
        return nombre;
    }

    public List<Autor> getListaAutores() {
        if(listaAutores == null){
            try {
                listaAutores = logicaAutor.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(AutorVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaAutores;
            
    }

    public void setListaAutores(List<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public void setNombre(InputText nombre) {
        this.nombre = nombre;
    }

    public InputText getApellido() {
        return apellido;
    }

    public void setApellido(InputText apellido) {
        this.apellido = apellido;
    }

    public InputText getEmail() {
        return email;
    }

    public void setEmail(InputText email) {
        this.email = email;
    }

    public InputText getId() {
        return id;
    }

    public void setId(InputText id) {
        this.id = id;
    }

    public CommandButton getLimpiar() {
        return limpiar;
    }

    public void setLimpiar(CommandButton limpiar) {
        this.limpiar = limpiar;
    }

    public CommandButton getRegistrar() {
        return registrar;
    }

    public void setRegistrar(CommandButton registrar) {
        this.registrar = registrar;
    }

    public CommandButton getModificar() {
        return modificar;
    }

    public void setModificar(CommandButton modificar) {
        this.modificar = modificar;
    }

    public CommandButton getEliminar() {
        return eliminar;
    }

    public void setEliminar(CommandButton eliminar) {
        this.eliminar = eliminar;
    }
    
    // Eventos de los botones
    public void action_registrar(){
        try {
            Autor objAutor = new Autor();
            objAutor.setIdAutor(Integer.parseInt(id.getValue().toString()));
            objAutor.setNombre(nombre.getValue().toString());
            objAutor.setEmail(email.getValue().toString());
            objAutor.setApellido(apellido.getValue().toString());
            
            logicaAutor.registrarAutor(objAutor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El autor fue registrado."));
            listaAutores = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", ex.getMessage()));
        }
    }
    
    public void action_eliminar(){
        try {
            Autor objAutor = new Autor();
            objAutor.setIdAutor(Integer.parseInt(id.getValue().toString()));
            objAutor.setNombre(nombre.getValue().toString());
            objAutor.setEmail(email.getValue().toString());
            objAutor.setApellido(apellido.getValue().toString());
            
            logicaAutor.eliminarAutor(objAutor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El autor fue eliminado"));
            listaAutores = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", ex.getMessage()));
        }
    }
    
    public void action_modificar(){
        try {
            Autor objAutor = new Autor();
            objAutor.setIdAutor(Integer.parseInt(id.getValue().toString()));
            objAutor.setNombre(nombre.getValue().toString());
            objAutor.setEmail(email.getValue().toString());
            objAutor.setApellido(apellido.getValue().toString());
            
            logicaAutor.modificarAutor(objAutor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El autor fue modificado"));
            listaAutores = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", ex.getMessage()));
        }
    }
    
    public void limpiar(){
        id.setValue("");
        nombre.setValue("");
        apellido.setValue("");
        email.setValue("");
        id.setDisabled(false);
        
        registrar.setDisabled(false);
        modificar.setDisabled(true);
        eliminar.setDisabled(true);
    }
    
    // Para seleccionar los campos automaticamente de las filas de la tabla
    public void onRowSelect(SelectEvent evento){
        Autor autorSeleccionado = (Autor) evento.getObject(); //obtenemos el objeto autor de la fila seleccionada
        id.setValue(autorSeleccionado.getIdAutor());
        nombre.setValue(autorSeleccionado.getNombre());
        apellido.setValue(autorSeleccionado.getApellido());
        email.setValue(autorSeleccionado.getEmail());
        
        registrar.setDisabled(true);
        modificar.setDisabled(false);
        eliminar.setDisabled(false);
        id.setDisabled(true);
    }
}
