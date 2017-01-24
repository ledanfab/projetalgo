package xyz.alhdo;

/**
 * Created by root on 1/14/17.
 */
public class PostFixe {

    private String a;
    private PostFixe fils_gauche, fils_droit;

    public PostFixe() {
    }
    public PostFixe (String a){
        this.a=a;
    }
    public String getValue(){
        return a;
    }

    public PostFixe getFils_gauche() {
        return fils_gauche;
    }

    public PostFixe getFils_droit() {
        return fils_droit;
    }

    public void setFils_gauche(PostFixe fils_gauche) {
        this.fils_gauche = fils_gauche;
    }

    public void setFils_droit(PostFixe fils_droit) {
        this.fils_droit = fils_droit;
    }

    public String toString(){
        return toString("\t");
    }

    public static void ShowTree(PostFixe a){
        System.out.println("\t\t\t\t"+a.getValue());
        try {
            PostFixe b = a.getFils_gauche();
            PostFixe c = a.getFils_droit();
            System.out.println("\t\t\t"+b.getValue()+ " \t\t "+c.getValue());
            PostFixe d = b.getFils_gauche();
            PostFixe f,g;
            PostFixe e = b.getFils_droit();
            f=c.getFils_gauche();
            g=c.getFils_droit();
            System.out.println("\t\t"+d.getValue()+" \t"+e.getValue()+"\t \t "+f.getValue()+"\t"+g.getValue());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("==================================================");
            System.out.println("================= ERREUR EXPRESSION  =============");
            System.out.println("==================================================");
        }
    }

    public String toString(String s) {
        if(fils_gauche!=null){
            if (fils_droit!=null){
                return s+"_("+ a + " )_____\n"+fils_gauche.toString(s+" \t")+ fils_droit.toString(s+"\t");
            }else{
                return s+a+"\n"+fils_gauche.toString(s+"\t")+" \n";
            }
        }else{
            if(fils_droit!=null){
                return s+a+"\n\n"+fils_droit.toString(s+"\t");
            }else{
                return s+a+" \n";
            }
        }
    }
}
