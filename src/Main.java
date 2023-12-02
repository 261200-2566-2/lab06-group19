// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println("Case 1 : Normal attack (non accessories)");
        Archer a = new Archer("Amanda Urduja");
        Mage m = new Mage("Peter Lancelot");
        a.checkStatus();
        m.checkStatus();

        a.lvUp();
        a.checkStatus();
        a.attack(m);
        m.checkStatus();

        a.skill();
        a.skill();
        System.out.println();
        a.attack(m);
        m.checkStatus();
        m.skill();
        m.skill();
        m.attack(a);
        a.checkStatus();
        a.attack(m);
        System.out.println();
        m.checkStatus();
        a.skill();
        a.attack(m);
        System.out.println();
        a.attack(m);
        m.attack(a);
        m.skill();

        System.out.println("\nCase 2: Accessories");
        Crown c = new Crown("TxT:Osama no Boushi");
        Mask k = new Mask("Black-White Senorita");
        c.checkHeadStatus();
        c.upHead();
        c.checkHeadStatus();

        System.out.println("\nCase 3: Accessories withb Characters");
        a.headDrop();
        a.checkStatus();
        a.headAdd(c);
        a.checkStatus();
        a.headAdd(k);
        a.checkStatus();
        a.headDrop();
        a.checkStatus();
        a.headDrop();
        a.headAdd(k);

        System.out.println("\nCase 4: Attack with Accessories");
        Mage m2 = new Mage("Danielo Chen");
        m2.checkStatus();
        m2.headAdd(c);
        System.out.println("\n\n\n");
        System.out.println("Now, both have head armors");
        a.checkStatus();
        m2.checkStatus();
        a.skill();
        a.attack(m2);
        System.out.println();
        m2.skill();
        a.skill();
        a.attack(m2);
        System.out.println();
        m2.attack(a);
        m2.lvUp();
        m2.attack(a);
        m2.attack(a);
        m2.attack(a);
        m2.attack(a);
        m2.attack(a);
    }
}