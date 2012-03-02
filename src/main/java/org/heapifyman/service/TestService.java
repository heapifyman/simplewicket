/**
 * 
 */
package org.heapifyman.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.heapifyman.model.TestEntity;

/**
 * @author philip
 * 
 */
@Path("test")
public class TestService {

	private final TestEntity[] all = new TestEntity[] { new TestEntity("1", 1),
			new TestEntity("2", 2) };

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TestEntity> getAll() {
		return Arrays.asList(all);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TestEntity getById(@PathParam("id") Integer id) {
		if (id > all.length) {
			throw new WebApplicationException(Status.NOT_FOUND);
		} else {
			return all[id - 1];
		}
	}

}
