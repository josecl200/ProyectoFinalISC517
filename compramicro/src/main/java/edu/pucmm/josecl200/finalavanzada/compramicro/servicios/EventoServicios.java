package edu.pucmm.josecl200.finalavanzada.compramicro.servicios;
import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Evento;
import edu.pucmm.josecl200.finalavanzada.compramicro.repositorios.EventoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServicios {
    @Autowired
    private EventoRepo repo;
    public void createEventos(){
        Evento preBoda=new Evento();
        Evento boda=new Evento();
        Evento cumple=new Evento();
        Evento video=new Evento();
        preBoda.setNombre("Pre-Boda");
        preBoda.setPrecio((float) 1000.00);
        boda.setNombre("Boda");
        boda.setPrecio((float) 5000.00);
        cumple.setNombre("Cumpleaños");
        cumple.setPrecio((float) 3000.00);
        video.setNombre("Video de evento");
        video.setPrecio((float) 4000.00);
        repo.save(preBoda);
        repo.save(boda);
        repo.save(cumple);
        repo.save(video);
    }
    public List<Evento> getEventos(){
        return repo.findAll();
    }

}
