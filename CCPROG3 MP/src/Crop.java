import java.util.Random;
/* this class serves as the tile in Myfarm */
public class Crop {
    private String cropName,cropType;
    private int harvestDay, currWater, minWater, maxWater, currFert, minFert, maxFert, minProd, maxProd,  sell;
    private double exp;

    // A constructor.
    public Crop(String Name, String type  ,int Harvest, int MinWater, int MaxWater, int MinFert, int MaxFert,
            int MinProd, int MaxProd, int sell, double exp) {
        this.cropName = Name;
        this.cropType = type;
        this.harvestDay = Harvest;
        this.minWater = MinWater;
        this.maxWater = MaxWater;
        this.currWater = 0;
        this.minFert = MinFert;
        this.maxFert = MaxFert;
        this.currFert = 0;
        this.sell = sell;
        this.minProd = MinProd;
        this.maxProd = MaxProd;
        this.exp = exp;
    }

     /**
     * This function adds one to the current fertility of the tile
     * 
     * @return The current value of currFert is being returned.
     */
    public int addFert() {
        return this.currFert++;
    }


     /**
     * This function returns the crop type of the crop
     * 
     * @return The cropType variable is being returned.
     */
    public String getCropType() {
        return cropType;
    }

    /**
     * This function adds water to the current water level
     * 
     * @return The current water level is being returned.
     */
    public int addWater() {
        return this.currWater++;
    }

     /**
     * Dcreasethe harvestDays
     * 
     * @return The harvestDay is being returned.
     */
    public int nextDay() {
        return this.harvestDay--;
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
     * This function returns the name of the crop
     * 
     * @return The cropName
     */
    public String getCropName() {
        return cropName;
    }

     /**
     * This function returns the harvest day of the crop
     * 
     * @return The harvestDay variable is being returned.
     */
    public int getHarvestDay() {
        return harvestDay;
    }

    /**
     * This function sets the sell value of the item
     * 
     * @param sell The price of the item
     */
    public void setSell(int sell) {
        this.sell = sell;
    }

    /**
    * This function returns the sell value of the item
    * 
    * @return The sell variable is being returned.
    */
    public int getSell() {
        return sell;
    }

    /**
     * This function returns the minimum product of two numbers in the array
     * 
     * @return The minimum production of the factory.
     */
    public int getMinProd() {
        return minProd;
    }

    /**
     * This function returns the maximum product of any two numbers in the array
     * 
     * @return The maxProd is being returned.
     */
    public int getMaxProd() {
        return maxProd;
    }

    /**
     * This function returns the current water level of the tank
     * 
     * @return The current water level.
     */
    public int getCurrWater() {
        return currWater;
    }
    
     /**
     * This function returns the minimum amount of water that can be stored in the container
     * 
     * @return The minimum amount of water that can be held in the container.
     */
    public int getMinWater() {
        return minWater;
    }

    /**
     * This function returns the maximum amount of water that can be stored in the container
     * 
     * @return The maxWater variable is being returned.
     */
    public int getMaxWater() {
        return maxWater;
    }

     /**
     * This function returns the current fertility of the field
     * 
     * @return The current fertility level.
     */
    public int getCurrFert() {
        return currFert;
    }

    /**
     * This function returns the minimum fertility of the land
     * 
     * @return The minimum fertility rate.
     */
    public int getMinFert() {
        return minFert;
    }

    /**
     * This function returns the maximum fertility of the land
     * 
     * @return The maxFert variable is being returned.
     */
    public int getMaxFert() {
        return maxFert;
    }

    /**
     * It returns a random number between the minProd and maxProd values
     * 
     * @return The value of the produced item.
     */
    public int getProduced(){
        // randomized the number of produced created then return the total 
        int value=0;
        if(minProd != 0){
            Random r = new Random();

            value =  r.nextInt(maxProd-minProd)+minProd;
            
        }
        else{
            value = maxProd;
        }
        
        return value;
    }
    

}
