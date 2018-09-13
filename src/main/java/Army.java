import java.util.Random;

public class Army {

    private Random generator = null;
    private final int N = 5;
    private Warrior[] army = null;
    private String name;

    public Army(String name) {

        generator = new Random();
        army = new Warrior[N];

        for (int i=0; i<N; i++) {
            army[i] = new Warrior(90 + generator.nextInt(21), 5 + generator.nextInt(11), "War"+(i+1) + name);
        }
    }

    public boolean isAlive() {
        for (Warrior w:army) {
            if (w.isAlive())
                return true;
        }
        return false;
    }

    private Warrior getRandomWarrior() {
        Warrior result = null;
        while (result == null) {
            int i = generator.nextInt(N);
            if (army[i].isAlive())
                result = army[i];
        }
        return result;
    }

    private Warrior getStrongestWarrior() {
        int i = 0;
        while (!army[i].isAlive()) i++;
        Warrior result = army[i];
        i++;
        for (;i<N;i++) {
            if (army[i].isAlive() && (army[i].getDamage() > result.getDamage()))
                result = army[i];
        }
        return result;
    }

    private Warrior getWeakestWarrior() {
        int i = 0;
        while (!army[i].isAlive()) i++;
        Warrior result = army[i];
        i++;
        for (;i<N;i++) {
            if (army[i].isAlive() && (army[i].getDamage() < result.getDamage()))
                result = army[i];
        }
        return result;
    }

    private Warrior getHealthyWarrior() {
        int i = 0;
        while (!army[i].isAlive()) i++;
        Warrior result = army[i];
        i++;
        for (;i<N;i++) {
            if (army[i].isAlive() && (army[i].getHp() > result.getHp()))
                result = army[i];
        }
        return result;
    }

    private Warrior getSicklyWarrior() {
        int i = 0;
        while (!army[i].isAlive()) i++;
        Warrior result = army[i];
        i++;
        for (;i<N;i++) {
            if (army[i].isAlive() && (army[i].getHp() < result.getHp()))
                result = army[i];
        }
        return result;
    }

    public Warrior[] getArmy() {
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
            if (w.isAlive())
            System.out.println(w);
        }
    }
}
