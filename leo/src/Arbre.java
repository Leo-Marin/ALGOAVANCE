public class Arbre {
    private int val ;
    private Arbre filsG ;
    private Arbre filsD ;
    // invariant : filsG == null <= > filsD == null
    public Arbre () { // construit l ’ arbre vide
        this . filsG = null ;
        this . filsD = null ;
    }
    public String toStringV2aux ( String s ) {
        // pre : aucun
        /* resultat : retourne une chaine de caracteres
        permettant d ’ afficher this dans un
        terminal ( avec l ’ indentation du dessin
                precedent , et en ajoutant s au debut de
                chaque ligne ecrite ) et passe a la ligne
        apres chaque entier ecrit*/
        if (estVide()) {
            return " ";
        } else {
            return filsD.toStringV2aux(s + " ␣ ␣ ␣ ") + s +
                    val + " \n " + filsG.toStringV2aux(s + " ␣ ␣ ␣ ");
        }
    }
    public boolean estVide(){
        return ( this.filsG == null ) ;
    }
    public String toStringV2 () {
        // pre : aucun
        return toStringV2aux ( " " ) ;
    }

    public Arbre symetrise(){
        if(this.estVide()){ return new Arbre(); }
        if(filsG.estVide() && filsD.estVide()){
            Arbre feuille = new Arbre();
            Arbre arbrevide2 = new Arbre();
            Arbre arbrevide3 = new Arbre();
            feuille.filsD = arbrevide2;
            feuille.filsG = arbrevide3;
            return feuille;
        }
        else{
           Arbre arbrefinal = new Arbre();
           arbrefinal.val = val;
           arbrefinal.filsG=filsD.symetrise();
           arbrefinal.filsD =filsG.symetrise();
           return arbrefinal;
        }
    }
    public static void main(String[] args) {
        Arbre arbre1VideG =new Arbre();
        Arbre arbre1VideD =new Arbre();
        Arbre arbre2VideG =new Arbre();
        Arbre arbre2VideD =new Arbre();

        Arbre arbre1 =new Arbre();
        arbre1.filsD=arbre1VideD;
        arbre1.filsG=arbre1VideG;
        arbre1.val=6;

        Arbre arbre2 =new Arbre();
        arbre2.filsG=arbre2VideG;
        arbre2.filsD=arbre2VideD;

        Arbre arbreFinal =new Arbre();
        arbreFinal.filsD=arbre1;
        arbreFinal.filsG=arbre2;
        arbreFinal.val=16;

        System.out.println(arbreFinal.symetrise());
        System.out.println(arbreFinal);
    }

}

