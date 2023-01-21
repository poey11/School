
/*
Payao, Malcolm Luens
Shirt Entrepreneur Game
CCPROG1 PROJECT
*/
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<conio.h>
void endSceneChecker(float bal, float debt){
    /*
        Description: So this function checks the debt and balance to send the 
appropiate end scene for the last day.
        Parameters:
        balance: To see how much money is left. 
        debt: To see how much Debt is left.
        return value will be what end scene will they get (good, neutral,bad)
    */
    
   if(debt>bal){
        printf("You failed to start a business and maintain it....");
   }
   else if(bal>debt && bal < 40){
         printf("You did ok but you couldn't maintain the business...");
   }
   else if(bal>debt && bal >= 40){
         printf("You did well!!! Not only did you manage to pay the debt but also maintain the business....");
   }
}
int main() {
    printf("SHIRT ENTPRENEUR GAMES\n");
    printf("Press any to start......");
    getch();
    float bal = 700.00, debt = 3000.00, rate = 3.25;
    int x=0;
    srand(time(0));
    int c,cUnits = 0 ,rUnits =0 ,pUnits = 0,a,b,k;
    float cost;
    float cheap = rand()%(40-60+1)+40, reg = rand()%(90-110+1)+90, premium=rand()%(290-330+1)+290;
    while(x==0){//day 0
        cost = 0;
        float bal3 = bal;
        system("cls");
        printf("Day: 0\n");
        printf("Balance: %.2f\n", bal);
        printf("Debt: %.2f\n", debt);
        printf("---------------------------\n");
        printf("Manufacture Order\n");
        printf("Shirt Types and Prices for the day: \n");
        printf("1. Cheap  (%.2f)\n", cheap );
        printf("2. Regular (%.2f)\n", reg);
        printf("3. Premuim (%.2f)\n", premium);
        printf("4. Skip \n");
        printf("Choose what to order? ");
        printf("\n:> ");
        scanf("%d", &c);
            if(c==1){
                printf("How many cheap shirts will you buy? ");
                printf("\n:> ");
                scanf("%d",&k);
                cost=cheap*k;
                bal3-=cost;
                printf("That will cost you %.2f, which will leave you with a balance of %.2f. Confirm Order? 1=YES 2=N0 ",cost, bal3);
                printf("\n:> ");
                scanf("%d", &a);
                if(cost>bal && a== 1){
                    printf("Insufficient Balance.\n");
                    getch();
                    system("cls");
                }
                else if(a==1){
                    printf("Order Confirmed. Do you wish to order more shirt? 1=YES 2=N0 ");
                    printf("\n:> ");
                    scanf("%d",&b);
                    if(b==1){
                    bal -= cost;
                    cUnits+=k;   
                    system("cls");
                    }
                    else if(b==2){
                        bal -= cost;
                        cUnits+=k;   
                        x++;
                    }
                }
                else if(a==2){
                } 
                
            }
        else if(c==2){
            printf("How many regular shirts will you buy? ");
            printf("\n:> ");
            scanf("%d",&k);
            cost = reg*k;
            bal3-=cost;
            printf("That will cost you %.2f, which will leave you with a balance of%.2f. Confirm Order? 1=YES 2=N0 ",cost, bal3);
            printf("\n:> ");
            scanf("%d", &a);
            if(cost>bal&& a== 1){
                printf("Insufficient Balance.\n");
                getch();
                system("cls");
            }
            else if(a==1){
                printf("Order Confirmed. Do you wish to order more shirt? 1=YES 2=N0 ");
                printf("\n:> ");
                scanf("%d",&b);
                if(b==1){
                    bal -= cost;
                    rUnits+=k;
                }
                else if(b==2){
                    bal -= cost;
                    rUnits+=k;
                    x++;
                }
            }
            else if(a==2){
            } 
        }
        else if(c==3){
            printf("How many premium shirts will you buy? ");
            printf("\n:> ");
            scanf("%d",&k);
            cost = premium*k;
            bal3-=cost;
            printf("That will cost you %.2f, which will leave you with a balance of%.2f. Confirm Order? 1=YES 2=N0 ",cost, bal3);
            printf("\n:> ");
            scanf("%d", &a);
            if(cost>bal&& a== 1){
                printf("Insufficient Balance.\n");
                getch();
                system("cls");
            }
            else if(a==1){
                printf("Order Confirmed. Do you wish to order more shirt? 1=YES 2=N0 ");
                printf("\n:> ");
                scanf("%d",&b);
                if(b==1){
                    bal -= cost;
                    pUnits+=k;  
                }
                else if(b==2){
                    bal -= cost;
                    pUnits+=k;  
                    x++;
                }
            }
            else if(a==2){
            } 
        }
        else if(c==4){
             x++;
        }
    }
    for(int i = 1; i<=30;i++){ 
        int o = 0;
        int choice,p;
        int  y=0;
        while(o==0){
            system("cls");
            printf("Day: %d\n", i);
            printf("Updated Balance: %.2f\n", bal);
            printf("Updated Debt: %.2f\n", debt);
            printf("-------------------------------\n");
            printf("Updated Inventory: \n");
            printf("%d Cheap Shirt\n", cUnits);
            printf("%d Regular Shirt\n", rUnits);
            printf("%d Premium Shirt\n", pUnits);
            printf("-------------------------------\n");
            printf("What to do? (1-5)\n");
            printf("1. Sell Shirts\n");
            printf("2. Manufacture Shirts\n");
            printf("3. Take Loan\n");
            printf("4. Pay Debt\n");
            printf("5. Skip Day\n");
            printf(":> ");
            scanf("%d", &choice);
            float cheapRetail = 70.00, regularRetail = 140.00, premiumRetail = 450.00;
            if(choice == 1 && cUnits == 0 && rUnits == 0 && pUnits == 0){
                printf("-------------------------------\n");
                printf("\nYou can't sell with no shirt available.....\n");
                printf("\n-------------------------------\n");
                getch();
            }// selling shirt with no shirt avail....
            else if(choice == 1){// sell shirts
                int nosOfCust = rand()%(1-5+1)+1;
                printf("-------------------------------\n");
                for(int i = nosOfCust; i > 0; i--){
                    int customerGen = rand()%(1-100+1)+1;
                    y=0;
                    printf("A customer visits you..... Which shirt would you offer?(1 - cheap, 2 - regular, 3 - premium)\n");
                    while(y==0){
                        printf("nosofcus: %d,  customerGen: %d/n", nosOfCust, customerGen);
                        printf(":> ");
                        scanf("%d",&p);
                        if(!(p>=1&&p<=3)){
                            printf("Invalid Choice\n");
                        }
                        else if(p>=1&&p<=3 &&customerGen>= 0 && customerGen <= 60){//Average Customer
                            if( p == 1&&cUnits > 0 ){
                                printf("The customer liked your offer and pays you %.2f\n", cheapRetail);
                                printf("-------------------------------\n");
                                bal+=cheapRetail;
                                cUnits--;
                            }
                            else if(p == 2 && rUnits > 0){
                                printf("The customer liked your offer and pays you %.2f\n", regularRetail);
                                printf("-------------------------------\n");
                                bal+=regularRetail;
                                rUnits--;
                            }
                            else if(p == 3 && pUnits > 0){
                                printf("The customer disliked your offer and leaves the store\n");
                                printf("-------------------------------\n");
                            }
                            else {
                                printf("No stocks Available. Your customer left the store...\n");
                                printf("-------------------------------\n");
                                getch();
                            }
                            y++;
                        }
                        else if(p>=1&&p<=3 &&customerGen>=  61 && customerGen <= 90){//Thrity Customer
                            if(p == 1&&cUnits > 0){
                              printf("The customer liked your offer and pays you %.2f\n", cheapRetail);
                              printf("-------------------------------\n");
                              bal+=cheapRetail;
                              cUnits--;
                            
                            }
                            else if(p == 2 && rUnits > 0){
                             printf("The customer disliked your offer and leaves the store\n");
                             printf("-------------------------------\n");
                        
                            }
                            else if(p == 3 && pUnits > 0){
                                printf("The customer disliked your offer and leaves the store\n");
                                printf("-------------------------------\n");
                            
                            }
                            else{
                                printf("No stocks Available. Your customer left the store...\n");
                                printf("-------------------------------\n");
                                getch();
                            }
                            y++;
                        }
                        else if(p>=1&&p<=3 && customerGen>=  91 && customerGen <= 100){//Rich Customer
                            if(p == 1&&cUnits > 0){
                                printf("The customer liked your offer and pays you %.2f\n", cheapRetail);
                                printf("-------------------------------\n");
                                bal+=cheapRetail;
                                cUnits--;
                            }
                            else if(p == 2 && rUnits > 0){
                                printf("The customer liked your offer and pays you %.2f\n", regularRetail);
                                printf("-------------------------------\n");
                                bal+=regularRetail;
                                rUnits--;
                            }
                            else if(p == 3 && pUnits > 0){
                                printf("The customer liked your offer and pays you %.2f\n", premiumRetail);
                                printf("-------------------------------\n");
                                bal+=premiumRetail;
                                pUnits--;
                            }
                             else{
                                printf("No stocks Available. Your customer left thestore...\n");
                                printf("-------------------------------\n");
                                getch();
                            }
                            y++;
                        }
                    } //y - while loop
                } // nosOfcust for loop 
                printf("\nNo more Customers for today. \n");
                printf("\n---------End of Day %d----------\n", i);
                getch();
                o++; 
            } // chouice ==1
            else if(choice == 2){// buy shirts
                int buy=0; 
                k=0;
                cost =0;
                cheap = rand()%(40-60+1)+40, reg = rand()%(90-110+1)+90, premium=rand()%(290-330+1)+290;
                while(buy==0){
                    system("cls");
                    printf("-------------------------------\n");
                    printf("Updated Balance: %.2f\n", bal);
                    printf("-------------------------------\n");
                    printf("Updated Inventory: \n");
                    printf("%d Cheap Shirt\n", cUnits);
                    printf("%d Regular Shirt\n", rUnits);
                    printf("%d Premium Shirt\n", pUnits);
                    printf("-------------------------------\n");
                    printf("Manufacture Order\n");
                    printf("Shirt Types and Prices for the day: \n");
                    printf("1. Cheap  (%.2f)\n", cheap );
                    printf("2. Regular (%.2f)\n", reg);
                    printf("3. Premuim (%.2f)\n", premium);
                    printf("4. Skip \n");
                    printf("Choose what to order? ");
                    float bal2=bal;
                    printf("\n:> ");
                    scanf("%d", &c);
                    if(c==1){
                        printf("How many cheap shirts will you buy? ");
                        printf("\n:> ");
                        scanf("%d",&k);
                        cost=cheap*k;
                        bal2-=cost;
                        printf("That will cost you %.2f, which will leave you with a balance of %.2f. Confirm Order? 1=YES 2=N0 ",cost, bal2);
                        printf("\n:> ");
                        scanf("%d", &a);
                        if(cost>bal&&a==1){
                            printf("Insufficient Balance.\n");
                            getch();
                            system("cls");
                        }
                        else if(a==1){
                            printf("Order Confirmed. Do you wish to order more shirt? 1=YES 2=N0  ");
                            printf("\n:> ");
                            scanf("%d",&b);
                            if(b==1){
                                bal-=cost;
                                cUnits+=k;
                            }
                            else if(b==2){
                                bal-=cost;
                                cUnits+=k;
                                buy++;
                            }
                        }
                        else if(a==2){
                        }  
                    }
                    else if(c==2){
                        printf("How many regular shirts will you buy? ");
                        printf("\n:> ");
                        scanf("%d",&k);
                        cost=reg*k;
                        bal2-=cost;
                        printf("That will cost you %.2f, which will leave you with a balance of %.2f. Confirm Order?  1=YES 2=N0 ",cost, bal2);
                        printf("\n:> ");
                        scanf("%d", &a);
                        if(cost>bal&&a==1){
                            printf("Insufficient Balance.\n");
                            getch();
                            system("cls");
                        }
                        else if(a==1){
                            printf("Order Confirmed. Do you wish to order more shirt? 1=YES 2=N0 ");
                            printf("\n:> ");
                            scanf("%d",&b);
                            if(b==1){
                                bal-=cost;
                                rUnits+=k;
                            }
                            else if(b==2){
                                bal-=cost;
                                rUnits+=k;
                                buy++;
                            }
                        }
                        else if(a==2){
                        } 
                    }
                    else if(c==3){
                        printf("How many premium shirts will you buy? ");
                        printf("\n:> ");
                        scanf("%d",&k);
                        cost=premium*k;
                        bal2-=cost;
                        printf("That will cost you %.2f, which will leave you with a balance of %.2f. Confirm Order? 1=YES 2=N0 ",cost, bal2);
                        printf("\n:> ");
                        scanf("%d", &a);
                        if(cost>bal&& a==1){
                            printf("Insufficient Balance.\n");
                            getch();
                            system("cls");
                        }
                        else if(a==1){
                            printf("Order Confirmed. Do you wish to order more shirt? 1=YES 2=N0 ");
                            printf("\n:> ");
                            scanf("%d",&b);
                            if(b==1){
                                bal-=cost;
                                pUnits+=k;  
                            }
                            else if(b==2){
                                bal-=cost;
                                pUnits+=k;  
                                buy++;
                            }
                        }
                        else if(a==2){
                        } 
                    }
                    else if(c==4){
                        buy++;
                    }
                }//buy while loop
                printf("\n---------End of Day %d----------\n", i);
                getch();
                o++;
            } // choice ==2 
            else if(choice == 3){// loan more money
                float borrow=0;
                printf("-------------------------------\n");
                printf("How much will you loan?");
                printf("\n:> ");
                scanf("%f",&borrow);
                debt+=borrow;
                bal+=borrow;
                printf("-------------------------------\n");
                printf("Updated Balance: %.2f\n", bal);
                printf("Updated Debt: %.2f\n", debt);
                printf("-------------------------------\n");
                printf("\n---------End of Day %d----------\n", i);
                getch();
                o++;
            }//choice==3
            else if(choice == 4){// pay debt
                int debting =0;
                system("cls");
                while(debting==0){
                    float payingDebt;
                    printf("-------------------------------\n");
                    printf("Updated Balance: %.2f\n", bal);
                    printf("Updated Debt: %.2f\n", debt);
                    printf("-------------------------------\n");
                    printf("How much will you pay for the Debt? ");
                    printf("\n:> ");
                    scanf("%f", &payingDebt);
                    if(payingDebt>bal){
                        printf("Insufficient Balance.");
                        getch();
                        system("cls");
                    }
                    else{
                        bal-= payingDebt;
                        debt-= payingDebt;
                        printf("-------------------------------\n");
                        printf("Updated Balance: %.2f\n", bal);
                        printf("Updated Debt: %.2f\n", debt);
                        printf("-------------------------------\n");
                        printf("\n---------End of Day %d----------\n", i);
                        getch();
                        debting++;
                    }
                }//debting while loop
                o++;
            }//choice == 4
            else if(choice==5){//skip day
                printf("-------------------------------\n");
                printf("\nYou Choose to skip the day\n");
                printf("\n---------End of Day %d----------\n", i);
                getch();
                o++;
            }//choice ==5
        }// o - while loop
        debt+=(debt*0.0325);
    } // day for loop
    float debt2 = debt, bal4 = bal;
    bal-=debt2;
    debt-= bal4;
    system("cls");
    printf("Remaining Debt: %.2f\n", debt);
    printf("-------------------------------\n");
    printf("After 30 days....\n");
    getch();
    printf("You have paid the remaining debt with your remaining balance....\n");
    getch();
    printf("You are left with....\n");
    getch();
    printf("Remaning Balance: %.2f\n", bal);
    printf("Remaining Debt: %.2f\n", debt);
    printf("-------------------------------\n");
    getch();
    printf("\n");
    endSceneChecker(bal,debt);
    printf("\n\n-------------------------------\n");
return 0; 
} // int main 
