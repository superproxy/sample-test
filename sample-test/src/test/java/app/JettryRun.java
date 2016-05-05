package app;

import org.eclipse.jetty.server.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class JettryRun {

    public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		WebAppContext context = new WebAppContext();
		context.setContextPath("/myapp");
		context.setDescriptor("/WEB-INF/web.xml");
		context.setResourceBase("/");
		context.setParentLoaderPriority(true);

		server.start();
		server.join();
    }
}