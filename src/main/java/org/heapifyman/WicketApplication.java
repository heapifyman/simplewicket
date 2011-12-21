package org.heapifyman;

import org.apache.wicket.protocol.http.WebApplication;
import org.heapifyman.next.NextPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see org.heapifyman.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// mount pages to restful links
		mountPage("/home", HomePage.class);
		mountPage("/next", NextPage.class);
	}
}
