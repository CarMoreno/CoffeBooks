/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Editor;

/**
 *
 * @author Carlos Andrés Moreno
 */
@Local
public interface EditorFacadeLocal {

    void create(Editor editor);

    void edit(Editor editor);

    void remove(Editor editor);

    Editor find(Object id);

    List<Editor> findAll();

    List<Editor> findRange(int[] range);

    int count();
    
}
