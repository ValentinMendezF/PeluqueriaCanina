
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;


public class ControladoraPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Mascota mascota, Duenio duenio) {
        
        duenioJpa.create(duenio);
        
        mascotaJpa.create(mascota);
        
    }
}
