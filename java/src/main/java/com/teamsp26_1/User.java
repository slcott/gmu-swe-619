package com.teamsp26_1;

class User {
    private String name;
    public User (String name) { this.name = name; }
    @Override public boolean equals (Object obj) {
        if (!(obj instanceof User)) return false;
        return java.util.Objects.equals(this.name, ((User) obj).name);
    }
}

