# Poker-Game
TDD for poker game
###Poker Game TDD 过程
1. case1
player1:"2H"
player2:"3D"
2. case2
player1:"KC"
player2:"KD"
case1和case2主要用来说明Poker Game的基本功能，也就是直接比较大小分出胜负和平局的情况。
3. case3
player1:"3H","3D"
player2:"KD","AC"
case3是为了通过增加有一对大于没有对子的case，反驳case1的直接比大小的功能，从而driven增加level2的开发。
4. case4
player1:"3H","3D","6D"
player2:"5S","5C","2C"
case4是为了利用都是一对时没有直接进行大小比较，而是还是比牌中最大的bug,也就是上面case是player1赢，从而driven补全两对覆盖率的开发。
5. case5
player1:"KH","KD","3D","5C","AC"
player2:"2S","2C","3H","3D","4C"
case5是为了利用都是两对时直接比较对子中最大点数的bug,也就是上面case是player1赢，从而driven增加level3的开发。
6. case6
player1:"2H","2D","2D","5C","6C"
player2:"KS","KC","JH","JD","AC"
case6是为了利用一个为两对另一个为三个一样时按对子个数多少比较的bug,也就是上面case是player2赢，从而driven增加level4的开发。
7. case7
player1:"4H","4D","4D","5C","6C"
player2:"3S","3C","3H","JD","AC"
case7是为了利用都是三个一样时按牌组中最大点数比较的bug,也就是上面case是player2赢，从而driven补全level4覆盖率的开发。
8. case8
player1:"KH","KD","KD","AC","JC"
player2:"3S","4C","5H","6D","7C"
case8是为了利用三个一样数字level比较高从而player1赢的bug,从而driven增加level5也就是牌组中顺子level更高的开发。
9. case9
player1:"4H","5D","6D","7C","8C"
player2:"3S","4C","5H","6D","7C"
case9是为了利用都是顺子时按牌组中最大点数比较的bug，从而driven补全level5覆盖率的开发。
10. case10
player1:"TH","JD","QD","KC","AC"
player2:"2S","4S","7S","6S","9S"
case10是为了利用顺子level比较高从而player1赢的bug,从而driven增加level6也就是牌组中同花level更高的开发。
