package arbre;

class Arbre {
    private int val ;
    private Arbre filsG ;
    private Arbre filsD ;
    // invariant : filsG == null <= > filsD == null
    public Arbre () { // construit l ’ arbre vide
        this . filsG = null ;
        this . filsD = null ;
    }
    public boolean estVide (){
        return ( this . filsG == null ) ;
    }

    @Override
    public String toString() {
        return toStringV2aux("");
    }

    public String toStringV2aux (String s ) {
        if (estVide())
            return "";
        else
            return filsD.toStringV2aux(s + "  ------") + s +
                    val + "\n" + filsG.toStringV2aux(s + "  ------"
            );
    }

    public boolean chercheNoeudInterne(int x){
        if (estVide()) return false;
        if (filsG.estVide()&&filsD.estVide())return false;
        if (filsG.chercheNoeudInterne(x) || filsD.chercheNoeudInterne(x)){
            return true;
        }else{
            if (val==x) return true;
            else return false;
        }
    }

    Arbre symetrise(){
        if (estVide()){
            Arbre arbreVide=new Arbre();
            return arbreVide;
        }
        if (filsG.estVide()&&filsD.estVide()){
            Arbre arbreVide1=new Arbre();
            Arbre arbreVide2=new Arbre();
            Arbre feuille=new Arbre();
            feuille.val=val;
            feuille.filsG=arbreVide1;
            feuille.filsD=arbreVide2;
            return feuille;
        }
        Arbre arbreFinal =new Arbre();
        arbreFinal.val=val;
        arbreFinal.filsG= filsD.symetrise();
        arbreFinal.filsD=filsG.symetrise();
        return arbreFinal;
    }


    public Arbre symetrise2(){
        Arbre sym =  new Arbre();
        if(!estVide()){
            sym.val = val;
            sym.filsD = this.filsG.symetrise2();
            sym.filsG = this.filsD.symetrise2();
        }
        return sym;
    }

    public boolean parcours(Liste l){
        if (estVide()){
            return l.estVide();
        }
        else {
            return !l.estVide() && (val == l.val) && (filsD.parcours(l.suiv) || filsG.parcours(l.suiv));
        }
    }

    public int traverse(){
        if (estVide()){
            return 0;
        }
        else{
            int compteG = this.filsG.traverse();
            int compteD = this.filsD.traverse();
            if (compteD>compteG){
                return compteD + 1;
            }
            else{
                return compteG + 1;
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
