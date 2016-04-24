/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Editor;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Local
public interface LogicaEditorLocal {
    public void registrarEditor(Editor miEditor) throws Exception;
    public void modificarEditor(Editor miEditor) throws Exception;
    public void eliminarEditor(Editor miEditor) throws Exception;
    public List<Editor> consultarTodos() throws Exception;
    
}
