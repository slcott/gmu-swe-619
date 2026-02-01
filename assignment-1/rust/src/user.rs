// src/user.rs

#[derive(Debug)]
pub enum User {
    Regular { name: Option<String> },
    Special { name: Option<String>, id: i32 },
}

impl User {
    pub fn new_regular(name: Option<&str>) -> Self {
        User::Regular {
            name: name.map(|s| s.to_string()),
        }
    }

    pub fn new_special(name: Option<&str>, id: i32) -> Self {
        User::Special {
            name: name.map(|s| s.to_string()),
            id,
        }
    }
}

impl PartialEq for User {
    fn eq(&self, other: &Self) -> bool {
        match (self, other) {
            (User::Regular { name: n1 }, User::Regular { name: n2 }) => n1 == n2,
            (User::Special { name: n1, id: id1 }, User::Special { name: n2, id: id2 }) => {
                n1 == n2 && id1 == id2
            }
            (User::Regular { name: n1 }, User::Special { name: n2, .. }) => {
                n1 == n2
            }
            (User::Special { .. }, User::Regular { .. }) => {
                false
            }
        }
    }
}
