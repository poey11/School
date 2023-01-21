/* this is the player when you start the game */

public class player {
    private  int level = 0, expCap= 500, days =1;
    private double exp =0,coin=100;
    /**
     * This function sets the value of the exp variable to the value of the exp parameter
     * 
     * @param exp The amount of experience the player has.
     */
    public void setExp(double exp) {
        this.exp = exp;
    }

     /**
     * This function returns the number of days 
     * 
     * @return The number of days
     */
    public int getDays() {
        return days;
    }

    /**
     *  adds +1 to the variable "days" and returns that variable
     * 
     * @return  adds 1 and returns the number of days
     */

    public int nextDay(){
        return days++;
    }

    /**
     * If the exp is greater than or equal to 500, then the level is 5, the expCap is 1000, the exp is
     * 0, and the labels are refreshed.
     * If the exp is greater than or equal to 1000, then the level is 10, the expCap is 1500, the exp
     * is 0, and the labels are refreshed.
     * If the exp is greater than or equal to 1500, then the level is 15, the exp is 0, and the labels
     * are refreshed.
     */
    public void updateLevel(){
        if(this.exp >= 500 ){
            this.level = 5;
            this.expCap = 1000; 
            this.exp = 0;
            MyFarm.rLabels();
        }
        else if(this.exp >= 1000 ){
            this.level = 10;
            this.expCap = 1500; 
            this.exp = 0;
            MyFarm.rLabels();

        }
        else if(this.exp >= 1500 ){
            this.level = 15;
            this.exp = 0;
            MyFarm.rLabels();
        }
    }
    
     /**
     * This function returns the expCap variable
     * 
     * @return The expCap variable is being returned.
     */
    public int getExpCap() {
        return expCap;
    }

     /**
     * This function returns the value of the coin variable
     * 
     * @return The value of the coin variable.
     */
    public double getCoin() {
        return coin;
    }

    /**
     * This function returns the value of the exp variable
     * 
     * @return The exp variable is being returned.
     */
    public double getExp() {
        return exp;
    }
    
     /**
     * This function returns the level of the player
     * 
     * @return The level of the node.
     */
    public int getLevel() {
        return level;
    }

    /**
     * This function subtracts the value of the variable i from the variable coin
     * 
     * @param i The amount of coins to subtract
     */
    public void subtractCoin(int i){
        this.coin =  coin-i;
    }

    /**
     * This function adds the value of the parameter to the value of the coin variable
     * 
     * @param i The amount of coins to add
     */
    public void addCoin(double i){
        this.coin =  coin+i;
    }

     /**
     * This function adds the value of the parameter to the value of the variable exp
     * 
     * @param i The amount of exp to add to the player's exp.
     */
    public void addExp(double i){
        this.exp = exp + i;
    }
    
}
