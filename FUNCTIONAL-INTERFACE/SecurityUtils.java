interface SecurityUtils {
    static boolean isPasswordStrong(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*");
    }
}

class InsurancePortal {
    public static void main(String[] args) {
        String password = "Secure@123";
        if (SecurityUtils.isPasswordStrong(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
        }
    }
}