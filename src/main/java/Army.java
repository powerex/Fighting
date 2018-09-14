import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {

    private Random generator = null;
    private final int N = 5;
    private ArrayList<Warrior> army;
    private String name;

    public Army(String name) {

        generator = new Random();
        army = new ArrayList<Warrior>();

        for (int i=0; i<N; i++) {
            army.add(
                    new Warrior(90 + generator.nextInt(21),
                            5 + generator.nextInt(11),
                            "War"+(i+1) + name,
                            this));
        }
    }

    public boolean isAlive() {
        return !army.isEmpty();
    }

    private Warrior getRandomWarrior() {
        return army.get( generator.nextInt(army.size()) );
    }

    private Warrior getStrongestWarrior() {
        Warrior w = army.get(0);
        for (Warrior t: army)
            if (t.getDamage() > w.getDamage())
                w = t;
        return w;
    }

    private Warrior getWeakestWarrior() {
        Warrior w = army.get(0);
        for (Warrior t: army)
            if (t.getDamage() < w.getDamage())
                w = t;
        return w;
    }

    private Warrior getHealthyWarrior() {
        Warrior w = army.get(0);
        for (Warrior t: army)
            if (t.getHp() > w.getHp())
                w = t;
        return w;
    }

    private Warrior getSicklyWarrior() {
        Warrior w = army.get(0);
        for (Warrior t: army)
            if (t.getHp() < w.getHp())
                w = t;
        return w;
    }

    public List<Warrior> getArmy() {
        return army;
    }

    public Warrior getWarrior(Strategy strategy) {
        switch (strategy) {
            case SICKLY: return getSicklyWarrior();
            case HEALTHY: return getHealthyWarrior();
            case WEAKEST: return getWeakestWarrior();
            case STRONGEST: return getStrongestWarrior();
        }
        return getRandomWarrior();
    }

    public Warrior getWarrior() {
        return getRandomWarrior();
    }

    public void info() {
        for (Warrior w: army) {
            System.out.println(w);
        }
    }
}
