public class Arena {

    private Army army1;
    private Army army2;

    public Arena(Army army1, Army army2) {
        this.army1 = army1;
        this.army2 = army2;
    }

    public void Fight() {
        while (army1.isAlive() && army2.isAlive()) {
            army1.getWarrior().hitEnemy(army2.getWarrior());

            if (!army2.isAlive()) {
                System.out.println("Army 1 WIN");
                break;
            } else {
                army2.getWarrior().hitEnemy(army1.getWarrior(Strategy.WEAKEST));
            }

            if (!army1.isAlive()) {
                System.out.println("Army 2 WIN");
            }

            System.out.println("\t Army 1");
            army1.info();
            System.out.println("\n\t Army 2");
            army2.info();
            System.out.println();
        }
    }
}
