public class Mage extends Character{
    protected int mana = 100; //special stat for Mage

    public Mage(String name){
        super(name,180,50,40,"Mage");
    } //Mage's stat

    /** Use to show additional mana stat
     * effects: show mana of mage
     */
    @Override
    public void checkStatus(){
        super.checkStatus();
        System.out.println("Mana: " + mana);
        System.out.println("-------------------------");
    }

    /** Skill of Mage: Enlightenment From The Future
     * effects: Mage use a skill 'Enlightenment From The Future'
     *          It will give a barrier to Mage one time at thr next turn
     * effects: If Maage has used the skill, it does not force to use repeat
     */
    @Override
    public void skill(){
        if(!skillok && hp != 0){
            System.out.println(name + " uses a skill: Enlightenment From The Future: Mana -20");
            mana -= 20;
            skillok = true;
        }
        else System.out.println(name + " has already used this skill or died");
    }

    /** Use to attack the enemy by Mage's Style
     * effects: When Mage attacks, it always uses mana -10
     * @param opp the opponent whom Archer attacks
     */
    @Override
    public void attack(Character opp){
        super.attack(opp);
        if(opp.hp > 0 && hp != 0){
            System.out.println(name + " uses a magic UMBRACADABRA!!! MANA -20 --> ATK +10");
            mana -= 20;
            opp.receiveDmg(atk + 10);
        }
    }

    /** Use to calculate the damage which Mage received
     * effects: Check whether the Mage uses skill. If he uses, it will give def +20 one turn
     * @param dmg the damage before calculating with Mage's barrier
     */
    @Override
    protected void receiveDmg(int dmg){
        if(skillok){
            skillok = false;
            System.out.println("Skill Activated: Enlightenment From The Future: Barrier DEF +20");
            super.receiveDmg(dmg-20);
        }else super.receiveDmg(dmg);
        if(dmg > 0 && hp != 0){
            mana += 20;
            System.out.println("Special Ability: Revenge Absorption: MANA +20 when be damaged");
        }
    }
}
