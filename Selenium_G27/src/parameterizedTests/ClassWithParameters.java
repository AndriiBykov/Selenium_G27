package parameterizedTests;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ClassWithParameters {

	private String testData1;
	private int testData2;

	public ClassWithParameters(String data1, int data2) {
		this.testData1 = data1;
		this.testData2 = data2;
	}
	
	@Parameters
    public static Collection<Object[]> testData() {
      Object[][] data = new Object[][] { 
    	  {"A", 11}, 
    	  {"B", 22}, 
    	  {"C",33}
      };
      return Arrays.asList(data);
    }
    
    @Test
    public void test() {
    	System.out.println(testData1);
    	System.out.println(testData2);
    }
    
    @Before
    public void before() {
    	System.out.println("--------------");
    }
    
    @After
    public void after() {
    	System.out.println("--------------");
    }

}
