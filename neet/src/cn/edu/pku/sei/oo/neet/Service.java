package cn.edu.pku.sei.oo.neet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class Service {

    public static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

    public void start() throws Exception {

        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("OpenPlatformNotifyService initializing");
            }
            initWebservice();

        } catch (Exception e) {
            LOGGER.error("start error:", e);
        }
    }

    private void initWebservice() throws Exception {
        int port = 8899;
        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/api");
        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages", "package cn.edu.pku.sei.oo.neet.api");        
        context.addServlet(sh, "/*");
        
        ResourceHandler resoursehandler = new ResourceHandler();
        resoursehandler.setDirectoriesListed(true);
        resoursehandler.setWelcomeFiles(new String[]{"index.html"});
        resoursehandler.setResourceBase("./WebContent");
        
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{context,resoursehandler});
        server.setHandler(handlers);
        server.start();
        server.join();
    }

    public void stop() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        Service server = new Service();
        server.start();
    }

}