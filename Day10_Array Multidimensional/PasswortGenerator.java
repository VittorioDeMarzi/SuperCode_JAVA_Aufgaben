public class PasswortGenerator {
    public static void main(String[] args) {
        String satz = "Das Erlernen von Java macht so viel Spass";
        String password = getPassword(satz);
        System.out.println("Password: " + password);
    }

    private static String getPassword(String satz) {
        if (satz.length()== 0) return null;
        String[] passStrings = satz.split("");
        
        String password = passStrings[0];

        for (int i = 1; i < passStrings.length; i++) {
            if (" ".equals(passStrings[i - 1])) {
                password += passStrings[i];
            }
        }
        return password;
    }
}
