package model;

public enum Role {

    USER("user"), ADMIN("admin"), SUPER_ADMIN("super_admin");

    private String displayName;

    Role(String displayName) {
        this.displayName= displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
