package com.teamsp26_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Assignment1Test {

    @Test
    void testEqualsReflexivity() {
        User u = new User("Student1");
        assertTrue(u.equals(u), "An object must be equal to itself.");
    }

    @Test
    void testEqualsSymmetricity() {
        User u = new User("Student1");
        User v = new User("Student1");
        assertTrue(u.equals(v), "An object must be equal to itself.");
        assertTrue(v.equals(u), "An object must be equal to itself.");
    }

    @Test
    void testEqualsTransitivity() {
        User u = new User("Student1");
        User v = new User("Student1");
        User w = new User("Student1");
        assertTrue(u.equals(v) && v.equals(w), "An object must be equal to itself.");
    }

    @Test
    void testConsistent() {
        User u = new User("Student1");
        User v = new User("Student1");
        for (int i = 0; i < 100; i++) {
            assertTrue(u.equals(v) && v.equals(u), "An object must be equal to itself.");
        }
        v = new User("Student2");
        for (int i = 0; i < 100; i++) {
            assertFalse(u.equals(v) && v.equals(u), "An object must be equal to itself.");
        }
    }

    @Test
    void testEqualsWithNull() {
        User u = new User("Student1");
        assertFalse(u.equals(null), "An object must not be equal to null.");
    }

    @Test
    void testEqualsWithDifferentClass() {
        User u = new User("Student1");
        assertFalse(u.equals("Student1"), "An object must not be equal to an object of a different class.");
    }

    @Test
    void testEqualsSymmetryBetweenUserAndSpecialUser() {
        User u = new User("Student1");
        SpecialUser v = new SpecialUser("Student1", 5);
        
        // This assertion reflects the current implementation, which violates symmetry.
        assertTrue(u.equals(v), "User.equals(SpecialUser) should be true if names match.");
        assertFalse(v.equals(u), "SpecialUser.equals(User) should be false because the User is not a SpecialUser.");
    }

    @Test
    void testEqualsWithNullNameInThis() {
        User u = new User("Student1");
        User v = new User(null);
        
        assertFalse(v.equals(u), "A user with a null name should not be equal to another user.");
    }

    @Test
    void testEqualsWithNullNameInOther() {
        User u = new User("Student1");
        User v = new User(null);
        
        assertFalse(u.equals(v), "A user should not be equal to a user with a null name.");
    }

}
