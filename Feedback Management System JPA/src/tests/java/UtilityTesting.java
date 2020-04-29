import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.Parameterized.Parameters;

import com.cg.feedback.exceptions.CustomException;
import static com.cg.feedback.utility.Validator.*;
import static com.cg.feedback.utility.GeneratePassKey.generatePass;

public class UtilityTesting {
	
	@Test
	public void testValidAdminID() {
		assertTrue(isValidAdminId("ADM101"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidAdminIDWithLowerCaseCharacters() {
		assertFalse(isValidAdminId("Adm101"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidAdminIDWithShortLength() {
		assertFalse(isValidAdminId("ADM10"));
	}
	
	@Test
	public void testValidStudentID() {
		assertTrue(isValidStudentId("STD101"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidStudentIDWithLowerCaseCharacters() {
		assertFalse(isValidAdminId("Std102"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidStudentIDWithShortLength() {
		assertFalse(isValidAdminId("STD10"));
	}

	@Test
	public void testValidTrainerID() {
		assertTrue(isValidTrainerId("TRN101"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidTrainerIDWithLowerCaseCharacters() {
		assertFalse(isValidTrainerId("trn101"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidTrainerIDWithShortLength() {
		assertFalse(isValidTrainerId("TRN"));
	}
	
	@Test
	public void testValidProgramID() {
		assertTrue(isValidProgramId("PRG101"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidProgramIDWithLowerCaseCharacters() {
		assertFalse(isValidProgramId("prg102"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidProgramIDWithShortLength() {
		assertFalse(isValidProgramId("PRG1"));
	}
	
	@Test
	public void testValidPassword() {
		assertTrue(isValidPassword("omgupta@1"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidPasswordWithUnsupportedCharacters() {
		assertFalse(isValidPassword("anantha-goel"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidPasswordWithShortLength() {
		assertFalse(isValidPassword("admin"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidPasswordWithLongLength() {
		assertFalse(isValidPassword("adminismyusernameanditisverylong"));
	}
	
	@Test
	public void testValidName() {
		assertTrue(isValidName("Om Gupta"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidNamewithLowercaseCharacters() {
		assertFalse(isValidName("om gupta"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidNamewithUppercaseCharacters() {
		assertFalse(isValidName("OM GUPTA"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidNamewithInvalidCharacters() {
		assertFalse(isValidName("Om Gupta11"));
	}
	
	@Test
	public void testValidEmail() {
		assertTrue(isValidEmail("ogupta261@gmail.com"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidEmailWithExtraSeperators() {
		assertFalse(isValidEmail("ogupta2@@gmail.com"));
	}
	
	@Test(expected = CustomException.class)
	public void testInvalidEmailWithlessSeperators() {
		assertFalse(isValidEmail("ogupta2@gmailcom"));
	}
	
	@Test
	public void testValidPassKeyGenerate() {
		assertEquals("508507-4290", generatePass("Rahul Verma", "TRN101").split("-")[0]+"-"+generatePass("Rahul Verma", "TRN101").split("-")[2]);
	}
}
