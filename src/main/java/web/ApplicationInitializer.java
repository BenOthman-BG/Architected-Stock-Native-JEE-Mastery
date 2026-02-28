 /*i understand now the work


we create a listner for separed the rule of controling

no controle for servlet , to avoid the problems of modification in dao -> needs modification in servlet

(in here just applicate that we use ioc )


but how ?


we create a class that is a listner -> the rule is creating the object by interface , the couplage

and we save in in countainer , bu key + object


in servlet when he need the object -> just tell us the key , we give it bu DI we injected the object into it */


package web;

	import javax.servlet.ServletContextEvent;
	import javax.servlet.ServletContextListener;
	import javax.servlet.annotation.WebListener;
	import dao.IProduitDAO;
	import dao.ProduitDaoImpl;
     
	// notation for tell tomcat that it is a listener class 
	@WebListener
	// implements 2 methods : contectINI -> for singleton (create this object one ) , contextDest -> when ewe need to stop the server 
	public class ApplicationInitializer implements ServletContextListener {

	    @Override
	    public void contextInitialized(ServletContextEvent sce) {
	        System.out.println("--- IoC Container: Initializing Dependencies ---");
            // it well create one (by interface )
	        IProduitDAO dao = new ProduitDaoImpl();
            //save the object in the box (key + object ) -> the injector 
	        sce.getServletContext().setAttribute("daoService", dao);
	        
	        System.out.println("--- DI: IProduitDAO has been injected into ServletContext ---");
	    }

	    @Override
	    public void contextDestroyed(ServletContextEvent sce) {
	        
	    }
	    
}
	

