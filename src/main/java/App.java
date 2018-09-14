public class App {

    public static void main(String[] args) {

        Army a1 = new Army("A1");
        a1.info();
        System.out.println();

        Army a2 = new Army("A2");
        a2.info();

        Arena arena = new Arena(a1, a2);

        arena.Fight(ArmyStrategy.COMMAND);

    }
}