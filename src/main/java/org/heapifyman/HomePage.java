/**
 * 
 */
package org.heapifyman;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.heapifyman.next.NextPage;

/**
 * 
 */
public class HomePage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 706791399202250279L;

	@SuppressWarnings("unused")
	private static transient final Logger logger = Logger
			.getLogger(HomePage.class);

	public HomePage() {

		add(new Link<NextPage>("link") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 604911481741031692L;

			@Override
			public void onClick() {
				setResponsePage(NextPage.class);
			}
		});

	}

}
