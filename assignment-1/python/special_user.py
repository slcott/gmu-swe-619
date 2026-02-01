from user import User


class SpecialUser(User):
    id: int

    def __init__(self, name, id):
        super().__init__(name)
        self.id = id

    def __eq__(self, other):
        if not isinstance(other, SpecialUser):
            # return False
            return NotImplemented # allow Python to fall back to the base User class if the comparison fails
        return super().__eq__(other) and other.id == self.id