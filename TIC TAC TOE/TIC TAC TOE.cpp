#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>

char retry='Y';
char grid[3][3];
int counter;

int main(void){
    void delay(float number_of_seconds);
    void print_grid(void);
    char scan_char(void);
    void scan_num(char i);
    void random(char i);
    int logic (char i, char p);
    int prof_logic(char i, char p);
    int print_winner(char i);

    printf("                                              ##########################\n");
    printf("                                              # Welcome to TIC TAC TOE #\n");
    printf("                                              ##########################    \tBy: Abdullah.Yehia\n");
    while(retry=='Y'){
    grid[0][0]='7';grid[0][1]='8';grid[0][2]='9';grid[1][0]='4';grid[1][1]='5';grid[1][2]='6';grid[2][0]='1';grid[2][1]='2';grid[2][2]='3';
    counter=1;

    printf("\nHow many players ( 1 / 2 ): ");
    char temp_num_p[2]={'9'};
    char num_p='9';
        while (num_p !='1' && num_p != '2'){
            scanf("%s",temp_num_p);
            if(strlen(temp_num_p)>1){printf("Wrong input ... Choose again: ");continue;}
            num_p=temp_num_p[0];
                if (num_p !='1' && num_p != '2' ){printf("Wrong input ... Choose again: ");continue;}
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////    2  player     ////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    if (num_p == '2'){
        printf("\nChoose first player's character ( X / O ): ");
        char icon=scan_char();

        char opp;
        if (icon=='X')
            opp='O';
        else
            opp='X';
        while(true){
//////////////////////////////////////////////////////////////  first player turn  //////////////////////////////////////////////////////////////////////////
            printf("\n");
            print_grid();
            printf("\nPlayer 1, choose a number: ");
            scan_num(icon);

            int f=print_winner(icon);
            if (f==0)
                break;


//////////////////////////////////////////////////////////////  second player turn  //////////////////////////////////////////////////////////////////////////
            printf("\n");
            print_grid();
            printf("\nPlayer 2, choose a number: ");
            scan_num(opp);

            int d=print_winner(opp);
            if (d==0)
                break;
        }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////    1  player     ////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }else if (num_p == '1'){
        printf("\nChoose your character ( X / O ): ");
        char icon=scan_char();

        char opp;
        if (icon=='X')
            opp='O';
        else
            opp='X';

        char temp_hard[1]={'k'};
        char hard ='l';
        printf("\nChoose your hardness (E for Easy / M for Medium / H for Hard): ");
        while (hard !='H' && hard != 'E' && hard != 'M'){
            scanf("%s",temp_hard);
            if(strlen(temp_hard)>1){printf("Wrong input ... Choose again: ");continue;}
            hard=temp_hard[0];
                if (hard !='H' && hard != 'h' && hard !='E' && hard != 'e' && hard != 'M' && hard != 'm'){printf("Wrong input ... Choose again: ");continue;}

                if(hard == 'h')hard ='H';
                else if (hard == 'e')hard ='E';
                else if (hard == 'm')hard = 'M';
        }

//////////////////////////////////////////////////////////////// scanning is done ///////////////////////////////////////////////////////////////////////////
        printf("\n");
        print_grid();
        while(true){
//////////////////////////////////////////////////////////////////// player /////////////////////////////////////////////////////////////////////////////////
            if (counter == 1 && icon=='O')
                ;
            else{
                printf("\nChoose a number: ");
                scan_num(icon);

                int p=print_winner(icon);
                if (p==0)
                    break;
            }

////////////////////////////////////////////////////////////////// opponent ///////////////////////////////////////////////////////////////
            printf("\nwait, its computer turn...\n\n");
            if (hard=='E'){
                void delay(float number_of_seconds);
                delay(0.25);
                random(opp);

            }else if (hard=='M'){
                delay(0.75);
                int played = logic(opp, icon);
                if (played == 1)
                    random(opp);
            }else if (hard=='H'){
                delay(1.0);
                int played = prof_logic(opp, icon);
                if (played == 2)
                    random(opp);
            }
            int q=print_winner(opp);
            if (q==0)
                break;

            print_grid();
            counter++;
        }
    }

    char temp_retry[1]={'k'};
    retry='k';
    while (retry !='Y' && retry != 'N'){
            scanf("%s",temp_retry);
            if(strlen(temp_retry)>1){printf("Wrong input ... Choose again: ");continue;}
            retry=temp_retry[0];
                if (retry !='Y' && retry != 'y' && retry !='N' && retry != 'n'){printf("Wrong input ... Choose again: ");continue;}

                if(retry == 'y'){retry ='Y';}
                else if (retry == 'n'){retry ='N';}
    }
    }
}


