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
public class Abonat implements Serializable {
    String nume;
    String prenume;
    String CNP;
    NrTel nr;
    
    public Abonat(String n,String p,String cnp,NrTel nr){
        nume=n;
        prenume=p;
        CNP=cnp;
        this.nr=nr ; 
       if(n == null || n.length()==0){
            throw new IllegalArgumentException("Numele nu poate lipsi!");
        }
        if(!n.matches("^[A-Za-z0-9\\- ]+$")){
            throw new IllegalArgumentException("Numele nu pare de om!");
        } 
    
        if(p == null || p.length()==0){
            throw new IllegalArgumentException("Prenumele nu poate lipsi!");
        }
        if(!p.matches("^[A-Za-z0-9\\- ]+$")){
            throw new IllegalArgumentException("Prenumele nu pare de om!");
        } 
    
        if(!cnp.matches("[0-9]+") || !(cnp.length() == 13)){
             throw new IllegalArgumentException("CNP invalid");
        }
        
        
    }
    @Override
    public String toString(){
        return "Abonati "+nume+" "+prenume+"CNP "+CNP+"Nr. Telefon "+nr;
    }
    
    public String getNume(){
    return nume;    
    }
    
    public String getPrenume(){
    return prenume;    
    }
    
    public String getCNP(){
    return CNP;    
    }
    
    public String getNrTel(){
    return nr.numar;    
    }
    
    
}
