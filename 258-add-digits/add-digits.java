class Solution {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        int sum=0;
        while(num!=0){
        int digit=num%10;
        sum=sum+digit;
        num=num/10;
        }
        return addDigits(sum);

    }
}