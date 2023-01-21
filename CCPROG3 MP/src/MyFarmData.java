public class MyFarmData {
    
    private  Crop t[][] = new Crop[5][10];

    public MyFarmData(){

    }
    
     /**
     * This function returns the crop at the specified tile row and column
     * 
     * @param tileRow The row of the tile you want to get.
     * @param tileColumn The column of the tile you want to get.
     * @return The crop object at the specified tileRow and tileColumn.
     */
    public Crop getTile(int tileRow, int tileColumn){
        return t[tileRow][tileColumn];
    }
     /**
     * This function removes a tile from the board
     * 
     * @param tileRow The row of the tile you want to remove.
     * @param tileColumn The column of the tile you want to remove.
     */
    public void removeTile(int tileRow, int tileColumn){
        t[tileRow][tileColumn] = null;
    }


    /**
     * It checks if the tile is null, if it is, it checks the button name and puts the appropriate crop
     * into the tile
     * 
     * @param tileRow the row of the tile
     * @param tileColumn the column of the tile
     */
    public void tileChecker(int tileRow, int tileColumn){
        // check the the levels to give the appropiate bonuses 
        int bonusEarnings=0, waterBonusLimit=0, fertBonusLimit=0;
        if(MyFarm.p.getLevel() == 5) {
            bonusEarnings = 1;
        }
        else if(MyFarm.p.getLevel() == 10){
            bonusEarnings = 2;
            waterBonusLimit = 1;
        }
        else if(MyFarm.p.getLevel() == 15){
            bonusEarnings = 4;
            waterBonusLimit = 2;
            fertBonusLimit = 1;
        }

        //checks if the tile null if not it indicates that the tile has already a plant crop in it
        if(t[MyFarm.tileRow][MyFarm.tileColumn] == null){
            //checkes the button name so it can put the appropiate crop into that tile
            if ( MyFarm.tile[tileRow][tileColumn].getText() == "Turnip"  ) {
                t[tileRow][tileColumn] = new Crop("Turnip", "Root",2, 1, 2+waterBonusLimit, 0, 1+fertBonusLimit, 1, 2,  6+bonusEarnings, 5);
            }
            else if(MyFarm.tile[tileRow][tileColumn].getText() == "Carrot"){
                t[tileRow][tileColumn] =new Crop("Carrot", "Root",3, 1, 2+waterBonusLimit, 0, 1+fertBonusLimit, 1, 2,  9+bonusEarnings, 7.5);
            }
            else if(MyFarm.tile[tileRow][tileColumn].getText() == "Potato"){
                t[tileRow][tileColumn] = new Crop("Potato","Root", 5, 3, 4+waterBonusLimit, 1, 2+fertBonusLimit, 1, 10,  3+bonusEarnings, 12.5);
            }
            else if(MyFarm.tile[tileRow][tileColumn].getText() == "Rose"){
                t[tileRow][tileColumn] =new Crop("Rose", "Flower",1, 1, 2+waterBonusLimit, 0, 1+fertBonusLimit, 0, 1,  5+bonusEarnings, 2.5);
            }
            else if(MyFarm.tile[tileRow][tileColumn].getText() == "Tulips"){
                t[tileRow][tileColumn] =new Crop("Tulips", "Flower",2, 2, 3+waterBonusLimit, 0, 1+fertBonusLimit, 0, 1,  9+bonusEarnings, 5);
            }
            else if(MyFarm.tile[tileRow][tileColumn].getText() == "Sunflower"){
                t[tileRow][tileColumn] =new Crop("Sunflower",  "Flower",3, 2, 3+waterBonusLimit, 1, 2+fertBonusLimit, 0, 1, 19+bonusEarnings, 7.5);
            }   
            else if(MyFarm.tile[tileRow][tileColumn].getText() == "Mango"){
                t[tileRow][tileColumn] = new Crop("Mango",  "Fruit",10, 7, 7+waterBonusLimit, 4, 4+fertBonusLimit, 5, 15,  8+bonusEarnings, 25);
            }
            else if(MyFarm.tile[tileRow][tileColumn].getText() == "Apple" ){
                t[tileRow][tileColumn] = new Crop("Apple",  "Fruit",10, 7, 7+waterBonusLimit, 5, 5+fertBonusLimit, 10, 15, 5+bonusEarnings, 25);
            }
        }
        
       

    }

}
