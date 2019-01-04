/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.io.Serializable;

/**
 *
 * @author Adrian
 */
public class NrTel implements Serializable {

    static NrTel valueOf(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    String numar;
    
    public NrTel(String nr){
        if(nr.matches("[0-9]+") && nr.length() == 10){
            numar = nr;
        }
        else{ 
            throw new IllegalArgumentException("Numar invalid!");
        }
    }
    @Override
    public String toString(){
        return numar;
    }
}
