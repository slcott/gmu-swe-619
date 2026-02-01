from user import User
from special_user import SpecialUser

class TestUserAndSpecialUser:
    def test_user_eq_self(self):
        """Tests reflexivity: u == u should be true."""
        u = User("Student1")
        assert u == u

    def test_user_eq_same_name(self):
        assert User("Student1") == User("Student1")

    def test_user_eq_different_name(self):
        assert User("Student1") != User("Student2")

    def test_user_eq_special_user(self):
        """
        When comparing a User and a SpecialUser, u == v calls User.__eq__(v),
        which should return False because they are different types.
        """
        u = User("Student1")
        v = SpecialUser("Student1", 5)
        assert u != v

    def test_user_eq_other_type(self):
        assert User("Student1") != "Student1"

    def test_user_eq_none(self):
        """
        Comparing with None. u is not None.
        In Python, it's better to use 'is not None' for this.
        """
        assert User("Student1") != None
        assert User("Student1") is not None

    def test_user_none_vs_user(self):
        u = User("Student1")
        v = User(None)
        assert v != u

    def test_user_vs_user_none(self):
        u = User("Student1")
        v = User(None)
        assert u != v

    def test_special_user_eq_same_name_and_id(self):
        assert SpecialUser("Student1", 5) == SpecialUser("Student1", 5)

    def test_special_user_eq_different_id(self):
        assert SpecialUser("Student1", 5) != SpecialUser("Student1", 6)

    def test_special_user_eq_different_name(self):
        assert SpecialUser("Student1", 5) != SpecialUser("Student2", 5)

    def test_special_user_eq_user(self):
        """
        When comparing a SpecialUser and a User, v == u calls SpecialUser.__eq__(u),
        which should return False because they are different types.
        The original comment was:
        # calls v.__eq__(u) because v is a subclass and has more specific logic to make comparisons
        """
        u = User("Student1")
        v = SpecialUser("Student1", 5)
        assert v != u

    def test_special_user_eq_other_type(self):
        assert SpecialUser("Student1", 5) != "Student1"

    def test_special_user_eq_none(self):
        assert SpecialUser("Student1", 5) != None