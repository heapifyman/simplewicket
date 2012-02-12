package org.heapifyman.next;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxFallbackLink;
import org.apache.wicket.extensions.rating.RatingPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.heapifyman.HomePage;
import org.heapifyman.model.TestEntity;

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

	private int counter = 0;

	private String tags = "eins,zwei,drei";

	private TestEntity testEntity = new TestEntity(Integer.valueOf(2));

	public MightBeWorkingPage() {

		logger.debug("starting MightBeWorkingPage");

		// home link
		add(new Link<HomePage>("home") {

			private static final long serialVersionUID = -8795500883865254328L;

			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}

		});

		// link to update counter via ajax
		final Label ajaxLabel = new Label("ajaxLabel",
				new PropertyModel<Integer>(this, "counter"));
		ajaxLabel.setOutputMarkupId(true);
		add(ajaxLabel);

		add(new AjaxLink<Void>("ajaxLink") {

			private static final long serialVersionUID = -8573529242165195949L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				counter++;
				logger.info("updated counter to: " + counter);
				target.add(ajaxLabel);
			}

		});

		// tags form with jquery tags plugin
		final Form<MightBeWorkingPage> form = new Form<MightBeWorkingPage>(
				"tagForm", new CompoundPropertyModel<MightBeWorkingPage>(this));
		add(form);
		final TextField<String> tagsTextField = new TextField<String>("tags");
		form.add(tagsTextField.setOutputMarkupId(true));
		form.add(new IndicatingAjaxButton("saveButton", form) {

			private static final long serialVersionUID = -3901377832995484253L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				logger.debug(tags);
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				logger.debug("D'oh");
			}
		});

		// a simple rating panel
		final WebMarkupContainer ratingContainer = new WebMarkupContainer(
				"ratingContainer");
		add(ratingContainer.setOutputMarkupId(true));
		final RatingPanel ratingPanel = new RatingPanel("rating",
				new PropertyModel<Integer>(testEntity, "rating"), 5, true) {

			private static final long serialVersionUID = 5817477738459737492L;

			@Override
			protected void onRated(int rating, AjaxRequestTarget target) {
				testEntity.setRating(Integer.valueOf(rating));
				target.add(ratingContainer);
			}

			@Override
			protected boolean onIsStarActive(int star) {
				return star < testEntity.getRating().intValue();
			}
		};
		ratingContainer.add(ratingPanel);

		ratingContainer.add(new IndicatingAjaxFallbackLink<Void>(
				"clearRatingLink") {

			private static final long serialVersionUID = 8851522681375240068L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				testEntity.setRating(Integer.valueOf(0));
				target.add(ratingContainer);
			}

		});

	}
}
