public class Crown implements Head{
    protected String name; //basic stat of crown which has bonus hp+,def+
    protected int level;
    protected int hpAddition;
    protected int defBonus;

    public Crown(String name){ //basic constructor
        this.name = name;
        this.level = 1;
        this.hpAddition = 20;
        this.defBonus = 10;
    }

    public Crown(){
        this("Commom Crown");
    } //dummy constructor

    /** See the status of crown
     * effects: show basic stats (name,level,hp+,def+)
     */
    @Override
    public void checkHeadStatus() {
        System.out.println("-------------------------");
        System.out.println(" " + this.name + "'s Status ");
        System.out.println("Level: " + this.level);
        System.out.println("HP Addition: " + this.hpAddition);
        System.out.println("Def Bonus: " + this.defBonus);
        System.out.println("-------------------------");
    }

    /** Use to up level crown one level
     * effects: increase stats (level,hp+,def+)
     */
    @Override
    public void upHead() {
        this.level++;
        this.hpAddition += 10;
        this.defBonus += 10;
        System.out.println("Now " + name + "'s levels is " + level);
    }

    /** the rest of them uses to implement each type of variables
     */
    public String headName(){return name;}
    public int hpAdd(){return hpAddition;}
    public int atkAdd(){return 0;} //atk+ gives no point
    public int defAdd(){return defBonus;}
}