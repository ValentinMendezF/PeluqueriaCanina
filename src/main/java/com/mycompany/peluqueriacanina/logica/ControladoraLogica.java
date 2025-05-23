
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;


public class ControladoraLogica {
    
    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String alergico,
            String atencionEspecial, String nombreDuenio, String celularDuenio, String observaciones) {
        
        Duenio duenio = new Duenio();
        
        duenio.setNombreDuenio(nombreDuenio);
        duenio.setCelularDuenio(celularDuenio);
        
        Mascota mascota = new Mascota();
        
        mascota.setNombreMascota(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEspecial);
        mascota.setDuenio(duenio);
        mascota.setObservaciones(observaciones);
        
        controladoraPersistencia.guardar(mascota, duenio);
    }

    public List<Mascota> traerDatos() {
        return controladoraPersistencia.traerDatos();
    }

    public void eliminarDatos(int numeroMascota) {
        controladoraPersistencia.eliminarDatos(numeroMascota);
    }

    public Mascota traerMascota(int numeroMascota) {
        return controladoraPersistencia.traerMascota(numeroMascota);
    }

    public void modificarMascota(Mascota mascota, String nombreMascota, String raza, String color, String alergico,
            String atencionEspecial, String nombreDuenio, String celularDuenio, String observaciones) {
        
        mascota.setNombreMascota(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEspecial);
        mascota.setObservaciones(observaciones);
        
        controladoraPersistencia.modificarMascota(mascota);
        
        Duenio duenio = this.buscarDuenio(mascota.getDuenio().getIdDuenio());
        
        duenio.setNombreDuenio(nombreDuenio);
        duenio.setCelularDuenio(celularDuenio);
        
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int idDuenio) {
        return controladoraPersistencia.buscarDuenio(idDuenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controladoraPersistencia.modificarDuenio(duenio);
    }

    

    
    
}
