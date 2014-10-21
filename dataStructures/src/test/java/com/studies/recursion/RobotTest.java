package com.studies.recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testFindPath() {
		int[][] array = new int[6][6];
		for(int i= 0; i < array.length; i++){
			for(int j= 0; j < array.length; j++){
				if((i==3 && j == 1) || (i==1 && j == 2)|| (i==3 && j == 3)){
					array[i][j] = -1;
				}else{
					array[i][j] = 1;
				}
				
			}
			
		}
		Robot robot = new Robot();
		System.out.println(robot.findPath(array));
		assertEquals(45, robot.findPath(array));
	}
	

}
