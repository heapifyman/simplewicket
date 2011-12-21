/**
 * 
 */
package org.heapifyman;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.heapifyman.next.NotWorkingPage;
import org.heapifyman.next.WorkingPage;

/**
 * 
 */
public class HomePage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -885191805883682444L;
	
	@SuppressWarnings("unused")
	private static transient final Logger logger = Logger
			.getLogger(HomePage.class);

	public HomePage() {

		add(new Link<NotWorkingPage>("link1") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 604911481741031692L;

			@Override
			public void onClick() {
				setResponsePage(WorkingPage.class);
			}
		});

		add(new Link<NotWorkingPage>("link2") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 6487948509651294490L;

			@Override
			public void onClick() {
				setResponsePage(NotWorkingPage.class);
			}
		});

	}

}
