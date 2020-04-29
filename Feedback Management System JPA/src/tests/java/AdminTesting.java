import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.feedback.dao.AdminDAO;
import com.cg.feedback.dao.AdminDAOImpl;
import com.cg.feedback.dao.ProgramDAO;
import com.cg.feedback.dao.ProgramDAOImpl;
import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.exceptions.CustomException;
import com.cg.feedback.service.AdminService;
import com.cg.feedback.service.AdminServiceImpl;

public class AdminTesting {
	
	private static AdminDAO admin;
	private static ProgramDAO program;
	
	@BeforeClass
	public static void startTesting() {
		System.out.println("Initialing DAO to begin Testing!");
		admin = new AdminDAOImpl();
		program = new ProgramDAOImpl();
	}
	
	@AfterClass
	public static void stopTesting() {
		System.out.println("Destroying DAOt to end Testing!");
		admin = null;
		program = null;
	}
	
	@Test
	public void testAdminValidLogin() {
		assertTrue(admin.validateAdmin("ADM101", "admin1+2=3"));
	}
	
	@Test(expected = CustomException.class)
	public void testAdminInvalidLogin() {
		assertFalse(admin.validateAdmin("ADM101", "admin"));
	}
	
	@Test
	public void testAvailableBatches() {
		assertTrue(admin.availableBatches().contains("A")&&admin.availableBatches().contains("B"));
	}
	
	@Test
	public void testAssignCourseToBatch() {
		BatchCourseDTO batch =new BatchCourseDTO();
		batch.setBatch("F");
		batch.setCourseId("CRS103");
		admin.assignCourseToBatch(batch);
		assertTrue(admin.availableBatches().contains("F"));
	}
	
	@Test(expected = CustomException.class)
	public void testAssignCourseToBatchWhereBatchIsRepeated() {
		assertFalse(admin.assignCourseToBatch(new BatchCourseDTO("CRS103", "A")));
	}
	
	@Test
	public void testProgramsPresent() {
		assertTrue(program.getPrograms().size()!=0);
	}
	
	@Test
	public void testProgramDTO() {
		assertTrue(program.getProgram("PRG101").getClass().equals(ProgramDTO.class));
	}
}