void delay(float number_of_seconds){
    //#include<time.h>
    float milli_seconds = 1000 * number_of_seconds;
    clock_t start_time = clock();
    while (clock() < start_time + milli_seconds)
        ;
}

void print_grid(void){
    printf("\t");
    for (int x=0 ; x<3 ; x++){
        for (int y=0 ; y<3 ; y++){
            printf(" %c ",grid[x][y]);
        }
        printf("\n\t");
    }
}

char scan_char(void){
    char temp_icon[1]={'k'};
    char icon ='k';
    while (icon !='X' && icon != 'O'){
        scanf("%s",temp_icon);
        if(strlen(temp_icon)>1){printf("Wrong input ... Choose again: ");continue;}
        icon=temp_icon[0];
        if (icon !='X' && icon != 'x' && icon !='O' && icon != 'o'){printf("Wrong input ... Choose again: ");continue;}

        if(icon == 'x'){icon ='X';}
        else if (icon == 'o'){icon ='O';}
    }
    return icon;
}

void scan_num(char i){
    char temp_num[1]={'k'};
    char num ='l';
    int cond = 0;
    while(true){
        scanf("%s",temp_num);
        if(strlen(temp_num)>1){printf("Wrong input ... Choose again: ");continue;}
        num=temp_num[0];
        if(!(num>='1' && num<='9')){
            printf("\nWrong Input ... Choose again: ");
            continue;
        }

        for (int x=0 ; x<3 ; x++){
            for (int y=0 ; y<3 ; y++){
                if(num==grid[x][y]){
                    cond++;
                    grid[x][y]=i;
                }
            }
        }
        if(cond != 0){break;}
        printf("\nAlready Used ... Choose again: ");
    }
}

void random(char i){
    //#include<stdlib.h>
    while(true){
        bool cond_o=false;
        int numb=(rand()%9)+1;
        for (int x=0 ; x<3 ; x++){
            for (int y=0 ; y<3 ; y++){
                if(numb==grid[x][y]-'0'){
                        cond_o=true;
                        grid[x][y]=i;
                }
            }
        }
        if(cond_o==true){break;}
    }
}

bool check(int x, int y){
    if(grid[x][y]=='7' || grid[x][y]=='8' || grid[x][y]=='9' || grid[x][y]=='4' || grid[x][y]=='5' || grid[x][y]=='6' || grid[x][y]=='1' || grid[x][y]=='2' || grid[x][y]=='3')
        return true;
    else
        return false;
}

