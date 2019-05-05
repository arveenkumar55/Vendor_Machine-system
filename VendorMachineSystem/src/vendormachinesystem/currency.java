/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendormachinesystem;

/**
 *
 * @author Arveen Maheshwari
 */
public class currency {

    public currency(int thousand , int five_hundred ,int hundred, int fifty, int ten, int five) {
        this.thousand = thousand;
        this.five_hundred= five_hundred;
        this.hundred = hundred;
        this.fifty = fifty;
        this.ten = ten;
        this.five = five;
    }

    currency() {
    }
    
    public void set_currency(int thousand , int five_hundred ,int hundred, int fifty, int ten, int five) {
        this.thousand = thousand;
        this.five_hundred= five_hundred;
        this.hundred = hundred;
        this.fifty = fifty;
        this.ten = ten;
        this.five = five;
    }

    public int getHundred() {
        return hundred;
    }

    public void setHundred(int hundred) {
        this.hundred = hundred;
    }

    public int getFifty() {
        return fifty;
    }

    public void setFifty(int fifty) {
        this.fifty = fifty;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getFive_hundred() {
        return five_hundred;
    }

    public void setFive_hundred(int five_hundred) {
        this.five_hundred = five_hundred;
    }

    public int getThousand() {
        return thousand;
    }

    public void setThousand(int thousand) {
        this.thousand = thousand;
    }
    int five_hundred;
    int thousand;
    int hundred;
    int fifty;
    int ten;
    int five;
    
    
}
