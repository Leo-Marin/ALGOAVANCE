package arbre;

public class Liste {

    private int val ;
    private Liste suiv ;
    public Liste() { // construit la liste vide
        this . suiv = null ;
    }
    public String toString () {
// prerequis : aucun
        if ( estVide () ) {
            return " " ;
        }
        else {
            String aux = suiv . toString () ;
            return val + " ␣ " + aux ;
        }
    }
    public String toStringEnvers () {
// prerequis : aucun
        if ( estVide () ) {
            return " " ;
        }
        else {
            String aux = suiv . toStringEnvers () ;
            return aux + " ␣ " + val ;
        }
    }
    boolean estVide () { return this . suiv == null;};
}