int logic(char i, char p){
    char opp=i;
    char icon=p;
    /////////////////////////////////////////////////////////       winning        //////////////////////////////////////////////////////////
            ////////////////////////////////////////// horizontal /////////////////////////////
         if(grid[0][0]==grid[0][1] && grid[0][1]==opp && check(0,2)){grid[0][2]=opp;return 0;}
    else if(grid[1][0]==grid[1][1] && grid[1][1]==opp && check(1,2)){grid[1][2]=opp;return 0;}
    else if(grid[2][0]==grid[2][1] && grid[2][1]==opp && check(2,2)){grid[2][2]=opp;return 0;}
    else if(grid[0][0]==grid[0][2] && grid[0][2]==opp && check(0,1)){grid[0][1]=opp;return 0;}
    else if(grid[1][0]==grid[1][2] && grid[1][2]==opp && check(1,1)){grid[1][1]=opp;return 0;}
    else if(grid[2][0]==grid[2][2] && grid[2][2]==opp && check(2,1)){grid[2][1]=opp;return 0;}
    else if(grid[0][2]==grid[0][1] && grid[0][1]==opp && check(0,0)){grid[0][0]=opp;return 0;}
    else if(grid[1][2]==grid[1][1] && grid[1][1]==opp && check(1,0)){grid[1][0]=opp;return 0;}
    else if(grid[2][2]==grid[2][1] && grid[2][1]==opp && check(2,0)){grid[2][0]=opp;return 0;}
            ////////////////////////////////////////// vertical ////////////////////////////////
    else if(grid[0][0]==grid[1][0] && grid[1][0]==opp && check(2,0)){grid[2][0]=opp;return 0;}
    else if(grid[0][0]==grid[2][0] && grid[2][0]==opp && check(1,0)){grid[1][0]=opp;return 0;}
    else if(grid[2][0]==grid[1][0] && grid[1][0]==opp && check(0,0)){grid[0][0]=opp;return 0;}
    else if(grid[0][1]==grid[1][1] && grid[1][1]==opp && check(2,1)){grid[2][1]=opp;return 0;}
    else if(grid[0][1]==grid[2][1] && grid[2][1]==opp && check(1,1)){grid[1][1]=opp;return 0;}
    else if(grid[2][1]==grid[1][1] && grid[1][1]==opp && check(0,1)){grid[0][1]=opp;return 0;}
    else if(grid[0][2]==grid[1][2] && grid[1][2]==opp && check(2,2)){grid[2][2]=opp;return 0;}
    else if(grid[0][2]==grid[2][2] && grid[2][2]==opp && check(1,2)){grid[1][2]=opp;return 0;}
    else if(grid[2][2]==grid[1][2] && grid[1][2]==opp && check(0,2)){grid[0][2]=opp;return 0;}
            /////////////////////////////////////////// diagonal ///////////////////////////////////
    else if(grid[0][0]==grid[1][1] && grid[1][1]==opp && check(2,2)){grid[2][2]=opp;return 0;}
    else if(grid[0][0]==grid[2][2] && grid[2][2]==opp && check(1,1)){grid[1][1]=opp;return 0;}
    else if(grid[1][1]==grid[2][2] && grid[2][2]==opp && check(0,0)){grid[0][0]=opp;return 0;}
    else if(grid[0][2]==grid[1][1] && grid[1][1]==opp && check(2,0)){grid[2][0]=opp;return 0;}
    else if(grid[0][2]==grid[2][0] && grid[2][0]==opp && check(1,1)){grid[1][1]=opp;return 0;}
    else if(grid[1][1]==grid[2][0] && grid[2][0]==opp && check(0,2)){grid[0][2]=opp;return 0;}

/////////////////////////////////////////////////       in case no win             ///////////////////////////////////////////////////////
            ////////////////////////////////////////// horizontal /////////////////////////////
    else if(grid[0][0]==grid[0][1] && grid[0][1]==icon && check(0,2)){grid[0][2]=opp;return 0;}
    else if(grid[1][0]==grid[1][1] && grid[1][1]==icon && check(1,2)){grid[1][2]=opp;return 0;}
    else if(grid[2][0]==grid[2][1] && grid[2][1]==icon && check(2,2)){grid[2][2]=opp;return 0;}
    else if(grid[0][0]==grid[0][2] && grid[0][2]==icon && check(0,1)){grid[0][1]=opp;return 0;}
    else if(grid[1][0]==grid[1][2] && grid[1][2]==icon && check(1,1)){grid[1][1]=opp;return 0;}
    else if(grid[2][0]==grid[2][2] && grid[2][2]==icon && check(2,1)){grid[2][1]=opp;return 0;}
    else if(grid[0][2]==grid[0][1] && grid[0][1]==icon && check(0,0)){grid[0][0]=opp;return 0;}
    else if(grid[1][2]==grid[1][1] && grid[1][1]==icon && check(1,0)){grid[1][0]=opp;return 0;}
    else if(grid[2][2]==grid[2][1] && grid[2][2]==icon && check(2,0)){grid[2][0]=opp;return 0;}
            ////////////////////////////////////////// vertical ////////////////////////////////
    else if(grid[0][0]==grid[1][0] && grid[1][0]==icon && check(2,0)){grid[2][0]=opp;return 0;}
    else if(grid[0][0]==grid[2][0] && grid[2][0]==icon && check(1,0)){grid[1][0]=opp;return 0;}
    else if(grid[2][0]==grid[1][0] && grid[1][0]==icon && check(0,0)){grid[0][0]=opp;return 0;}
    else if(grid[0][1]==grid[1][1] && grid[1][1]==icon && check(2,1)){grid[2][1]=opp;return 0;}
    else if(grid[0][1]==grid[2][1] && grid[2][1]==icon && check(1,1)){grid[1][1]=opp;return 0;}
    else if(grid[2][1]==grid[1][1] && grid[1][1]==icon && check(0,1)){grid[0][1]=opp;return 0;}
    else if(grid[0][2]==grid[1][2] && grid[1][2]==icon && check(2,2)){grid[2][2]=opp;return 0;}
    else if(grid[0][2]==grid[2][2] && grid[2][2]==icon && check(1,2)){grid[1][2]=opp;return 0;}
    else if(grid[2][2]==grid[1][2] && grid[1][2]==icon && check(0,2)){grid[0][2]=opp;return 0;}
            /////////////////////////////////////////// diagonal ///////////////////////////////////
    else if(grid[0][0]==grid[1][1] && grid[1][1]==icon && check(2,2)){grid[2][2]=opp;return 0;}
    else if(grid[0][0]==grid[2][2] && grid[2][2]==icon && check(1,1)){grid[1][1]=opp;return 0;}
    else if(grid[1][1]==grid[2][2] && grid[2][2]==icon && check(0,0)){grid[0][0]=opp;return 0;}
    else if(grid[0][2]==grid[1][1] && grid[1][1]==icon && check(2,0)){grid[2][0]=opp;return 0;}
    else if(grid[0][2]==grid[2][0] && grid[2][0]==icon && check(1,1)){grid[1][1]=opp;return 0;}
    else if(grid[1][1]==grid[2][0] && grid[2][0]==icon && check(0,2)){grid[0][2]=opp;return 0;}

    else return 1;
}

