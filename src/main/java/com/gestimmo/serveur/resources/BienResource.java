package com.gestimmo.serveur.resources;

import com.gestimmo.metier.dao.BienDao;
import com.gestimmo.metier.model.Bien;
import com.gestimmo.serveur.processes.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.*;

import java.util.HashMap;
import java.util.Map;

public class BienResource extends ServerResource {
BienDao bienDao = new BienDao();

	@Get
	public Representation voir() {
		Bien tt = new Bien();
			tt.setEnergie('A');
			tt.setAdresse("Adresse");
			tt.setCodePostal("CodePostal");
			tt.setNbPieces(666);
			tt.setSurface(666);
			tt.setTailleGarage(0);
			tt.setTailleVeranda(0);
			tt.setVille("CorsicaCityBeach");
			
		bienDao.saveOrUpdate(tt);
		String title = "Voir un bien !!!";
		Bien unBien = (Bien)bienDao.find(Bien.class, 1);
		Map<String, Object> donnees = new HashMap<String, Object>();
		donnees.put("pageTitle", title);
		donnees.put("bien", unBien);
		return TemplateRepresentation.createNew("voirBien.ftl", getContext()).with( donnees );
	}
	@Post
	public Representation mettreAjour() {
		String title = "MaJ du bien !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}
	@Put
	public Representation creer() {
		String title = "Page des biens !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}
	@Delete
	public Representation supprimer() {
		String title = "Page des biens !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}
}
