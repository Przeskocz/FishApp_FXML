package app.model;

public class Fish {
    /*gatunek(nazwa ryby)
      typ(mięsożerne, roślinożerca, padlinożerna)
      waga od(kg)
      waga do(kg)
    */
    private long fishId;
    private String species;
    private TypeOfFish type;
    private int weightFrom;
    private int weightTo;

    public Fish() {

    }

    public Fish(long fishId, String species, TypeOfFish type, int weightFrom, int weightTo) {
        this.fishId = fishId;
        this.species = species;
        this.type = type;
        this.weightFrom = weightFrom;
        this.weightTo = weightTo;
    }

    public long getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
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
    public String toString() {
        String returnFish = "";

        returnFish = returnFish + "{Gatunek: " + this.species + "\n";

        switch (this.type) {
            case MEAT_EATER:
                returnFish = returnFish + "Typ: mięsożerna" + "\n";
                break;
            case HERBIVORE:
                returnFish = returnFish + "Typ: roślinożerna" + "\n";
                break;
            case SCAVENGER:
                returnFish = returnFish + "Typ: padlinożerna" + "\n";
                break;
        }

        returnFish = returnFish + "Waga od: " + this.weightFrom + "\n";
        returnFish = returnFish + "Waga do: " + this.weightTo + "}\n\n";

        return returnFish;
    }

    public enum TypeOfFish {
        MEAT_EATER("MEAT_EATER", 0),
        HERBIVORE("HERBIVORE", 1),
        SCAVENGER("SCAVENGER", 2);

        private String text;
        private int index;

        TypeOfFish(String text, int index) {
            this.text = text;
            this.index = index;
        }
        
        public static TypeOfFish fromString(String text) {
            for (TypeOfFish item : TypeOfFish.values()) {
                if (item.text.equalsIgnoreCase(text)) {
                    return item;
                }
            }
            return null;
        }
    }
}