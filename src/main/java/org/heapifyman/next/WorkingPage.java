package org.heapifyman.next;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.heapifyman.HomePage;

/**
 * 
 */
public class WorkingPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 96565711013315035L;
	private static transient final Logger logger = Logger
			.getLogger(WorkingPage.class);
	
	public WorkingPage() {
		
		add(new Link<HomePage>("home") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 5801641778425637198L;

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
			
		});
		
		logger.info("rendering " + this.getClass().getName());
		logger.info("*********************TEST**************************");
		
	}
}
