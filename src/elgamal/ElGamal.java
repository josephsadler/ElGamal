package elgamal;

public class ElGamal {

    public static void main(String[] args) {
        int p = 31847;
        int alpha = 5;
        int beta = 18074;

        System.out.println(modExp(5, p - 20, p));
        System.out.println(modInverse(3,7));
        System.out.println(findKey(alpha,beta,p));
        
        System.out.println(modExp(5,7899,p));
        findWord(modExp(5,7899,p));

    }

    /* Performs modular exponentiation
     * Uses the form a^x (mod p) */
    public static int modExp(int a, int x, int p) {
        int r = 1;
        while (x != 0) {
            if (x % 2 == 1) {
                r = (r * a) % p;
            }
            x = x / 2;
            a = (a * a) % p;
        }
        return r;
    }

    /* Performs the extended euclidean algorithm on a % p
     * Used by the modInverse function to find the modular multiplicative inverse */
    public static int[] extendedEuclidean(int a, int p) {
        int x = 0;
        int y = 1;
        int prev_x = 1;
        int prev_y = 0;
        
        while (p != 0) {
            int quotient = a / p;

            int temp = a;
            a = p;
            p = temp % p;

            temp = x;
            x = prev_x - quotient * x;
            prev_x = temp;

            temp = y;
            y = prev_y - quotient * y;
            prev_y = temp;
        }

        int res[] = {prev_x, prev_y, a};
        return res;
    }
    
    /* Obtains the coefficients of ax+py=gcd(a,p)
     * Assumes a is the base, and p is the modular value
     * Calculates the inverse for a */
    public static int modInverse(int a, int p) {
        int res[] = extendedEuclidean(a,p);
        return (res[0] + p) % p;
    }

    /* Solves the discrete log problem
     * The secretKey is found when beta == alpha^secretKey (mod p) */
    public static int findKey(int alpha, int beta, int p) {
        int secretKey = 1;
        
        while(true) {
            if (beta == modExp(alpha,secretKey,p)) {
                return secretKey;
            }
            secretKey++;
        }
    }
    
    /*Translating result to text*/
    public static void findWord(int message){
   int x,y,z;
   z = message%26;
   y = ((message-z)/26)%26;
   x = ((message-z)-(y*26))/(26*26);
  System.out.print(matchWord(x)+matchWord(y)+matchWord(z));
}
    /*Matching numbers with letters*/
    public static String matchWord(int a){
  String x="A";
  switch(a) {
    case 0 :
      x = "A";      
      break;
    case 1 :
      x = "B";      
      break;
    case 2 :
      x = "C";      
      break;
    case 3 :
      x = "D";      
      break;
    case 4 :
      x = "E";      
      break;
    case 5 :
      x = "F";      
      break;
    case 6 :
      x = "G";
      break;
    case 7 :
      x = "H";    
      break;
    case 8 :
      x = "I";
      break;
    case 9 :
      x = "J";
      break;
    case 10 :
      x = "K";
      break;
    case 11 :
      x = "L";   
      break;
    case 12 :
      x = "M";     
      break;
    case 13 :
      x = "N";     
      break;
    case 14 :
      x = "O";    
      break;
    case 15 :
      x = "P";     
      break;
    case 16 :
      x = "Q"; 
      break;
    case 17 :
      x = "R";
      break;
    case 18 :
      x = "S"; 
      break;
    case 19 :
      x = "T";
      break;
    case 20 :
      x = "U";
      break;
    case 21 :
      x = "V";
      break;
    case 22 :
      x = "W"; 
      break;
    case 23 :
      x = "X";
      break;
    case 24 :
      x = "Y";
      break;
    case 25 :
      x = "Z";
      break;
}
  return x;
}
}
