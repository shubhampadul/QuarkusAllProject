package clover.infotech.resource;

import java.util.List;

import clover.infotech.entity.Student;
import clover.infotech.repo.StudentRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Student")
public class StudentResource {
	
	@Inject
	private StudentRepo studentRepo;
	
	
	  @Consumes(MediaType.APPLICATION_JSON)
	  
	  @Produces(MediaType.APPLICATION_JSON)
	  
	  @Transactional 
	  public Response registerStudentDetails(Student student) {
	  
	  try { 
		  studentRepo.persist(student); 
		  return Response.status(Response.Status.CREATED).entity(student).build();
		  } 
	  catch(Exception e) {
		  e.printStackTrace(); return
	      Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	      .entity("Error creating student: " + e.getMessage()) .build(); 
		  }
	  }
	 
	
		/*
		 * @GET
		 * 
		 * @Path("/getStudentList")
		 * 
		 * @Produces(MediaType.APPLICATION_JSON) public Response fetchStudentList(){
		 * List<Student> studentList = studentRepo.listAll();
		 * 
		 * return Response.ok(studentList).build(); }
		 */
}
