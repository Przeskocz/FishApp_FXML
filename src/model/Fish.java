package model;

public class Fish {
    /*gatunek(nazwa ryby)
      typ(mięsożerne, roślinożerca, padlinożerna)
      waga od(kg)
      waga do(kg)
    */
    private String species;
    private TypeOfFish type;
    private int weightFrom;
    private int weightTo;

    public Fish() {

    }

    public Fish(String species, TypeOfFish type, int weightFrom, int weightTo) {
        this.species = species;
        this.type = type;
        this.weightFrom = weightFrom;
        this.weightTo = weightTo;
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public TypeOfFish getType() {
        return type;
    }

    public void setType(TypeOfFish type) {
        this.type = type;
    }

    public int getWeightFrom() {
        return weightFrom;
    }

    public void setWeightFrom(int weightFrom) {
        this.weightFrom = weightFrom;
    }

    public int getWeightTo() {
        return weightTo;
    }

    public void setWeightTo(int weightTo) {
        this.weightTo = weightTo;
    }

    @Override
    public String toString(){
        String returnFish = "";

        returnFish = returnFish + "{Gatunek: " + this.species + "\n";

        switch(this.type){
            case MEAT_EATER:
                returnFish = returnFish + "Typ: mięsożerna" +"\n";
                break;
            case HERBIVORE:
                returnFish = returnFish + "Typ: roślinożerna" +"\n";
                break;
            case SCAVENGER:
                returnFish = returnFish + "Typ: padlinożerna" +"\n";
                break;
        }

        returnFish = returnFish + "Waga od: " + this.weightFrom +"\n";
        returnFish = returnFish + "Waga do: " + this.weightTo +"}\n\n";

        return returnFish;
    }

    public enum TypeOfFish {MEAT_EATER, HERBIVORE, SCAVENGER};
}
