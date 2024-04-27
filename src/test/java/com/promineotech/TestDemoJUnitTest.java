package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;



class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	
	
	@ParameterizedTest
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) 
	{
		if(!expectException) {
		  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}



		assertThatThrownBy(() ->testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);		
	}
	
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	
	@Test 
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {

		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		
//		assertThat(testDemo.addPositive(4,5)).isEqualTo(8);
//		assertThat(testDemo.addPositive(40,50)).isEqualTo(80);		

		
		assertThat(testDemo.addPositive(4,-5)).isEqualTo(8);
		assertThat(testDemo.addPositive(0,50)).isEqualTo(80);		
	}
		
	
	
	private static Stream argumentsForAddPositive() 
	{
	
		Stream stream=null;
		return stream;
		
	}
	
	@Test                                               
    @DisplayName("Simple multiplication should work")   
    void testMultiply() {
		assertThat(testDemo.multiply(4,5)).isEqualTo(20);
		assertThat(testDemo.multiply(4,5)).isEqualTo(30);
    }	
	
	
	
}
