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
public class NextPage extends WebPage {

	private static final long serialVersionUID = 310242843705925911L;
	
	private static transient final Logger logger = Logger
			.getLogger(NextPage.class);
	
	private static final String[] data = new String[] { "one", "two", "three" };
	
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
		
		List<IColumn<String>> columns = new ArrayList<IColumn<String>>();
		columns.add(new AbstractColumn<String>(new Model<String>("column1")) {

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
		add(new AjaxFallbackDefaultDataTable<String>("table", columns,
				new MySortableDataProvider(), 10));
	}
	
	/**
	 * 
	 */
	private class MySortableDataProvider extends SortableDataProvider<String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8010620684177096713L;

		/* (non-Javadoc)
		 * @see org.apache.wicket.markup.repeater.data.IDataProvider#iterator(int, int)
		 */
		@Override
		public Iterator<? extends String> iterator(int first, int count) {
			return Arrays.asList(data).subList(first, first + count).iterator();
		}

		/* (non-Javadoc)
		 * @see org.apache.wicket.markup.repeater.data.IDataProvider#size()
		 */
		@Override
		public int size() {
			return data.length;
		}

		/* (non-Javadoc)
		 * @see org.apache.wicket.markup.repeater.data.IDataProvider#model(java.lang.Object)
		 */
		@Override
		public IModel<String> model(String object) {
			return new Model<String>(object);
		}
		
	}
}
