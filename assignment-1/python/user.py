class User:
    name: str

    def __init__(self, name: str | None):
        self.name = name

    def __eq__(self, other):
        if not isinstance(other, User):
            # return False
            return NotImplemented
        return other.name == self.name
