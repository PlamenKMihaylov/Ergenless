package bg.sofia.uni.fmi.mjt.show.ergenka;

import bg.sofia.uni.fmi.mjt.show.date.DateEvent;

public class HumorousErgenka implements Ergenka {
    String name;
    short age;
    int romanceLevel;
    int humorLevel;
    int rating;

    public HumorousErgenka(String name, short age, int romanceLevel, int humorLevel, int rating) {
        this.name = name;
        this.age = age;
        this.romanceLevel = romanceLevel;
        this.humorLevel = humorLevel;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public short getAge() {
        return this.age;
    }

    @Override
    public int getRomanceLevel() {
        return this.romanceLevel;
    }

    @Override
    public int getHumorLevel() {
        return this.humorLevel;
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public void reactToDate(DateEvent dateEvent) {
        int delta = ((humorLevel * 5) / dateEvent.getTensionLevel()) +(int) Math.floor(romanceLevel / 3);

        int duration = dateEvent.getDuration();

        if (duration >= 30 && duration <= 90) {
            delta += 4;
        } else if (duration < 30) {
            delta -= 2;
        } else {
            delta -= 3;
        }

        rating += delta;
    }
}
