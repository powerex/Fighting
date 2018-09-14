public class Warrior {

    private int hp;
    private int damage;
    private String name;
    private Army army;

    public Warrior(int hp, int damage, String name, Army army) {
        this.hp = hp;
        this.damage = damage;
        this.name = name;
        this.army = army;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public Army getArmy() {
        return army;
    }

    public void hitEnemy(Warrior enemy) {
        enemy.setHp(enemy.getHp() - this.damage);
        if (enemy.getHp() <= 0)
            enemy.getArmy().getArmy().remove(enemy);
        System.out.println(this.name + " hit " + enemy.getName() + " " + this.damage + " damage");
    }

    @Override
    public String toString() {
        return "Name~ " + this.name + " HP: " + this.hp + "; Damage: " + this.damage;
    }
}
