package org.heapifyman.next;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.heapifyman.HomePage;

public class NextPage extends WebPage {

	private static final long serialVersionUID = 310242843705925911L;

	private static transient final Logger logger = Logger
			.getLogger(NextPage.class);
	
	public NextPage() {
		
		add(new Link<HomePage>("home") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1262709193993270137L;

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
			
		});
		
		logger.info("rendering " + this.getClass().getName());
		logger.info("*********************TEST**************************");
		
//		List<IColumn<String>> columns = new ArrayList<IColumn<User>>();
//		columns.add(new PropertyColumn<User>(new Model<String>("ID"), "id",
//				"id"));
//		columns.add(new PropertyColumn<User>(new Model<String>("Firstname"),
//				"firstname", "firstname"));
//		columns.add(new PropertyColumn<User>(new Model<String>("Name"), "name",
//				"name"));
//		columns.add(new PropertyColumn<User>(new Model<String>("E-Mail"),
//				"email", "email"));
//		add(new AjaxFallbackDefaultDataTable<User>("table", columns,
//				new UserSortableDataProvider(), 10));
	}
}
