package gov.nyc.buildings.strategic.dataanalysis.qmatic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofMillis;

@RunWith(JUnitPlatform.class)
public class TestBranch {
	private static Branch branch1 = new Branch();
	private Branch branch2 = new Branch();
		
	
	@BeforeAll
	static void initAll(){
		branch1.setName("Bronx");
		branch1.setId(2);
	}
	
	@BeforeEach
	void init(){
		branch2.setName("Queens");
		branch2.setId(1);
	}
	
	@Test
	@DisplayName("testing branch 2 name and id")
	void branch2Test(){
		assertEquals("Queens", branch2.getName());
	}
	
	@Test
	@DisplayName("testing branch 1 name and id")
	void branch1Test(){
		assertEquals("Bronx", branch1.getName(), "to test branch Name");
	}
	
	@Test
	@DisplayName("Assert all")
	void allTest(){
		assertAll("Test all", ()-> assertEquals("Bronx", branch1.getName()), ()-> assertEquals("Queens", branch2.getName()));
	}
	
	@Test
    void exceptionTesting() {
        assertThrows(NullPointerException.class, () -> {
            System.out.println((new Branch()).getName().length());
        });
    }
	
	@Test
    void assertTimeOut() {
        assertTimeout(ofMillis(2), ()->{System.out.println("print this line should be less then 2 mins"); Thread.sleep(1);});
    }
	
	@AfterEach
	void tearDown(){
		
	}
	
	@AfterAll
	static void tearDownAll(){
		
	}
	
	
	

}
