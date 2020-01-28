package database.example;

import app.model.Fish;
import app.repository.FishRepository;

public class InsertExampleRepository {
    public void main(String[] args){
        Fish newFish = new Fish(-1, "Wegorz", Fish.TypeOfFish.HERBIVORE, 1, 3);
        FishRepository.createFish(newFish);
    }
}
