
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Mascota mascota, Duenio duenio) {
        
        duenioJpa.create(duenio);
        
        mascotaJpa.create(mascota);
        
    }

    public List<Mascota> traerDatos() {
        
        return mascotaJpa.findMascotaEntities();
        
    }

    public void eliminarDatos(int numeroMascota) {
        try {
            mascotaJpa.destroy(numeroMascota);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