int prof_logic(char i, char p){
    char icon=p;
    char opp=i;
    ///////////////////////////////////////////////////////  first move  //////////////////////////////////////////////////////////////////
    if(counter==1){
        if(check(1,1)){grid[1][1]=opp;return 0;}
        else{grid[2][2]=opp;return 0;}
    }
    int played=logic(i,p);
    if(played == 1){
////////////////////////////////////////////////////////// winning logic //////////////////////////////////////////////////////////////////
        if(grid[1][1]==grid[2][2] && grid[1][1]==opp){
                 if(check(0,2) && check(1,2) && check(2,0)){grid[0][2]=opp;return 0;}
            else if(check(0,2) && check(1,2) && check(1,0)){grid[1][2]=opp;return 0;}
            else if(check(2,0) && check(2,1) && check(0,2)){grid[2][0]=opp;return 0;}
            else if(check(2,0) && check(2,1) && check(0,1)){grid[2][1]=opp;return 0;}
        }
        else if(grid[1][1]==grid[0][0] && grid[1][1]==opp){
                 if(check(0,1) && check(2,1) && check(0,2)){grid[0][1]=opp;return 0;}
            else if(check(0,1) && check(0,2) && check(2,0)){grid[0][2]=opp;return 0;}
            else if(check(2,0) && check(1,0) && check(0,2)){grid[2][0]=opp;return 0;}
            else if(check(2,0) && check(1,0) && check(1,2)){grid[1][0]=opp;return 0;}
        }
        else if(grid[1][1]==grid[0][2] && grid[1][1]==opp){
                 if(check(0,0) && check(0,1) && check(2,2)){grid[0][0]=opp;return 0;}
            else if(check(0,0) && check(0,1) && check(2,1)){grid[2][1]=opp;return 0;}
            else if(check(0,0) && check(0,1) && check(2,2)){grid[2][2]=opp;return 0;}
            else if(check(1,0) && check(2,2) && check(1,2)){grid[1][2]=opp;return 0;}
        }
        else if(grid[1][1]==grid[2][0] && grid[1][1]==opp){
                 if(check(0,0) && check(2,2) && check(2,1)){grid[2][2]=opp;return 0;}
            else if(check(0,1) && check(2,2) && check(2,1)){grid[2][1]=opp;return 0;}
            else if(check(0,0) && check(1,0) && check(2,2)){grid[0][0]=opp;return 0;}
            else if(check(0,0) && check(1,0) && check(1,2)){grid[1][0]=opp;return 0;}
        }
        else if(grid[0][0]==grid[2][2] && grid[0][0]==opp){
                 if(check(1,0) && check(2,0) && check(2,1)){grid[2][0]=opp;return 0;}
            else if(check(0,1) && check(0,2) && check(1,2)){grid[0][2]=opp;return 0;}
        }
        else if(grid[0][2]==grid[2][0] && grid[0][2]==opp){
                 if(check(0,0) && check(0,1) && check(1,0)){grid[0][0]=opp;return 0;}
            else if(check(1,2) && check(2,2) && check(2,1)){grid[2][2]=opp;return 0;}
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////    # # #
    ////////////////////////////////////       TODO         //////////////////////////////////////////////    # 0 0
    /////////////////////////////////////the second strategy  ////////////////////////////////////////////    # 0 #

//////////////////////////////////////////////////////////// defend player logic ////////////////////////////////////////////////////////////////////
        else if(grid[1][1]==grid[2][2] && grid[1][1]==icon){
                 if(check(0,1)){grid[0][1]=opp;return 0;}
            else if(check(1,1)){grid[1][1]=opp;return 0;}
            else if(check(1,0)){grid[1][0]=opp;return 0;}
            else if(check(2,2)){grid[2][2]=opp;return 0;}
        }
        else if(grid[1][1]==grid[0][0] && grid[1][1]==icon){
                 if(check(2,0)){grid[2][0]=opp;return 0;}
            else if(check(2,1)){grid[2][1]=opp;return 0;}
            else if(check(0,2)){grid[0][2]=opp;return 0;}
            else if(check(1,2)){grid[1][2]=opp;return 0;}
        }
        else if(grid[1][1]==grid[0][2] && grid[1][1]==icon){
                 if(check(0,0)){grid[0][0]=opp;return 0;}
            else if(check(1,0)){grid[1][0]=opp;return 0;}
            else if(check(2,1)){grid[2][1]=opp;return 0;}
            else if(check(2,2)){grid[2][2]=opp;return 0;}
        }
        else if(grid[1][1]==grid[2][0] && grid[1][1]==icon){
                 if(check(0,0)){grid[0][0]=opp;return 0;}
            else if(check(0,1)){grid[0][1]=opp;return 0;}
            else if(check(1,2)){grid[1][2]=opp;return 0;}
            else if(check(2,2)){grid[2][2]=opp;return 0;}
        }
        else if(grid[0][0]==grid[2][2] && grid[0][0]==icon){
                 if(check(0,1)){grid[0][1]=opp;return 0;}
            else if(check(1,0)){grid[1][0]=opp;return 0;}
            else if(check(1,2)){grid[1][2]=opp;return 0;}
            else if(check(2,1)){grid[2][1]=opp;return 0;}
        }
        else if(grid[0][2]==grid[2][0] && grid[0][2]==icon){
                 if(check(0,1)){grid[0][1]=opp;return 0;}
            else if(check(1,0)){grid[1][0]=opp;return 0;}
            else if(check(1,2)){grid[1][2]=opp;return 0;}
            else if(check(2,1)){grid[2][1]=opp;return 0;}
        }

        else if(grid[0][1]==grid[1][2] && grid[1][2]==icon && check(0,2)){grid[0][2]=opp;return 0;}
        else if(grid[2][1]==grid[1][2] && grid[1][2]==icon && check(2,2)){grid[2][2]=opp;return 0;}
        else if(grid[1][0]==grid[0][1] && grid[1][0]==icon && check(0,0)){grid[0][0]=opp;return 0;}
        else if(grid[2][1]==grid[1][0] && grid[1][0]==icon && check(2,0)){grid[2][0]=opp;return 0;}
        else return 2;
    }
}

int print_winner(char i){
    if (grid[0][0]==grid[0][1]&&grid[0][1]==grid[0][2]){printf("\n");print_grid();printf("\nThe winner is %c\n\nCongratulations\n\nPlay again?? (Y/N): ",i);return 0;}
    if (grid[1][0]==grid[1][1]&&grid[1][1]==grid[1][2]){printf("\n");print_grid();printf("\nThe winner is %c\n\nCongratulations\n\nPlay again?? (Y/N): ",i);return 0;}
    if (grid[2][0]==grid[2][1]&&grid[2][1]==grid[2][2]){printf("\n");print_grid();printf("\nThe winner is %c\n\nCongratulations\n\nPlay again?? (Y/N): ",i);return 0;}
    if (grid[0][0]==grid[1][1]&&grid[1][1]==grid[2][2]){printf("\n");print_grid();printf("\nThe winner is %c\n\nCongratulations\n\nPlay again?? (Y/N): ",i);return 0;}
    if (grid[0][2]==grid[1][1]&&grid[1][1]==grid[2][0]){printf("\n");print_grid();printf("\nThe winner is %c\n\nCongratulations\n\nPlay again?? (Y/N): ",i);return 0;}
    if (grid[0][0]==grid[1][0]&&grid[1][0]==grid[2][0]){printf("\n");print_grid();printf("\nThe winner is %c\n\nCongratulations\n\nPlay again?? (Y/N): ",i);return 0;}
    if (grid[0][1]==grid[1][1]&&grid[1][1]==grid[2][1]){printf("\n");print_grid();printf("\nThe winner is %c\n\nCongratulations\n\nPlay again?? (Y/N): ",i);return 0;}
    if (grid[0][2]==grid[1][2]&&grid[1][2]==grid[2][2]){printf("\n");print_grid();printf("\nThe winner is %c\n\nCongratulations\n\nPlay again?? (Y/N): ",i);return 0;}

    int tie=0;
    for (int x=0 ; x<3 ; x++){
        for (int y=0 ; y<3 ; y++){
            if(grid[x][y]>='1' && grid[x][y]<='9'){tie++;break;}
        }
    }
    if(tie==0){printf("\n");print_grid();printf("\nTIE\n\nPlay again?? (Y/N): ");return 0;}
    return 1;
}

