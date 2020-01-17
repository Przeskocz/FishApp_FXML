package app.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class Piscary {
    /*
    Obszar / wielkość ha
    Nazwa
    Adres
    Kontakt
    Jakie są ryby
    Godziny polowów (od do)
    Cena za dzień
    Cena za noc
    Liczba wędek na wędkarza
    Czy wymagana rezerwacja stanowiska
    Najskuteczniejsze przynęty
    */
    private long piscaryId;
    private double area;
    private String name;
    private String address;
    private String contact;
    private Set<Fish> availableFish;
    private int hourFrom;
    private int hourTo;
    private int priceDay;
    private int priceNight;
    private int countRod;
    private boolean isBookingSlot;
    private String[] effectiveBait; //zrobić tablice Stringów z przynętami

    public Piscary() {
    }

    public Piscary(long piscaryId, double area, String name, String address, String contact, Set<Fish> availableFish, int hourFrom,
                   int hourTo, int priceDay, int priceNight, int countRod, boolean isBookingSlot, String[] effectiveBait) {
        this.piscaryId = piscaryId;
        this.area = area;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.availableFish = availableFish;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.priceDay = priceDay;
        this.priceNight = priceNight;
        this.countRod = countRod;
        this.isBookingSlot = isBookingSlot;
        this.effectiveBait = effectiveBait;
    }

    public Piscary(double area, String name, String address, String contact, Set<Fish> availableFish, int hourFrom,
                   int hourTo, int priceDay, int countRod, boolean isBookingSlot) {
        this.area = area;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.availableFish = availableFish;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.priceDay = priceDay;
        this.countRod = countRod;
        this.isBookingSlot = isBookingSlot;
    }

    public long getPiscaryId() {
        return piscaryId;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Set<Fish> getAvailableFish() {
        return availableFish;
    }

    public void setAvailableFish(Set<Fish> availableFish) {
        this.availableFish = availableFish;
    }

    public int getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(int hourFrom) {
        this.hourFrom = hourFrom;
    }

    public int getHourTo() {
        return hourTo;
    }

    public void setHourTo(int hourTo) {
        this.hourTo = hourTo;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public int getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(int priceNight) {
        this.priceNight = priceNight;
    }

    public int getCountRod() {
        return countRod;
    }

    public void setCountRod(int countRod) {
        this.countRod = countRod;
    }

    public boolean isBookingSlot() {
        return isBookingSlot;
    }

    public void setBookingSlot(boolean bookingSlot) {
        this.isBookingSlot = bookingSlot;
    }

    public String[] getEffectiveBait() {
        return effectiveBait;
    }

    public void setEffectiveBait(String[] effectiveBait) {
        this.effectiveBait = effectiveBait;
    }

    public void addNewFish(Fish newFish) {
        availableFish.add(newFish);
    }

    public void addNewFishes(Collection<Fish> fishCollection) {
        availableFish.addAll(fishCollection);
    }

    public void removeFish(Fish fishToRemove) {
        availableFish.remove(fishToRemove);
    }

    @Override
    public String toString() {
        return "Piscary{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", availableFish=" + availableFish +
                ", hourFrom=" + hourFrom +
                ", hourTo=" + hourTo +
                ", priceDay=" + priceDay +
                ", priceNight=" + priceNight +
                ", countRod=" + countRod +
                ", isBookingSlot=" + isBookingSlot +
                ", effectiveBait='" +  Arrays.toString(effectiveBait) + '\'' +
                '}';
    }
}
