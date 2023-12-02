public class Archer extends Character{
    private int speed = 20; //speed is special stat for Archer

    public Archer(String name){
        super(name,120,70,30,"Archer");
    } //Archer's stat

    /** Use to show additional speed stat
     * effects: show speed of archer
     */
    @Override
    public void checkStatus(){
        super.checkStatus();
        System.out.println("Speed: " + speed);
        System.out.println("-------------------------");
    }

    /** Skill of Archer: Rain From Paradise
     * effects: Charge the skill, when attack the enemy,
     *          Archer will gain bonus attack +20
     * effects: If Archer has used the skill, it does not force to use repeat
     */
    @Override
    public void skill(){
        if(!skillok && hp != 0){
            System.out.println(name + " uses a skill: Rain From Paradise");
            skillok = true;
        }
        else System.out.println(name + " has already used this skill or died");
    }

    /** Use to attack the enemy by Archer's Style
     * effects: Archer has special ability 'Eye of Precision' it will give
     *          bonus atk from speed/2
     * effects: Check whether the Archer uses skill. If he uses, gain atk +20
     * @param opp the opponent whom Archer attacks
     */
    @Override
    public void attack(Character opp){
        super.attack(opp);
        if(opp.hp > 0 && hp != 0){
            System.out.println("Special Ability: Eye of Precision: Gain Bonus ATK +" + speed / 2);
            if (skillok) {
                System.out.println("Skill: Rain From Paradise: Critical ATK +20");
                atk += 20;
                opp.receiveDmg(atk + speed / 2);
                skillok = false;
                atk -= 20;
            } else {
                opp.receiveDmg(atk + speed / 2);
            }
        }
    }


}
