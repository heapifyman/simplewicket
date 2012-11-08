package org.heapifyman.next;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.heapifyman.HomePage;

/**
 * 
 */
public class NotWorkingPage extends WebPage {

	private static final long serialVersionUID = 310242843705925911L;

	private static transient final Logger logger = Logger
			.getLogger(NotWorkingPage.class);

	private static final String[] data = new String[15];

	public NotWorkingPage() {

		for (int i = 0; i < 15; i++) {
			data[i] = "" + i;
		}

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

		List<IColumn<String, String>> columns = new ArrayList<IColumn<String, String>>();
		columns.add(new AbstractColumn<String, String>(new Model<String>(
				"column1")) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1789220124565893657L;

			@Override
			public void populateItem(Item<ICellPopulator<String>> cellItem,
					String componentId, IModel<String> rowModel) {
				cellItem.add(new Label(componentId, rowModel.getObject()));
			}
		});
		add(new AjaxFallbackDefaultDataTable<String, String>("table", columns,
				new MySortableDataProvider(), 10));
	}

	/**
	 * 
	 */
	private class MySortableDataProvider extends
			SortableDataProvider<String, String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8010620684177096713L;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.apache.wicket.markup.repeater.data.IDataProvider#iterator(int,
		 * int)
		 */
		@Override
		public Iterator<? extends String> iterator(long first, long count) {
			logger.info("getting sublist from " + first + " to "
					+ (first + count));

			return Arrays
					.asList(data)
					.subList(Long.valueOf(first).intValue(),
							Long.valueOf(first + count).intValue()).iterator();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.apache.wicket.markup.repeater.data.IDataProvider#size()
		 */
		@Override
		public long size() {
			logger.info("size is: " + data.length);
			return data.length;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.apache.wicket.markup.repeater.data.IDataProvider#model(java.lang
		 * .Object)
		 */
		@Override
		public IModel<String> model(String object) {
			logger.info("Model is: " + object);
			return new Model<String>(object);
		}

	}
}
