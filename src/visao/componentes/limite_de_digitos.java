package visao.componentes;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class limite_de_digitos extends PlainDocument{
    private int limit;
    
    public limite_de_digitos(int limit){
        super();
        this.limit = limit;
        
    }
    
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
        
        if(str == null)
            return;
        
        if((getLength()+ str.length()) <= limit){
        super.insertString(offset, str, attr);
    }
        
        
    }
    
    
  
    
    
}
