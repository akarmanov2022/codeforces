public class PassCode {
    public static void main(String[] args) {

        for (int i = 0; i < 99999; i++) {
            String code = String.format("%05d", i);
            if (code.equals("12345")) {
                System.out.println("accepted");
            } else if (code.matches("\\d{5}")) {
                System.out.println("wrong answer");
            } else {
                System.out.println("wrong error");
            }
        }
    }
}
