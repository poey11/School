#include "struc.h"
#include <string.h>

void addEntry(EntryType *e,string21 a, string21 b){
    //puts the tempValue into the nEntry[]
    strcpy((*e).lang,a);
    strcpy((*e).trans,b);
}

void tempEntry(string21 *a, string21 *b){
    //Holds the tempValue
    printf("\t Input Language: ");
    scanf(" %s", a);
    printf("\t Input Translation: ");
    scanf(" %s", b);
}

void switchA(EntryType *a, EntryType *b){
    /*switch position of a to b and b to a in a Array*/
    EntryType temp = *a, temp2 = *b;
    *a = temp2;
	*b = temp;

}

void sortA(EntryType *e, int nEntry){
    int j,k;
    /*Sorts the nEntry[].lang only alphabetically*/
    for(j=0; j<nEntry; j++){
            for(k=0;k<nEntry-1;k++){
                if(strcmp(e[k+1].lang,e[k].lang)<0){
                    switchA(&e[k],&e[k+1]);
                }
            }
        }
}

int checkEntry(EntryType *c, string21 a,string21 b , int  nEntry){
// check if the tempValue and entry[].data are the same if it is it return 1 if it is not return 0
    int i,l=0,k=0,j=0;
    for(i=0; i<nEntry; i++){
        sortA(c, nEntry);
        if( strcmp(c[i].lang, a) == 0 &&  strcmp(c[i].trans, b) ==0 ) {
            if(j==0) printf("\t The entry already exist: \n" );
            printf("\t [%d]: %s %s\n",i+1, c[i].lang,c[i].trans);
            k=1;
            j=1;
        }
    }
    if(k==1){
      l=1;  
    } 
    else l=0;

    return l;
}

void displayA(EntryType *e){
    /*displays the lang-trans pair*/
    printf("\t %s %s\n",e->lang, e->trans);
}

void dispAllEntry(EntryType *e, int total, int start){
    //display the all the entry with controls
    int i=start;
    if(nEntry==0) printf("\t No entries to display\n");
    sortA(e,nEntry);// sort the array alphabetically

    while(i!=total){
        printf("\t Entry[%d]:",i+1);
        displayA(&e[i]);
        i++;
    }
}

void addTrans(){
    
}