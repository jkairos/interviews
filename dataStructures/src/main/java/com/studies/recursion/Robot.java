package com.studies.recursion;
/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. 
 * The robot can only move in two directions: right and down. 
 * How many possible paths are there for the robot?
 * 
 * 
 * FOLLOW UP
 * 
 * Imagine certain squares are “off limits”, such that the robot can not step on them. 
 * Design an algorithm to get all possible paths for the robot.
 */
public class Robot {
	
	public int findPath(int a[][]){
		return this.findPath(a, a.length, 0, 0);
	}
	
	private int findPath(int a[][],int n,int i,int j){
	    int right=0,down=0;
	    
	    if(i==n-1 && j==n-1)          //reached destination
	        return 1;
	    if(j+1<n && a[i][j+1]!=-1)    // is Right Possible
	        right=findPath(a, n, i, j+1);
	    if(i+1<n && a[i+1][j]!=-1)    //  is Down Possible
	        down=findPath(a,n,i+1,j);
	    return right+down;
	}
}