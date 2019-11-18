package URLify;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class URLifyTest {
	@Test
	public void URLify() {
		char[] input = "Mr John Smith    ".toCharArray();
		char[] output = "Mr%20John%20Smith".toCharArray();
		
		System.out.println(input);
		URLify.URLify(input, 13);
		System.out.println(input);
		
		assertEquals(true, Arrays.equals(output, input));
		
		input = "Mr  John  Smith        ".toCharArray();
		output = "Mr%20%20John%20%20Smith".toCharArray();
		
		System.out.println(input);
		URLify.URLify(input, 15);
		System.out.println(input);
		
		assertEquals(true, Arrays.equals(output, input));
		
		input = "".toCharArray();
		output = "".toCharArray();
		
		System.out.println(input);
		URLify.URLify(input, 0);
		System.out.println(input);
		
		assertEquals(true, Arrays.equals(output, input));
		
		input = "   ".toCharArray();
		output = "   ".toCharArray();
		
		System.out.println(input);
		URLify.URLify(input, 0);
		System.out.println(input);
		
		assertEquals(true, Arrays.equals(output, input));
		
		input = "a  c  d        ".toCharArray();
		output = "a%20%20c%20%20d".toCharArray();
		
		System.out.println(input);
		URLify.URLify(input, 7);
		System.out.println(input);
		
		assertEquals(true, Arrays.equals(output, input));
	}
}
