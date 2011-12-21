package org.heapifyman.next;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.heapifyman.HomePage;

/**
 * 
 */
public class MightBeWorkingPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 96565711013315035L;

	private static transient final Logger logger = Logger
			.getLogger(MightBeWorkingPage.class);

	private Integer counter = 0;

	public MightBeWorkingPage() {

		add(new Link<HomePage>("home") {

			/**
			 * 
			 */
			private static final long serialVersionUID = -8795500883865254328L;

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}

		});

		final Label ajaxLabel = new Label("ajaxLabel",
				new PropertyModel<Integer>(this, "counter"));
		ajaxLabel.setOutputMarkupId(true);
		add(ajaxLabel);

		add(new AjaxLink<Void>("ajaxLink") {

			/**
			 * 
			 */
			private static final long serialVersionUID = -8573529242165195949L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				counter++;
				logger.info("updated counter to: " + counter);
				target.add(ajaxLabel);
			}

		});

	}

	/**
	 * @return the counter
	 */
	public Integer getCounter() {
		return counter;
	}

	/**
	 * @param counter
	 *            the counter to set
	 */
	public void setCounter(Integer counter) {
		this.counter = counter;
	}
}
