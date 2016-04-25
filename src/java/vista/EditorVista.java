
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import logica.LogicaAutorLocal;
import logica.LogicaEditorLocal;
import modelo.Autor;
import modelo.Editor;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Named(value = "editorVista")
@RequestScoped
public class EditorVista {

    private InputText txtId;
    private InputText txtNombre;
    private InputText txtCiudad;
    private InputText txtPais;
    private InputText txtDomicilio;
    private InputText txtEstado;
    private InputText txtWebsite;
    private CommandButton btnLimpiar;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private Editor selectedEditores;
    private List<Editor> listaEditores;
    @EJB
    private LogicaEditorLocal logicaEditor;
    
    
    public EditorVista() {}

    public InputText getTxtId() {
        return txtId;
    }

    public void setTxtId(InputText txtId) {
        this.txtId = txtId;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtCiudad() {
        return txtCiudad;
    }

    public void setTxtCiudad(InputText txtCiudad) {
        this.txtCiudad = txtCiudad;
    }

    public InputText getTxtPais() {
        return txtPais;
    }

    public void setTxtPais(InputText txtPais) {
        this.txtPais = txtPais;
    }

    public InputText getTxtDomicilio() {
        return txtDomicilio;
    }

    public void setTxtDomicilio(InputText txtDomicilio) {
        this.txtDomicilio = txtDomicilio;
    }

    public InputText getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(InputText txtEstado) {
        this.txtEstado = txtEstado;
    }

    public InputText getTxtWebsite() {
        return txtWebsite;
    }

    public void setTxtWebsite(InputText txtWebsite) {
        this.txtWebsite = txtWebsite;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public Editor getSelectedEditores() {
        return selectedEditores;
    }

    public void setSelectedEditores(Editor selectedEditores) {
        this.selectedEditores = selectedEditores;
    }

    public List<Editor> getListaEditores() {
        if(listaEditores == null){
            try {
                listaEditores = logicaEditor.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(EditorVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaEditores;
    }

    public void setListaEditores(List<Editor> listaEditores) {
        this.listaEditores = listaEditores;
    }

    public LogicaEditorLocal getLogicaEditor() {
        return logicaEditor;
    }

    public void setLogicaEditor(LogicaEditorLocal logicaEditor) {
        this.logicaEditor = logicaEditor;
    }
    
    
    
    // Eventos de los botones
    public void action_registrar(){
        try {
            Editor objEditor = new Editor();
            objEditor.setIdEditor(Integer.parseInt(txtId.getValue().toString()));
            objEditor.setNombre(txtNombre.getValue().toString());
            objEditor.setCiudad(txtCiudad.getValue().toString());
            objEditor.setPais(txtPais.getValue().toString());
            objEditor.setEstado(txtEstado.getValue().toString());
            objEditor.setDomicilio(txtDomicilio.getValue().toString());
            objEditor.setWebsite(txtWebsite.getValue().toString());
            
            logicaEditor.registrarEditor(objEditor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El editor fue registrado."));
            listaEditores = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", ex.getMessage()));
        }
    }
    
    public void action_eliminar(){
        try {
            Editor objEditor = new Editor();
            objEditor.setIdEditor(Integer.parseInt(txtId.getValue().toString()));
            objEditor.setNombre(txtNombre.getValue().toString());
            objEditor.setCiudad(txtCiudad.getValue().toString());
            objEditor.setPais(txtPais.getValue().toString());
            objEditor.setEstado(txtEstado.getValue().toString());
            objEditor.setDomicilio(txtDomicilio.getValue().toString());
            objEditor.setWebsite(txtWebsite.getValue().toString());
            
            logicaEditor.eliminarEditor(objEditor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El editor fue eliminado"));
            listaEditores = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", ex.getMessage()));
        }
    }
    
    public void action_modificar(){
        try {
            Editor objEditor = new Editor();
            objEditor.setIdEditor(Integer.parseInt(txtId.getValue().toString()));
            objEditor.setNombre(txtNombre.getValue().toString());
            objEditor.setCiudad(txtCiudad.getValue().toString());
            objEditor.setPais(txtPais.getValue().toString());
            objEditor.setEstado(txtEstado.getValue().toString());
            objEditor.setDomicilio(txtDomicilio.getValue().toString());
            objEditor.setWebsite(txtWebsite.getValue().toString());
            
            logicaEditor.modificarEditor(objEditor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El editor fue modificado"));
            listaEditores = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", ex.getMessage()));
        }
    }
    
    public void limpiar(){
        txtId.setValue("");
        txtNombre.setValue("");
        txtCiudad.setValue("");
        txtPais.setValue("");
        txtEstado.setValue("");
        txtDomicilio.setValue("");
        txtWebsite.setValue("");
        
        txtId.setDisabled(false);
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
    }
    
    // Para seleccionar los campos automaticamente de las filas de la tabla
    public void onRowSelect(SelectEvent evento){
        Editor editorSeleccionado = (Editor) evento.getObject(); //obtenemos el objeto autor de la fila seleccionada
        txtId.setValue(editorSeleccionado.getIdEditor());
        txtNombre.setValue(editorSeleccionado.getNombre());
        txtCiudad.setValue(editorSeleccionado.getCiudad());
        txtPais.setValue(editorSeleccionado.getPais());
        txtEstado.setValue(editorSeleccionado.getEstado());
        txtDomicilio.setValue(editorSeleccionado.getDomicilio());
        txtWebsite.setValue(editorSeleccionado.getWebsite());
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
        txtId.setDisabled(true);
    }
}
