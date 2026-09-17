package experiments;
import enums.StateCity;
import enums.StateCity.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(StateCity.NCR.name());
        System.out.println(StateCity.NCR.getState());

        // false -> потому что сравнение объектов типа Enum и String
        System.out.println(StateCity.NCR.equals(StateCity.NCR.getState()));

        // true
        System.out.println(StateCity.NCR.name().equals(StateCity.NCR.getState()));
        System.out.println(StateCity.NCR.toString().equals(StateCity.NCR.getState()));

    }
}
