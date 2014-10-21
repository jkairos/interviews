package com.studies.tree.bst;

public class Coordinates implements Comparable<Coordinates>{
	private Integer x;
	private Integer y;
	
	public Coordinates(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + x.hashCode() +
				y.hashCode() + (x+y);
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Coordinates){
			Coordinates c = (Coordinates)obj;
			if(c.getX() == x && c.getY() == y){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
    
	public int compareTo(Coordinates o) {
		Coordinates thisCoord = this;
		
		Integer xComp = thisCoord.getX().compareTo(o.getX());
		Integer yComp = thisCoord.getY().compareTo(o.getY());
		
		if(xComp!=0){
			return xComp;
		}else{
			return yComp;
		}
		
	}
	
}
