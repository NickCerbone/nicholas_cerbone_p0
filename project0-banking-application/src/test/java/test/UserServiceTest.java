package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dao.UserDao;
import exceptions.SystemException;
import model.UserPojo;
import service.UserService;
import service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTest {

	@Mock
	private UserDao daoMock;

	@BeforeAll
	public void testRegister(UserPojo userPojo) throws SystemException {
		UserPojo sendPojo = new UserPojo(1, "test password");
		UserPojo returnPojo = new UserPojo(1, "test password");

		try {
			when(daoMock.register(sendPojo)).thenReturn(returnPojo);
		} catch (SystemException e) {
			System.out.println(e.getMessage());
		}

		UserService userService = new UserServiceImpl();

		UserPojo expectedPojo = new UserPojo(1, "test password");
		UserPojo theActualReturnPojo = null;

		try {
			theActualReturnPojo = userService.register(sendPojo);
		} catch (SystemException e) {
			System.out.println(e.getMessage());
		}

		assertEquals(expectedPojo, theActualReturnPojo);
	}

	@Test
	public void testValidateUser(UserPojo userPojo) throws SystemException {
		UserPojo sendPojo = new UserPojo(1, "test password");
		UserPojo returnPojo = new UserPojo(1, "test password");

		when(daoMock.validateUser(sendPojo)).thenReturn(returnPojo);

		UserService userService = new UserServiceImpl();

		UserPojo expectedPojo = new UserPojo(1, "test password");
		UserPojo theActualReturnPojo = null;

		theActualReturnPojo = userService.validateUser(sendPojo);

		if (theActualReturnPojo == expectedPojo) {
			System.out.println("Logging in ...");
		} else {
			theActualReturnPojo = null;
		}

		assertEquals(expectedPojo, theActualReturnPojo);

	}

	@BeforeEach
	public void testGetDbUserId(String getPassword) throws SystemException {
		String getStringPassword = "test password";
		int returnUserId = 1;

		try {
			when(daoMock.getDbUserId(getStringPassword)).thenReturn(returnUserId);
		} catch (SystemException e) {
			System.out.println(e.getMessage());
		}

		UserService userService = new UserServiceImpl();

		int expected = 12;
		int theActualReturn = 0;

		try {
			theActualReturn = userService.getDbUserId(getStringPassword);
		} catch (SystemException e) {
			System.out.println(e.getMessage());
		}

		assertEquals(expected, theActualReturn);
	}

}
