package com.teamsp26_1;

public class Assignment1 {
    public static void main(String args[]) {
		User u, v;
		
		u = new User("Student1");
		System.out.println(u.equals(u));
		System.out.println();
		
		u = new User("Student1");
		System.out.println(u.equals(null)); 
		System.out.println();
		
		u = new User("Student1");
		System.out.println(u.equals("Student1")); 
		System.out.println();
		
		u = new User("Student1");
		v = new SpecialUser("Student1", 5);
		System.out.println(u.equals(v)); 
		System.out.println(v.equals(u)); 
		System.out.println();
		
		u = new User("Student1");
		v = new User(null);
		System.out.println(v.equals(u)); 
		System.out.println();
		
		u = new User("Student1");
		v = new User(null);
		System.out.println(u.equals(v)); 
		System.out.println();
		
    }
}

