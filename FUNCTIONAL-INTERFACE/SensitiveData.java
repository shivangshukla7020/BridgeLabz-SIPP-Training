interface SensitiveData {
    // Marker interface for encryption
}

class UserInfo implements SensitiveData {
    private String name;
    private String ssn;

    public UserInfo(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }
}