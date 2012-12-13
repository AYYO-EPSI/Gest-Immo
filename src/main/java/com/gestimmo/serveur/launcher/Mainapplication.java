package com.gestimmo.serveur.launcher;

import com.gestimmo.serveur.resources.BienResource;
import com.gestimmo.serveur.resources.DefaultResource;
import com.gestimmo.serveur.resources.HandlerHibernate;
import com.gestimmo.serveur.resources.LocationResource;
import freemarker.template.Configuration;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.Reference;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class Mainapplication extends Application {

	@Override
	public synchronized void start() throws Exception {
		super.start();
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(getClass(), "/webPages");
		getContext().getAttributes().put("org.freemarker.Configuration", configuration);
	}

	@Override
	public synchronized Restlet createInboundRoot() {
		final Router router = new Router(getContext());

		attachRessources(router);

		router.attachDefault(DefaultResource.class);
		hibernateHandling(router, "/bien/{bienId}", BienResource.class);
		hibernateHandling(router, "/location", LocationResource.class);

		return router;
	}

	private void hibernateHandling(final Router router, final String urlMapped, final Class laClasseAttachee) {

		final HandlerHibernate hibernateHandler = new HandlerHibernate(getContext());

		hibernateHandler.setNext(laClasseAttachee);

		router.attach(urlMapped, hibernateHandler);
	}

	private void attachRessources(final Router router) {
		router.attach("/images", new Directory(getContext(), new Reference("clap://system/webRessources/images")));
		router.attach("/js", new Directory(getContext(), new Reference("clap://system/webRessources/js")));
		router.attach("/styles", new Directory(getContext(), new Reference("clap://system/webRessources/styles")));
	}
}