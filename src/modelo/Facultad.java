/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Favio
 */
public class Facultad  implements Serializable {
    private String nombrefacultad;

    public Facultad(String nombrefacultad) {
        this.nombrefacultad = nombrefacultad;
    }

    public String getNombrefacultad() {
        return nombrefacultad;
    }

    public void setNombrefacultad(String nombrefacultad) {
        this.nombrefacultad = nombrefacultad;
    }

    @Override
    public String toString() {
        return nombrefacultad;
    }
}
