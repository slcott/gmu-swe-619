// Assignment1.rs

use crate::user::User;

pub fn run() {
    println!("Running Assignment 1 in Rust");
    println!();

    // u = new User("Student1");
    // System.out.println(u.equals(u));
    let u = User::new_regular(Some("Student1"));
    println!("{}", u == u);
    println!();

    // In Java, u.equals(null) is false.
    // In Rust, we can't compare a User with None directly.
    println!("// In Java, u.equals(null) is false. In Rust, you can't compare a User with None directly.");
    println!();

    // In Java, u.equals("Student1") is false.
    // In Rust, you can't compare a User with a &str directly.
    println!("// In Java, u.equals(\"Student1\") is false. In Rust, you can't compare a User with a &str directly.");
    println!();

    // u = new User("Student1");
    // v = new SpecialUser("Student1", 5);
    // System.out.println(u.equals(v));
    // System.out.println(v.equals(u));
    let u = User::new_regular(Some("Student1"));
    let v = User::new_special(Some("Student1"), 5);
    println!("{}", u == v); // Regular == Special
    println!("{}", v == u); // Special == Regular
    println!();

    // u = new User("Student1");
    // v = new User(null);
    // System.out.println(v.equals(u));
    let u = User::new_regular(Some("Student1"));
    let v = User::new_regular(None);
    println!("{}", v == u);
    println!();

    // u = new User("Student1");
    // v = new User(null);
    // System.out.println(u.equals(v));
    let u = User::new_regular(Some("Student1"));
    let v = User::new_regular(None);
    println!("{}", u == v);
    println!();
}
