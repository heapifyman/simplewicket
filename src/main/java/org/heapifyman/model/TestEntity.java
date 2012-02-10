/**
 * 
 */
package org.heapifyman.model;

import java.io.Serializable;

/**
 * @author reimer
 *
 */
public class TestEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4458637319267826418L;
	
	private Integer rating;

	/**
	 * @param rating
	 */
	public TestEntity(Integer rating) {
		super();
		this.rating = rating;
	}

	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
