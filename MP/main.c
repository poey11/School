#include <stdio.h>
#include <string.h>
#include <conio.h>
#include "func.c"


int main(){
    int nMenu=0,tPairs=0,nCount,c=0,temp,nChecker=0,i,PnE=0,start,total;
    char cCheck, cPass,cUser;
    int countArray[MAX_ENTRY];
    countArray[0]=0;
    string21 lang, trans;
    EntryType pEntries[1500];
    printf("Welcome To Language Tools\n");
    getch();
    do{
        printf("Main Menu: \n");
        printf("[1] Add Entry\n");
        printf("[2] Add Translations \n");
        printf("[3] Modify Entry\n");
        printf("[4] Delete Entry \n");
        printf("[5] Delete Translation \n");
        printf("[6] Display All Entries\n");
        printf("[7] Search Word\n");
        printf("[8] Search Translation\n");
        printf("[9] Export\n");
        printf("[10] Import\n");
        printf("[11] Exit\n");
        printf("Input Menu: ");
        scanf("%d", &nMenu);
        
        switch(nMenu){// this will run the menu and its corresponding functions
            case 1:// add entry is complete. check for bugs 
                printf("\n");
                printf("\t Add Entry\n\n");
                nCount=0;
                cCheck = 'y';
                do{ 
                    temp=-1;
                    strcpy(lang," ");
                    strcpy(trans," ");
                    printf("\t Entry#%d\n", nCount+1);
                        if(tPairs==0){// if tPairs ==0 it means that there is no previous entries in pEntries[]
                            tempEntry(&lang,&trans); //temporarily holds lang-trans pair
                            addEntry(&pEntries[tPairs++],lang,trans); // gets tempValue then adds it in the entry
                        }
                        else{// if there is entries already in pEntries[]
                            tempEntry(&lang,&trans);
                            temp = checkEntry(pEntries,lang,trans,tPairs);//checks if the tempValues is in the pEntries[]
                            if(temp==0){//if the tempValues doesnt exist in  pEntries[] it will be automatically be added in
                                addEntry(&pEntries[tPairs++],lang,trans);
                            }
                            else{// if the pair already exist in the pEnntries[], it will ask the user on what todo with it
                                printf("\t Is this a new entry? (Y/y to continue): ");
                                scanf(" %c",&cUser);
                                if(cUser=='Y'|| cUser=='y' ) {// if the user still want to add it to the pEntries[] and be able to add more pairs
                                    addEntry(&pEntries[tPairs++],lang,trans); 
                                }
                                else {
                                    cCheck = 'n';// or not then it will go back to the MainMenu 
                                    nCount--;
                                }
                            }
                        }
                    if(cCheck == 'y'){
                        printf("\t Do you want to add another entry? (N/n to Stop): ");// ask the user if they want to add more entries or not
                        scanf(" %c", &cPass);
                    }
                    printf("\n");
                    if (nCount == 10) cCheck ='n'; //checks if the user has inputted the max pairs per entry (which is 10 pairs per entry) and stops the user from adding more
                    else if(cPass=='n'||cPass=='N') cCheck = 'n';
                    nCount++; 
                }while(cCheck == 'y');
                if(nCount>=11) 
                    printf("\t You have reached the maximum pairs.\n");
                printf("\t Data Entry Succesful\n\n");
                countArray[PnE++] = nCount;//records the number of pairs per entry. PnE is the counter of how many entries has been registered. tPairs is the total number of pairs
                getch();
                break;
            case 2: 
                printf("\n");
                printf("\t Add Translations\n");
                break;
            case 3: 
                printf("\n");
                printf("\t Modify Entry\n");
                break;
            case 4: 
                printf("\n");
                printf("\t Delete Entry\n");
                break;
            case 5: 
                printf("\n");
                printf("\t Delete Translation\n");
                break;
            case 6: 
                start=0;
                total=0;
                cUser = ' ';
                nChecker =0;
                i=0;
                int j=0;
                while(j!=PnE){
                    printf("[%d]PnE=%d pPere=%d totalPairs=%d\n",j, PnE,countArray[j], tPairs );
                    j++;
                }
                if(PnE>0)i=1;
                printf("\n");
                printf("\t Display All Entries\n\n");
                while(nChecker == 0){//input the changing of display from to page 1 to page 2
                    printf("\t Page %d of %d\n\n",i,PnE);
                    dispAllEntry(pEntries,start,total);
                    printf("\n");
                    printf("\t 'P' to previous or 'N' to next. 'X' to exit: ");
                    scanf(" %c", &cUser);
                    printf("\n");
                    if(cUser == 'x' || cUser == 'X')  nChecker = 1;
                    else if(cUser == 'p' || cUser == 'P' ){
                        i--;
                        c--;
                        if(PnE==0||i<1){
                            printf("\n");
                            printf("\t No availabe Page\n\n");
                            i++;
                            c++;
                        }
                    }
                    else if(cUser == 'n' || cUser =='N'){
                        i++;
                        c++;
                        if(PnE==0||i>PnE){
                            printf("\n");
                            printf("\t No availabe Page\n\n");
                            i--;
                            c--;
                        }
                    }
                    else
                }      
                printf("\n");
                break;
            case 7: 
                printf("\n");
                printf("\t Search Word\n");
                break;
            case 8: 
                printf("\n");
                printf("\t Search Translation\n");
                break;
            case 9: 
                printf("\n");
                printf("\t Export\n");
                break;
            case 10: 
                printf("\n");
                printf("\t Import\n");
                break;
            case 11: 
                break;    
            default: 
                printf("\n");
                printf("\t Invalid value\n\n");
                getch();
        }
    }while(nMenu != 11);
    printf("\nExiting Program...\n");
    getch();
    return 0;
}