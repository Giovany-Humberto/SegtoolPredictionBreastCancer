/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segtoolpredictionbreastcancer;

import javax.swing.JOptionPane;

/**
 *
 * @author Ingenieria
 */
public class seguridadLogin {
    
    frmSesion login = new frmSesion();
    String mensaje;
    
    public void validaUsuario(String usuarios[], String user, String pwd, int intento){
        boolean encontrado = false;
        
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].equalsIgnoreCase(user) && usuarios[i+1].equals(pwd)) {
                mensaje = "Bienvenido: " + user;
                encontrado = true;
                JOptionPane.showMessageDialog(null, mensaje,"Inicio de Sesion", JOptionPane.INFORMATION_MESSAGE);
                intento = 0;
                login.setIntento(intento);
                new frmPredictionBreastCancer().setVisible(true);
                break;
            }
        }
        
        if (encontrado == false) {
            mensaje = "Usuario o Password incorrectos llevas " + intento + " intentos fallidos.";
            JOptionPane.showMessageDialog(null, mensaje,"Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
         }
        
        if (intento > 2) {
            JOptionPane.showMessageDialog(null, "3 intentos fallidos, la aplicación se cerrará.","Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
    }
}
