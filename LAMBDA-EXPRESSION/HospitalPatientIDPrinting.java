// Method References – Hospital Patient ID Printing

class Patient {
    String id;
    String getId() { return id; }
}

class Hospital {
    void printIds(List<Patient> patients) {
        patients.stream()
                .map(Patient::getId)   // method reference instead of lambda
                .forEach(System.out::println);
    }
}
