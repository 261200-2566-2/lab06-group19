public abstract class Character {
    protected int level; //basic stats
    protected String name,job;
    protected int hp,atk,def;
    protected boolean hok,skillok; //boolean to check headon? skillused?
    protected Head h; //head armor which the character equiped

    protected Character(String name, int h, int a, int d, String job){ //basic constructor
        this.name = name;
        level = 1;
        hp = h;
        atk = a;
        def =d;
        hok = false;
        skillok = false;
        this.job = job;
    }

    /** See the status of each character
    * effects: show basic stats (level, hp, atk, def and job)
    */
    protected void checkStatus(){
        System.out.println("-------------------------");
        System.out.println("  " + name + "'s status  ");
        System.out.println("Level: " + level);
        System.out.println("Health: " + hp);
        System.out.println("Attack: " + atk);
        System.out.println("Defense: " + def);
        System.out.println("Job: " + job);
    }

    /** Use to level up the character one level
     * effects: level up and increase hp +20
     */
    public void lvUp(){
        System.out.println(name + " LEVEL UP !!!");
        level++;
        hp += 20;
    }

    /** a skill of character, different skills on each character's job
     */
    protected abstract void skill();

    /** Use to equip a head armor to the character
     * effects: if the character has no head armor, put the armor to him
     * effects: change the old one and equip the new one
     * @param h the head armor (can be a crown or a mask)
     */
    public void headAdd(Head h){
        if(!hok){
            this.h = h;
            hok = true;
            System.out.println(name + " equips " + h.headName());
            hp += h.hpAdd();
            atk += h.atkAdd();
            def += h.defAdd();
        }else{
            headDrop();
            this.headAdd(h);
        }
    }

    /** Use to unequip a head armor in the character
     * effects:  drop the armor in the character
     * effects: if the character has no head armor, it prints "no armor"
     */
    public void headDrop(){
        if(!hok){
            System.out.println(name + " doesn't have any head armor!");
        }else{
            System.out.println(name + " removes " + h.headName());
            hok = false;
            hp -= h.hpAdd();
            atk -= h.atkAdd();
            def -= h.defAdd();
            this.h = null;
        }
    }

    /** Use to attack the other character
     * effects: This character will calculate atk points (+ bonus atk)
     *          as a damage to give to the opponent
     * effects: If this character has died, it prints 'your chracter die'
     * effects: If the opponet has died, it prints 'the opponent chracter die'
     * @param opp the opponent who this character wants to attack
     */
    protected void attack(Character opp){
        if(opp.hp == 0){
            System.out.println(opp.name + " already has died!");
        }else if(this.hp == 0){
            System.out.println(this.name + " can't fight because of death!");
        }else{
            System.out.println(this.name + " attacks " + opp.name + " +" + atk + " !!!" );
            }
    }

    /** Use to decrease hp of "this character" from the attacker by
     *  the attacker's damage
     * effects: decrease hp of this character by damage from the attacker
     * @param dmg the damage from attacking
     */
    protected void receiveDmg(int dmg){
        this.hp = this.hp - dmg + def;
        System.out.println(this.name + " receives DMG -" + (dmg-def));
        if(this.hp < 0) this.hp = 0;
        if(this.hp == 0) System.out.println(this.name + " is death...");
    }

}
