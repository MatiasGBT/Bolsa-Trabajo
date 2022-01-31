package beans.backing;

import beans.helper.DatosHelper;
import beans.model.*;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class VacanteForm {

    @Inject
    private Candidato candidato;

    @Inject
    private DatosHelper datosHelper;

    public VacanteForm() {

    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public DatosHelper getDatosHelper() {
        return datosHelper;
    }

    public void setDatosHelper(DatosHelper datosHelper) {
        this.datosHelper = datosHelper;
    }

    public String enviar() {
        if(candidato.getProvincia().equals("Cordoba")) {
            candidato.setProvincia("Córdoba");
        }
        
        List<Oferta> ofertas = datosHelper.listar(candidato.getProvincia(), candidato.getTecnologia());
        if (!ofertas.isEmpty()) {
            candidato.setOfertas(ofertas);
            return "exito";
        } else {
            return "fallo";
        }
    }
}
