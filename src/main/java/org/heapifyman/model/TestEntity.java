/**
 * 
 */
package org.heapifyman.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author reimer
 *
 */
@XmlRootElement
@Entity
@Table(name = "test_entity")
public class TestEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4458637319267826418L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String name;
	
	private Integer rating;

	/**
	 * 
	 */
	public TestEntity() {
		super();
	}

	/**
	 * @param name
	 * @param rating
	 */
	public TestEntity(String name, Integer rating) {
		super();
		this.name = name;
		this.rating = rating;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
