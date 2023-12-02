public interface Head { //interface of accessories (Head)
    /** 2 methods use to up level armor and check status
     */
    void upHead();
    public void checkHeadStatus();

    /** Use to send information to character class
     */
    String headName();
    int hpAdd();
    int atkAdd();
    int defAdd();
}