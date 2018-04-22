package savegames;

public class HealthPool {

    private int currentHealth;
    private int maxHealth;
    private int shielding;

    public HealthPool(int maxHealth) {
        this(maxHealth, maxHealth, 0);

    }
    public HealthPool(int maxHealth, int currentHealth, int shielding) {
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.shielding = shielding;
    }
    public int getShielding() {
        return shielding;
    }

    public void setShielding(int shielding) {
        this.shielding = shielding;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /* Action functions */
    public void takeDamage(int damage) {
        int damageToShield = Math.min(damage, this.shielding);
        this.shielding -= damageToShield;
        damage -= damageToShield;
        this.currentHealth -= damage;
    }

    public void healDamage(int heal) {
        this.currentHealth = Math.min(this.currentHealth + heal, this.maxHealth);
    }

    /* Statistics */
    public int getHealthPercentage(){
        return (int) (((float) this.currentHealth / (float) this.maxHealth) * 100);
    }

}
